package calculator;

import java.util.Stack;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Preston West
 */
public class Calculator
{
    private static final Map<Character, Integer> precedence = new HashMap<>(6);

    // operators -> precedence
    static
    {
        precedence.put('+', 0);
        precedence.put('-', 0);
        precedence.put('*', 1);
        precedence.put('/', 1);
        precedence.put('%', 1);
        precedence.put('^', 2);
    }

    // holds tokens from expression
    private static final List<String> tokens = new ArrayList<>();

    // precision of result
    private static final int precision = 10;


    public static String calculate(String expression) throws SyntaxException
    {
        if (expression.isEmpty())
        {
            return expression;
        }

        Stack<Double> stack = new Stack<>();

        convert(expression);

        for (String token : tokens)
        {
            double op1, op2;

            switch (token)
            {
                case "+":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 + op2);
                    break;

                case "-":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 - op2);
                    break;

                case "*":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 * op2);
                    break;

                case "/":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 / op2);
                    break;

                case "%":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 % op2);
                    break;

                case "^":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(Math.pow(op1, op2));
                    break;

                // is number
                default:
                    stack.push(Double.parseDouble(token));
                    break;
            }
        }

        // format result
        BigDecimal number = new BigDecimal(stack.pop(),
                new MathContext(precision));

        if (number.scale() > 0) // if not integer
        {
            number = number.stripTrailingZeros();
        }

        return number.toString();
    }

    private static void convert(String expression) throws SyntaxException
    {
        // start with empty ArrayList
        tokens.clear();

        Stack<Character> ops = new Stack<>();

        String num = "";

        /**
         * operability of previous symbol
         * used for syntax errors
         */
        boolean isOperable = false;

        int count = 0; // counts open parentheses
        int index = 0; // index of first unmatched parenthesis

        /**
         * use variable instead of function call
         * small speed up (very small)
         */
        int length = expression.length();

        // loop through expression
        for (int i = 0; i < length; i++)
        {
            char temp = expression.charAt(i);

            if (Character.isDigit(temp) || temp == '.')
            {
                num += temp;
            }
            else // is not digit or decimal
            {
                // add previous number to tokens
                if (!num.isEmpty())
                {
                    if (!isNumber(num))
                    {
                        int start = i - num.length();
                        throw new SyntaxException(num, start);
                    }

                    if (isOperable)
                    {
                        push('*', ops);
                    }
                    else
                        isOperable = true;

                    tokens.add(num);
                    num = "";
                }

                if (temp == '(')
                {
                    // implicit multiplication
                    if (isOperable)
                    {
                        push('*', ops);
                        isOperable = false;
                    }

                    if (count == 0)
                    {
                        index = i;
                    }

                    count++;
                    ops.push(temp);
                }
                else if (temp == ')')
                {
                    if (count == 0)
                    {
                        throw new SyntaxException(temp, i);
                    }
                    else if (!isOperable)
                    {
                        // previous character
                        throw new SyntaxException(temp, i - 1);
                    }

                    while (ops.peek() != '(')
                    {
                        tokens.add(String.valueOf(ops.pop()));
                    }

                    count--;
                    ops.pop();
                    isOperable = true;
                }
                else if (precedence.containsKey(temp)) // if valid operator
                {
                    if (i == length - 1) // if op is last
                    {
                        throw new SyntaxException(temp, i);
                    }

                    if (!isOperable)
                    {
                        if (temp == '-')
                        {
                            num = String.valueOf(temp);
                        }
                        else
                            throw new SyntaxException(temp, i);
                    }
                    else
                    {
                        push(temp, ops);
                        isOperable = false;
                    }
                }
                else
                    throw new SyntaxException(temp, i);
            }
        }

        // check num
        if (!num.isEmpty())
        {
            if (!isNumber(num))
            {
                throw new SyntaxException(num, length - num.length());
            }

            if (isOperable)
            {
                push('*', ops);
            }

            tokens.add(num);
        }

        // check ops
        while (!ops.isEmpty())
        {
            char temp = ops.pop();

            if (temp != '(')
            {
                tokens.add(String.valueOf(temp));
            }
            else
                throw new SyntaxException('(', index);
        }
    }

    private static void push(char symbol, Stack<Character> ops)
    {
        while (!ops.isEmpty()
                && !hasHigherPrecedence(symbol, ops.peek()))
        {
            tokens.add(String.valueOf(ops.pop()));
        }

        ops.push(symbol);
    }

    private static boolean hasHigherPrecedence(char first, char second)
    {
        if (precedence.containsKey(second)) // if operator
        {
            return precedence.get(first) > precedence.get(second);
        }

        return true;
    }

    /**
     * Tests if a string is numerical using a regular expression.
     *
     * @param number the number to test
     * @return       true if and only if the specified string is numerical
     */
    private static boolean isNumber(String number)
    {
        return number.matches("-?(0|[1-9][0-9]*)(\\.[0-9]+)?");
    }
}