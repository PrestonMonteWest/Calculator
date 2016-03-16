package calculator;

/**
 *
 * @author Preston West
 */
public class SyntaxException extends Exception
{
    public SyntaxException()
    {
        super("Syntax Error");
    }

    public SyntaxException(int i) // position
    {
        super("Syntax Error: " + i);
    }

    public SyntaxException(char c) // symbol
    {
        super("Syntax Error: " + c);
    }

    public SyntaxException(char c, int i) // position and symbol
    {
        super(String.format("Syntax Error: %s at %d", c, i));
    }
}