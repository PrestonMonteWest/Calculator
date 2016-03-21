package calculator;

/**
 *
 * @author Preston West
 */
public class SyntaxException extends Exception
{
    private final String error;
    private final int index;

    public SyntaxException()
    {
        super("Syntax Error");
        error = "";
        index = 0;
    }

    public SyntaxException(int index)
    {
        super("Syntax Error");
        error = "";
        this.index = index;
    }

    public SyntaxException(char error)
    {
        super("Syntax Error");
        this.error = String.valueOf(error);
        index = 0;
    }

    public SyntaxException(char error, int index)
    {
        super("Syntax Error");
        this.error = String.valueOf(error);
        this.index = index;
    }

    public SyntaxException(String error)
    {
        super("Syntax Error");
        this.error = error;
        index = 0;
    }

    public SyntaxException(String error, int index)
    {
        super("Syntax Error");
        this.error = error;
        this.index = index;
    }

    public int getIndex()
    {
        return index;
    }

    public String getError()
    {
        return error;
    }
}