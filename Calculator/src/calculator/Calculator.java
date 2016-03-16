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
    private static final int precision = 9;


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
                    if (stack.size() == 1)
                    {
                        stack.push(-stack.pop());
                    }
                    else
                    {
                        op2 = stack.pop();
                        op1 = stack.pop();
                        stack.push(op1 - op2);
                    }

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

        /*
         *  operability of previous symbol
         *  used for syntax errors
         */
        boolean isOperable = false;

        int count = 0; // counts open parentheses
        int index = 0; // index of first unmatched parenthesis

        // loop through expression
        for (int i = 0; i < expression.length(); i++)
        {
            char temp = expression.charAt(i);

            if (Character.isDigit(temp) || temp == '.')
            {
                // removes leading zeros
                if (num.startsWith("0"))
                {
                    num = String.valueOf(temp);
                }
                else
                {
                    num += temp;
                }
            }
            else // is not digit or decimal
            {
                // add previous number to tokens
                if (!num.isEmpty())
                {
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
                    if (count == 0 || !isOperable)
                    {
                        throw new SyntaxException(temp, i + 1);
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
                    if (!isOperable)
                    {
                        throw new SyntaxException(temp, i + 1);
                    }

                    push(temp, ops);
                    isOperable = false;
                }
                else
                    throw new SyntaxException(temp, i + 1);
            }
        }

        // empty num
        if (!num.isEmpty())
        {
            if (isOperable)
            {
                push('*', ops);
            }

            tokens.add(num);
        }

        // empty ops
        while (!ops.isEmpty())
        {
            char temp = ops.pop();

            if (temp != '(')
            {
                tokens.add(String.valueOf(temp));
            }
            else
                throw new SyntaxException('(', index + 1);
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
}