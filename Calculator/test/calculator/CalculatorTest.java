package calculator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Preston West
 */
public class CalculatorTest {

    public CalculatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * test of calculate method of class Calculator
     */
    @Test
    public void testCalculate() {
        System.out.println("calculate");

        String[] expressions = {
            "0",
            "7)",
            "1*4.1234",
            "8.1(7.2(5.4-4)^(0.5))",
            "5*6((4.3-3)",
            "*",
            "8//8",
            "(1+2)2.5",
            "()",
            "",
            "10^1000",
            "4.3*-7+-2",
            "7+-+",
            "(9+-)",
            ".5",
            "9.",
            "(1).9"
        };

        String[] answers = {
            "0",
            "Syntax Error",
            "4.1234",
            "69.0051546",
            "Syntax Error",
            "Syntax Error",
            "Syntax Error",
            "7.5",
            "Syntax Error",
            "",
            "Infinite or NaN",
            "-32.1",
            "Syntax Error",
            "Syntax Error",
            "Syntax Error",
            "Syntax Error",
            "Syntax Error"
        };

        String[] results = new String[answers.length];

        for (int i = 0; i < expressions.length; i++)
        {
            try
            {
                results[i] = Calculator.calculate(expressions[i]);
            }
            catch (NumberFormatException | SyntaxException e)
            {
                results[i] = e.getMessage();
            }
        }

        assertArrayEquals(answers, results);
    }
}
