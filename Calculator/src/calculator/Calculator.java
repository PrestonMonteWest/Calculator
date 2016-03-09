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
    static
    {
        precedence.put('+', 0);
        precedence.put('-', 0);
        precedence.put('*', 1);
        precedence.put('/', 1);
        precedence.put('%', 1);
        precedence.put('^', 2);
    }

    private static final List<String> tokens = new ArrayList<>();
    private static final int precision = 9;

    public static String calculate(String expression)
    {
        Stack<Double> stack = new Stack<>();

        try
        {
            convert(expression);
        }
        catch (SyntaxException e)
        {
            tokens.clear();
            return e.getMessage();
        }

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

                default:
                    stack.push(Double.parseDouble(token));
                    break;
            }
        }

        tokens.clear();

        BigDecimal number = new BigDecimal(stack.pop(),
                new MathContext(precision));

        if (number.scale() > 0)
        {
            number = number.stripTrailingZeros();
        }

        return number.toString();
    }

    private static void convert(String expression) throws SyntaxException
    {
        Stack<Character> ops = new Stack<>();

        String num = "";
        boolean isOperable = false;

        int count = 0; // counts open parentheses
        int index = 0; // index of first unmatched parenthesis

        for (int i = 0; i < expression.length(); i++)
        {
            char temp = expression.charAt(i);

            if (Character.isDigit(temp) || temp == '.')
            {
                if (num.startsWith("0"))
                {
                    num = String.valueOf(temp);
                }
                else
                {
                    num += temp;
                }
            }
            else
            {
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

                switch (temp)
                {
                    case '(':
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
                        break;

                    case ')':
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
                        break;

                    case '+':
                    case '-':
                    case '*':
                    case '/':
                    case '%':
                    case '^':
                        if (!isOperable)
                        {
                            throw new SyntaxException(temp, i + 1);
                        }

                        push(temp, ops);
                        isOperable = false;
                        break;

                    default:
                        throw new SyntaxException(temp, i + 1);
                }
            }
        }

        if (!num.isEmpty())
        {
            if (isOperable)
            {
                push('*', ops);
            }

            tokens.add(num);
        }

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
        if (precedence.containsKey(second))
        {
            return precedence.get(first) > precedence.get(second);
        }

        return true;
    }
}