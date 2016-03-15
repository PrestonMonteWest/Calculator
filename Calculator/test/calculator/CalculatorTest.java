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
            "0", "7)", "1*4.1234", "8.1(7.2(5.4-4)^(0.5))",
<<<<<<< HEAD
            "5*6((4.3-3)", "*", "8//8", "(1+2)2.5", "()", "",
            "10^1000"
=======
            "5*6((4.3-3)", "*", "8//8", "(1+2)2.5", "()"
>>>>>>> origin/master
        };

        String[] answers = {
            "0", "Syntax Error: ) at 2", "4.1234", "69.0051546",
            "Syntax Error: ( at 4", "Syntax Error: * at 1",
<<<<<<< HEAD
            "Syntax Error: / at 3", "7.5", "Syntax Error: ) at 2",
            "", "Infinite or NaN"
=======
            "Syntax Error: / at 3", "7.5", "Syntax Error: ) at 2"
>>>>>>> origin/master
        };

        String[] results = new String[answers.length];

        for (int i = 0; i < expressions.length; i++)
        {
<<<<<<< HEAD
            try
            {
                results[i] = Calculator.calculate(expressions[i]);
            }
            catch (NumberFormatException | SyntaxException e)
            {
                results[i] = e.getMessage();
            }
=======
            results[i] = Calculator.calculate(expressions[i]);
>>>>>>> origin/master
        }

        assertArrayEquals(answers, results);
    }
}
