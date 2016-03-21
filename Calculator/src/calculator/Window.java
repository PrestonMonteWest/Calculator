package calculator;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.*;
import java.math.BigDecimal;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class Window extends JFrame implements ActionListener,
        ListSelectionListener
{
    // line number of current expression
    private int line;

    public Window()
    {
        // sets title
        super("Awesome Calculator");

        line = 0;

        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        seven = new javax.swing.JButton();
        eight = new javax.swing.JButton();
        five = new javax.swing.JButton();
        two = new javax.swing.JButton();
        three = new javax.swing.JButton();
        six = new javax.swing.JButton();
        nine = new javax.swing.JButton();
        one = new javax.swing.JButton();
        four = new javax.swing.JButton();
        decimal = new javax.swing.JButton();
        equals = new javax.swing.JButton();
        zero = new javax.swing.JButton();
        add = new javax.swing.JButton();
        leftP = new javax.swing.JButton();
        multiply = new javax.swing.JButton();
        mod = new javax.swing.JButton();
        subtract = new javax.swing.JButton();
        rightP = new javax.swing.JButton();
        divide = new javax.swing.JButton();
        exponent = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        answer = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        result = new javax.swing.JTextField();
        conversions = new javax.swing.JList();
        pane = new javax.swing.JScrollPane();
        expressions = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        seven.setFont(seven.getFont());
        seven.setText("7");
        seven.addActionListener(this);

        eight.setFont(eight.getFont());
        eight.setText("8");
        eight.addActionListener(this);

        five.setFont(five.getFont());
        five.setText("5");
        five.addActionListener(this);

        two.setFont(two.getFont());
        two.setText("2");
        two.addActionListener(this);

        three.setFont(three.getFont());
        three.setText("3");
        three.addActionListener(this);

        six.setFont(six.getFont());
        six.setText("6");
        six.addActionListener(this);

        nine.setFont(nine.getFont());
        nine.setText("9");
        nine.addActionListener(this);

        one.setFont(one.getFont());
        one.setText("1");
        one.addActionListener(this);

        four.setFont(four.getFont());
        four.setText("4");
        four.addActionListener(this);

        decimal.setFont(decimal.getFont());
        decimal.setText(".");
        decimal.addActionListener(this);

        equals.setFont(equals.getFont());
        equals.setText("=");
        equals.addActionListener(this);

        zero.setFont(zero.getFont());
        zero.setText("0");
        zero.addActionListener(this);

        add.setFont(add.getFont());
        add.setText("+");
        add.addActionListener(this);

        leftP.setFont(leftP.getFont());
        leftP.setText("(");
        leftP.addActionListener(this);

        multiply.setFont(multiply.getFont());
        multiply.setText("*");
        multiply.addActionListener(this);

        mod.setFont(mod.getFont().deriveFont(mod.getFont().getSize() - 1.75f));
        mod.setText("mod");
        mod.addActionListener(this);

        subtract.setFont(subtract.getFont());
        subtract.setText("-");
        subtract.addActionListener(this);

        rightP.setFont(rightP.getFont());
        rightP.setText(")");
        rightP.addActionListener(this);

        divide.setFont(divide.getFont());
        divide.setText("/");
        divide.addActionListener(this);

        exponent.setFont(exponent.getFont());
        exponent.setText("^");
        exponent.addActionListener(this);

        delete.setFont(delete.getFont());
        delete.setText("Del");
        delete.addActionListener(this);

        answer.setFont(answer.getFont());
        answer.setText("Ans");
        answer.addActionListener(this);

        clear.setFont(clear.getFont());
        clear.setText("Clr");
        clear.addActionListener(this);

        result.setEditable(false);
        result.setFont(result.getFont());
        result.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        result.setFocusable(false);

        conversions.setFont(conversions.getFont().deriveFont(conversions.getFont().getSize() - 3f));
        conversions.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {"Feet - Meters", "Meters - Feet", "Gallons - Liters", "Liters - Gallons", "Pounds - Kilograms", "Kilograms - Pounds"};

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        conversions.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        conversions.setVisibleRowCount(6);

        expressions.setEditable(false);
        expressions.setFont(expressions.getFont());
        pane.setViewportView(expressions);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(zero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(decimal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(equals, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(leftP, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(multiply, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(mod, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(rightP, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(divide, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(exponent, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(subtract, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(conversions)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pane)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(conversions)
                                .addComponent(pane))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(leftP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mod, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(multiply, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(equals, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(rightP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(exponent, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(divide, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(subtract, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(zero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(decimal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
        ); // </editor-fold>

        pack();

        // center the calculator
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent event) // button event
    {
        String command = event.getActionCommand();

        // if number, operation, or parentheses
        if (!command.equals("Clr") && !command.equals("Del")
                && !command.equals("Ans") && !command.equals("="))
        {
            String text = expressions.getText() + command;

            // removes all highlights
            expressions.setText(text);
        }
        else
        {
            // implements Clr, Del, Ans, and "="
            switch (command)
            {
                // clear everything
                case "Clr":
                    expressions.setText("");
                    result.setText("");
                    line = 0;
                    break;

                case "Del":
                    try
                    {
                        int start = expressions.getLineStartOffset(line);
                        int end = expressions.getLineEndOffset(line);
                        int length = end - start;

                        if (length > 0) // if current expression not empty
                        {
                            // delete one character
                            expressions.setText(
                                    expressions.getText(0, end - 1)
                            );
                        }
                    }
                    catch (BadLocationException e)
                    {
                        e.printStackTrace();
                    }

                    break;

                case "Ans":
                    String insert = result.getText();

                    if (insert.contains("E")) // scientific notation
                    {
                        String[] args = insert.split("E");

                        try
                        {
                            BigDecimal base = new BigDecimal(args[0]);
                            BigDecimal power = new BigDecimal(args[1]);

                            if (base.scale() > 0)
                            {
                                base = base.stripTrailingZeros();
                            }

                            if (power.scale() > 0)
                            {
                                power = power.stripTrailingZeros();
                            }

                            insert = "(" + base + "^" + power + ")";
                        }
                        catch (NumberFormatException e)
                        {
                            insert = null;
                        }
                    }
                    else
                    {
                        insert = "(" + insert + ")";
                    }

                    // inject previous result into current expression
                    expressions.append(insert);

                    break;

                case "=":
                    String calculation = null;

                    // make the compiler happy
                    int start = 0;

                    int length;

                    try
                    {
                        start = expressions.getLineStartOffset(line);
                        length = expressions.getLineEndOffset(line) - start;

                        // calculate current expression
                        calculation = Calculator.calculate(
                                expressions.getText(start, length)
                        );
                    }
                    catch (BadLocationException e)
                    {
                        e.printStackTrace();
                    }
                    catch (NumberFormatException e)
                    {
                        calculation = e.getMessage();
                    }
                    catch (SyntaxException e)
                    {
                        calculation = e.getMessage();

                        Highlighter.HighlightPainter p = new DefaultHighlighter
                                .DefaultHighlightPainter(Color.red);

                        Highlighter hl = expressions.getHighlighter();

                        start += e.getIndex();

                        try
                        {
                            hl.addHighlight(
                                    start, start + e.getError().length(), p
                            );
                        }
                        catch (BadLocationException ex)
                        {
                            ex.printStackTrace();
                        }
                    }

                    // set result field to answer
                    result.setText(calculation);

                    // start new expression
                    expressions.append("\n");

                    // update line number
                    line++;

                    break;
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) // list event
    {
        /*
         *  Implement what should be done
         *  when list item is selected.
         */
    }

    public static void main(String[] args)
    {
        // fancy way of starting JFrame
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new Window().setVisible(true);
            }
        });
    }

    // operations
    private javax.swing.JButton add;
    private javax.swing.JButton subtract;
    private javax.swing.JButton multiply;
    private javax.swing.JButton divide;
    private javax.swing.JButton exponent;
    private javax.swing.JButton mod;

    // parentheses
    private javax.swing.JButton leftP;
    private javax.swing.JButton rightP;

    // conversion functions list
    private javax.swing.JList conversions;

    // delete functionality
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;

    // represents previous answer
    private javax.swing.JButton answer;

    // TextArea for entering expressions
    private javax.swing.JTextArea expressions;
    private javax.swing.JScrollPane pane;

    // holds result of calculation
    private javax.swing.JTextField result;

    // numbers and decimal
    private javax.swing.JButton decimal;
    private javax.swing.JButton eight;
    private javax.swing.JButton equals;
    private javax.swing.JButton five;
    private javax.swing.JButton four;
    private javax.swing.JButton nine;
    private javax.swing.JButton one;
    private javax.swing.JButton seven;
    private javax.swing.JButton six;
    private javax.swing.JButton three;
    private javax.swing.JButton two;
    private javax.swing.JButton zero;
}