package calculator;

import java.util.Stack;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author Preston West
 */
public class Calculator
{
    static final Deque<String> memory = new ArrayDeque<>(10);

    private static final List<String> tokens = new ArrayList<>();

    public static BigDecimal calculate(String expression)
    {

        if (memory.size() == 10)
        {
            memory.remove();
        }

        memory.add(expression);

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

                default:
                    stack.push(Double.parseDouble(token));

                    break;
            }
        }

        tokens.clear();

        return new BigDecimal(stack.pop(), new MathContext(10))
                .stripTrailingZeros();
    }

    private static void convert(String expression)
    {
        Stack<Character> ops = new Stack<>();
        String num = "";

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
                    tokens.add(num);
                    num = "";
                }

                switch (temp)
                {
                    case '(':
                        ops.push(temp);
                        break;

                    case ')':
                        while (!ops.isEmpty() && ops.peek() != '(')
                        {
                            tokens.add(String.valueOf(ops.pop()));
                        }

                        ops.pop();
                        break;

                    case '+':
                    case '-':
                        while (!ops.isEmpty() && ops.peek() != '(')
                            tokens.add(String.valueOf(ops.pop()));

                        ops.push(temp);
                        break;

                    case '*':
                    case '/':
                    case '%':
                        while (!ops.isEmpty() && ops.peek() != '('
                                && ops.peek() != '+' && ops.peek() != '-')
                        {
                            tokens.add(String.valueOf(ops.pop()));
                        }

                        ops.push(temp);
                        break;

                    case '^':
                        while (!ops.isEmpty() && ops.peek() != '('
                                && ops.peek() == '^')
                        {
                            tokens.add(String.valueOf(ops.pop()));
                        }

                        ops.push(temp);
                        break;
                }
            }
        }

        if (!num.isEmpty())
        {
            tokens.add(num);
        }

        while (!ops.isEmpty())
        {
            char temp = ops.pop();

            if (temp != '(')
            {
                tokens.add(String.valueOf(temp));
            }
        }
    }
}