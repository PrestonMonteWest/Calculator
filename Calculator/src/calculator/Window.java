package calculator;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Window extends javax.swing.JFrame implements ListSelectionListener
{
    // points to current expression
    private int pointer;

    // tag for current highlight
    private Object highlight;

    // highlight colors                    R   G  B   A
    private final Color error = new Color(255, 0, 0, 100); // light red
    private final Color selection = new Color(0, 0, 255, 50); // light blue

    // button colors
    private final Color init;
    private final Color change = Color.CYAN;

    // used for line count in expressions
    private final int MAX = 10;

    // number mapping for buttons
    JButton[] buttons;

    /**
     * Creates new form Window
     */
    public Window()
    {
        // sets title
        super("Awesome Calculator");

        // generated design code
        initComponents();

        conversions.addListSelectionListener(this);

        // sets up the map
        buttons = new JButton[]{
            zero, one, two, three, four,
            five, six, seven, eight, nine
        };

        // stores the initial button color
        init = zero.getBackground();

        // center frame on screen
        setLocationRelativeTo(null);

        // don't have to worry about component focus
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher(new KeyEventDispatcher()
                    {
                        @Override
                        public boolean dispatchKeyEvent(KeyEvent event)
                        {
                            if (event.getID() == KeyEvent.KEY_PRESSED)
                            {
                                keyPressed(event);
                            }

                            return false;
                        }
                    }
                );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seven = new javax.swing.JButton();
        nine = new javax.swing.JButton();
        five = new javax.swing.JButton();
        eight = new javax.swing.JButton();
        four = new javax.swing.JButton();
        six = new javax.swing.JButton();
        three = new javax.swing.JButton();
        one = new javax.swing.JButton();
        two = new javax.swing.JButton();
        zero = new javax.swing.JButton();
        decimal = new javax.swing.JButton();
        equals = new javax.swing.JButton();
        add = new javax.swing.JButton();
        subtract = new javax.swing.JButton();
        mod = new javax.swing.JButton();
        exponent = new javax.swing.JButton();
        divide = new javax.swing.JButton();
        multiply = new javax.swing.JButton();
        leftP = new javax.swing.JButton();
        rightP = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        answer = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        pane = new javax.swing.JScrollPane();
        expressions = new javax.swing.JTextArea();
        result = new javax.swing.JTextField();
        conversions = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                appClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                appLaunch(evt);
            }
        });

        seven.setFont(seven.getFont().deriveFont((seven.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        seven.setText("7");
        seven.setFocusPainted(false);
        seven.setFocusable(false);
        seven.setMaximumSize(new java.awt.Dimension(60, 35));
        seven.setMinimumSize(new java.awt.Dimension(60, 35));
        seven.setPreferredSize(new java.awt.Dimension(60, 35));
        seven.setRequestFocusEnabled(false);
        seven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        nine.setFont(nine.getFont().deriveFont((nine.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        nine.setText("9");
        nine.setFocusPainted(false);
        nine.setFocusable(false);
        nine.setMaximumSize(new java.awt.Dimension(60, 35));
        nine.setMinimumSize(new java.awt.Dimension(60, 35));
        nine.setPreferredSize(new java.awt.Dimension(60, 35));
        nine.setRequestFocusEnabled(false);
        nine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        five.setFont(five.getFont().deriveFont((five.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        five.setText("5");
        five.setFocusPainted(false);
        five.setFocusable(false);
        five.setMaximumSize(new java.awt.Dimension(60, 35));
        five.setMinimumSize(new java.awt.Dimension(60, 35));
        five.setPreferredSize(new java.awt.Dimension(60, 35));
        five.setRequestFocusEnabled(false);
        five.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        eight.setFont(eight.getFont().deriveFont((eight.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        eight.setText("8");
        eight.setFocusPainted(false);
        eight.setFocusable(false);
        eight.setMaximumSize(new java.awt.Dimension(60, 35));
        eight.setMinimumSize(new java.awt.Dimension(60, 35));
        eight.setPreferredSize(new java.awt.Dimension(60, 35));
        eight.setRequestFocusEnabled(false);
        eight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        four.setFont(four.getFont().deriveFont((four.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        four.setText("4");
        four.setFocusPainted(false);
        four.setFocusable(false);
        four.setMaximumSize(new java.awt.Dimension(60, 35));
        four.setMinimumSize(new java.awt.Dimension(60, 35));
        four.setPreferredSize(new java.awt.Dimension(60, 35));
        four.setRequestFocusEnabled(false);
        four.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        six.setFont(six.getFont().deriveFont((six.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        six.setText("6");
        six.setFocusPainted(false);
        six.setFocusable(false);
        six.setMaximumSize(new java.awt.Dimension(60, 35));
        six.setMinimumSize(new java.awt.Dimension(60, 35));
        six.setPreferredSize(new java.awt.Dimension(60, 35));
        six.setRequestFocusEnabled(false);
        six.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        three.setFont(three.getFont().deriveFont((three.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        three.setText("3");
        three.setFocusPainted(false);
        three.setFocusable(false);
        three.setMaximumSize(new java.awt.Dimension(60, 35));
        three.setMinimumSize(new java.awt.Dimension(60, 35));
        three.setPreferredSize(new java.awt.Dimension(60, 35));
        three.setRequestFocusEnabled(false);
        three.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        one.setFont(one.getFont().deriveFont((one.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        one.setText("1");
        one.setFocusPainted(false);
        one.setFocusable(false);
        one.setMaximumSize(new java.awt.Dimension(60, 35));
        one.setMinimumSize(new java.awt.Dimension(60, 35));
        one.setPreferredSize(new java.awt.Dimension(60, 35));
        one.setRequestFocusEnabled(false);
        one.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        two.setFont(two.getFont().deriveFont((two.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        two.setText("2");
        two.setFocusPainted(false);
        two.setFocusable(false);
        two.setMaximumSize(new java.awt.Dimension(60, 35));
        two.setMinimumSize(new java.awt.Dimension(60, 35));
        two.setPreferredSize(new java.awt.Dimension(60, 35));
        two.setRequestFocusEnabled(false);
        two.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        zero.setFont(zero.getFont().deriveFont((zero.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        zero.setText("0");
        zero.setFocusPainted(false);
        zero.setFocusable(false);
        zero.setMaximumSize(new java.awt.Dimension(60, 35));
        zero.setMinimumSize(new java.awt.Dimension(60, 35));
        zero.setPreferredSize(new java.awt.Dimension(60, 35));
        zero.setRequestFocusEnabled(false);
        zero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        decimal.setFont(decimal.getFont().deriveFont((decimal.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        decimal.setText(".");
        decimal.setFocusPainted(false);
        decimal.setFocusable(false);
        decimal.setMaximumSize(new java.awt.Dimension(60, 35));
        decimal.setMinimumSize(new java.awt.Dimension(60, 35));
        decimal.setPreferredSize(new java.awt.Dimension(60, 35));
        decimal.setRequestFocusEnabled(false);
        decimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        equals.setFont(equals.getFont().deriveFont((equals.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        equals.setText("=");
        equals.setFocusPainted(false);
        equals.setFocusable(false);
        equals.setMaximumSize(new java.awt.Dimension(60, 35));
        equals.setMinimumSize(new java.awt.Dimension(60, 35));
        equals.setPreferredSize(new java.awt.Dimension(60, 35));
        equals.setRequestFocusEnabled(false);
        equals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        add.setFont(add.getFont().deriveFont((add.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        add.setText("+");
        add.setFocusPainted(false);
        add.setFocusable(false);
        add.setMaximumSize(new java.awt.Dimension(60, 35));
        add.setMinimumSize(new java.awt.Dimension(60, 35));
        add.setPreferredSize(new java.awt.Dimension(60, 35));
        add.setRequestFocusEnabled(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        subtract.setFont(subtract.getFont().deriveFont((subtract.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        subtract.setText("-");
        subtract.setFocusPainted(false);
        subtract.setFocusable(false);
        subtract.setMaximumSize(new java.awt.Dimension(60, 35));
        subtract.setMinimumSize(new java.awt.Dimension(60, 35));
        subtract.setPreferredSize(new java.awt.Dimension(60, 35));
        subtract.setRequestFocusEnabled(false);
        subtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        mod.setFont(mod.getFont().deriveFont((mod.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD, mod.getFont().getSize()-1));
        mod.setText("mod");
        mod.setActionCommand("%");
        mod.setFocusPainted(false);
        mod.setFocusable(false);
        mod.setMaximumSize(new java.awt.Dimension(60, 35));
        mod.setMinimumSize(new java.awt.Dimension(60, 35));
        mod.setPreferredSize(new java.awt.Dimension(60, 35));
        mod.setRequestFocusEnabled(false);
        mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        exponent.setFont(exponent.getFont().deriveFont((exponent.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        exponent.setText("^");
        exponent.setFocusPainted(false);
        exponent.setFocusable(false);
        exponent.setMaximumSize(new java.awt.Dimension(60, 35));
        exponent.setMinimumSize(new java.awt.Dimension(60, 35));
        exponent.setPreferredSize(new java.awt.Dimension(60, 35));
        exponent.setRequestFocusEnabled(false);
        exponent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        divide.setFont(divide.getFont().deriveFont((divide.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        divide.setText("/");
        divide.setFocusPainted(false);
        divide.setFocusable(false);
        divide.setMaximumSize(new java.awt.Dimension(60, 35));
        divide.setMinimumSize(new java.awt.Dimension(60, 35));
        divide.setPreferredSize(new java.awt.Dimension(60, 35));
        divide.setRequestFocusEnabled(false);
        divide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        multiply.setFont(multiply.getFont().deriveFont((multiply.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        multiply.setText("*");
        multiply.setFocusPainted(false);
        multiply.setFocusable(false);
        multiply.setMaximumSize(new java.awt.Dimension(60, 35));
        multiply.setMinimumSize(new java.awt.Dimension(60, 35));
        multiply.setPreferredSize(new java.awt.Dimension(60, 35));
        multiply.setRequestFocusEnabled(false);
        multiply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        leftP.setFont(leftP.getFont().deriveFont((leftP.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        leftP.setText("(");
        leftP.setFocusPainted(false);
        leftP.setFocusable(false);
        leftP.setMaximumSize(new java.awt.Dimension(60, 35));
        leftP.setMinimumSize(new java.awt.Dimension(60, 35));
        leftP.setPreferredSize(new java.awt.Dimension(60, 35));
        leftP.setRequestFocusEnabled(false);
        leftP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        rightP.setFont(rightP.getFont().deriveFont((rightP.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD));
        rightP.setText(")");
        rightP.setFocusPainted(false);
        rightP.setFocusable(false);
        rightP.setMaximumSize(new java.awt.Dimension(60, 35));
        rightP.setMinimumSize(new java.awt.Dimension(60, 35));
        rightP.setPreferredSize(new java.awt.Dimension(60, 35));
        rightP.setRequestFocusEnabled(false);
        rightP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        delete.setFont(delete.getFont().deriveFont((delete.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD, delete.getFont().getSize()-1));
        delete.setText("Del");
        delete.setFocusPainted(false);
        delete.setFocusable(false);
        delete.setMaximumSize(new java.awt.Dimension(55, 35));
        delete.setMinimumSize(new java.awt.Dimension(55, 35));
        delete.setPreferredSize(new java.awt.Dimension(55, 35));
        delete.setRequestFocusEnabled(false);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        answer.setFont(answer.getFont().deriveFont((answer.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD, answer.getFont().getSize()-1));
        answer.setText("Ans");
        answer.setFocusPainted(false);
        answer.setFocusable(false);
        answer.setMaximumSize(new java.awt.Dimension(55, 35));
        answer.setMinimumSize(new java.awt.Dimension(55, 35));
        answer.setPreferredSize(new java.awt.Dimension(55, 35));
        answer.setRequestFocusEnabled(false);
        answer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        clear.setFont(clear.getFont().deriveFont((clear.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD, clear.getFont().getSize()-1));
        clear.setText("Clr");
        clear.setFocusPainted(false);
        clear.setFocusable(false);
        clear.setMaximumSize(new java.awt.Dimension(55, 35));
        clear.setMinimumSize(new java.awt.Dimension(55, 35));
        clear.setPreferredSize(new java.awt.Dimension(55, 35));
        clear.setRequestFocusEnabled(false);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClicked(evt);
            }
        });

        expressions.setEditable(false);
        expressions.setFocusable(false);
        expressions.setRequestFocusEnabled(false);
        pane.setViewportView(expressions);

        result.setEditable(false);
        result.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        result.setFocusable(false);
        result.setRequestFocusEnabled(false);

        conversions.setFont(conversions.getFont().deriveFont(conversions.getFont().getStyle() & ~java.awt.Font.BOLD, conversions.getFont().getSize()-1));
        conversions.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Feet - Meters", "Meters - Feet", "Pounds - Kilograms", "Kilograms - Pounds", "Gallons - Liters", "Liters - Gallons" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        conversions.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        conversions.setFixedCellHeight(15);
        conversions.setFocusable(false);
        conversions.setVisibleRowCount(6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(multiply, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(divide, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(leftP, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rightP, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exponent, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mod, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(zero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(decimal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(equals, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subtract, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(conversions, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(result))
                            .addComponent(pane))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(conversions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pane, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leftP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exponent, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mod, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(divide, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(multiply, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zero, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decimal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(equals, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subtract, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClicked
        // gets the command
        String command = evt.getActionCommand();

        // if number, operation, or parentheses
        if (!command.equals("Clr") && !command.equals("Del")
                && !command.equals("Ans") && !command.equals("="))
        {
            reset();
            expressions.append(command);
        }
        else
        {
            // implements Clr, Del, Ans, and '='
            switch (command)
            {
                // clear everything
                case "Clr":
                    expressions.setText("");
                    result.setText("");
                    pointer = 0;
                    break;

                case "Del":
                    deleteChar();

                    break;

                case "Ans":
                    insertAns();

                    break;

                case "=":
                    calculate();

                    break;
            }
        }
    }//GEN-LAST:event_buttonClicked

    /**
     * This method is called upon opening of the application.
     * The presence of an existing data file is checked for
     * and if it exists, is loaded into the expressions window.
     */
    private void appLaunch(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_appLaunch
        String path = System.getProperty("user.dir"); // Get the application path
        File f = new File(path + File.separator + "expressions.txt"); // Create a file object

        if(f.exists()) // file exists
        {
            try
            {
                FileReader fr = new FileReader(f); // Create a reader
                BufferedReader br = new BufferedReader(fr); // Create a buffer for the reader
                int charCode;

                // includes newline characters
                while((charCode = br.read()) != -1) // Read the file
                {
                    expressions.append(String.valueOf((char)charCode));
                }

                // set pointer to last line
                // if expressions empty, then pointer = 0
                pointer = getLastLine();

                fr.close();
            }
            catch(FileNotFoundException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(), "File Not Found Exception", JOptionPane.ERROR_MESSAGE);
            }
            catch(IOException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(), "IO Exception", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_appLaunch

    /**
     * This method is called upon closing the application in order to
     * save the expression(s) stored in the expressions window to a file.
     * The files location is the application directory.
     */
    private void appClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_appClosing
        String path = System.getProperty("user.dir"); // Get the application path
        File f = new File(path + File.separator + "expressions.txt"); // Create a file object for the path

        if(!f.exists()) // File does not exist
        {
            try
            {
                f.createNewFile(); // Create the file
            }
            catch(IOException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(), "IO Exception", JOptionPane.ERROR_MESSAGE);
            }
        }

        try // Write the contents of the expressions window to the file
        {
            FileWriter fw = new FileWriter(f);
            fw.write(expressions.getText());
            fw.close();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "IO Exception", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_appClosing

    private void deleteChar()
    {
        try
        {
            String current = getLineText(getLastLine());

            if (!current.isEmpty())
            {
                Document doc = expressions.getDocument();

                // delete last character
                doc.remove(doc.getLength() - 1, 1);

                reset();
            }
        }
        catch (BadLocationException e)
        {
            e.printStackTrace();
        }
    }

    private void insertAns()
    {
        String insert = result.getText();

        if (!insert.isEmpty())
        {
            StringBuilder sb = new StringBuilder();

            if (insert.contains("E")) // if in scientific notation
            {
                String[] args = insert.split("E");

                try
                {
                    BigDecimal number = new BigDecimal(args[0]);
                    BigDecimal power = new BigDecimal(args[1]);

                    if (number.scale() > 0)
                    {
                        number = number.stripTrailingZeros();
                    }

                    if (power.scale() > 0)
                    {
                        power = power.stripTrailingZeros();
                    }

                    sb.append("(");
                    sb.append(number);
                    sb.append("*");
                    sb.append(10);
                    sb.append("^");
                    sb.append(power);
                    sb.append(")");
                }
                catch (NumberFormatException e)
                {
                    return;
                }
            }
            else
            {
                sb.append("(");
                sb.append(insert);
                sb.append(")");
            }

            insert = sb.toString();
            reset();
        }

        // insert previous result into current expression
        expressions.append(insert);
    }

    private void calculate()
    {
        String calculation = null;

        // flag for pointer
        boolean newLine = false;

        try
        {
            String expression;

            if (pointer == getLastLine()) // if new expression
            {
                expression = getLineText(pointer);

                if (expression.isEmpty())
                {
                    // don't do anything
                    return;
                }

                /*
                starts a new expression
                (sloppily) fixes highlighting bug as well
                */
                expressions.append("\n");

                if (highlight != null)
                {
                    removeHighlight();
                }

                newLine = true;
            }
            else
            {
                expression = getLineText(pointer);
            }

            // calculate selected expression
            calculation = Calculator.calculate(expression);
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

            try
            {
                int start = expressions.getLineStartOffset(pointer);

                // find start of error
                start += e.getIndex();

                int end = start + e.getError().length();

                highlight(start, end, error);
            }
            catch (BadLocationException ex)
            {
                ex.printStackTrace();
            }
        }

        if (newLine)
        {
            // + 1 to include newly-added line
            if (expressions.getLineCount() != MAX + 1)
            {
                pointer++;
            }
            else
            {
                try
                {
                    int start = expressions.getLineStartOffset(1);
                    int end = expressions.getLineEndOffset(pointer);
                    int length = end - start;

                    String expr = expressions.getText(start, length);

                    expressions.setText(expr);
                }
                catch(BadLocationException e)
                {
                    e.printStackTrace();
                }
            }
        }

        // set result field to answer
        result.setText(calculation);
    }

    private String getLineText(int line) throws BadLocationException
    {
        int start = expressions.getLineStartOffset(line);
        int end = expressions.getLineEndOffset(line);

        int length = end - start;

        return chomp(expressions.getText(start, length));
    }

    private int getLastLine()
    {
        return expressions.getLineCount() - 1;
    }

    private void keyPressed(KeyEvent event)
    {
        int keyCode = event.getKeyCode();

        if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN)
        {
                movePointer(keyCode == KeyEvent.VK_UP);

                if (pointer != getLastLine())
                {
                    try
                    {
                        highlightLine(pointer, selection);
                    }
                    catch (BadLocationException e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                    reset();
        }
        else if (keyCode == KeyEvent.VK_BACK_SPACE)
        {
            deleteChar();
        }
        else if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_EQUALS)
        {
            if (pointer == getLastLine())
            {
                equals.doClick();
            }
            else
            {
                try
                {
                    String expression = getLineText(pointer);

                    reset();

                    int start = expressions.getLineStartOffset(pointer);
                    String history = expressions.getText(0, start);

                    expressions.setText(history + expression);
                }
                catch (BadLocationException e)
                {
                    e.printStackTrace();
                }
            }
        }
        else if (keyCode >= KeyEvent.VK_NUMPAD0
                && keyCode <= KeyEvent.VK_NUMPAD9) // if number
        {
            int number = keyCode - KeyEvent.VK_NUMPAD0;

            buttons[number].doClick();
        }
        else
        {
            switch(keyCode)
            {
                case KeyEvent.VK_DECIMAL:
                    decimal.doClick();
                    break;
                case KeyEvent.VK_MULTIPLY:
                    multiply.doClick();
                    break;
                case KeyEvent.VK_DIVIDE:
                    divide.doClick();
                    break;
                case KeyEvent.VK_ADD:
                    add.doClick();
                    break;
                case KeyEvent.VK_SUBTRACT:
                    subtract.doClick();
                    break;
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event)
    {
        String expression;

        try
        {
            expression = getLineText(pointer);
        }
        catch (BadLocationException e)
        {
            e.printStackTrace();
            return;
        }

        if (event.getValueIsAdjusting() || conversions.isSelectionEmpty())
        {
            return;
        }

        if (expression.isEmpty())
        {
            conversions.clearSelection();
            return;
        }

        String conversion = (String)conversions.getSelectedValue();
        ListModel<String> list = conversions.getModel();

        int i;
        for (i = 0; i < list.getSize(); i++)
        {
            if (conversion.equals(list.getElementAt(i)))
            {
                break;
            }
        }

        switch(i)
        {
            case 0:
                expression = "(" + expression + ")0.3048";
                break;
            case 1:
                expression = "(" + expression + ")3.2808";
                break;
            case 2:
                expression = "(" + expression + ")0.4536";
                break;
            case 3:
                expression = "(" + expression + ")2.2046";
                break;
            case 4:
                expression = "(" + expression + ")3.7854";
                break;
            case 5:
                expression = "(" + expression + ")0.2642";
                break;
        }

        reset();
        conversions.clearSelection();

        try
        {
            int start = expressions.getLineStartOffset(pointer);
            String history = expressions.getText(0, start);

            expressions.setText(history + expression);

            equals.doClick();
        }
        catch (BadLocationException e)
        {
            e.printStackTrace();
        }
    }

    private void highlight(int start, int end, Color color)
            throws BadLocationException
    {
        Highlighter hl = expressions.getHighlighter();

        // allow only one highlight
        removeHighlight();

        Highlighter.HighlightPainter p = new DefaultHighlighter
                .DefaultHighlightPainter(color);

        highlight = hl.addHighlight(start, end, p);
    }

    private void removeHighlight()
    {
        if (highlight != null) // if there's already a highlight
        {
            expressions.getHighlighter().removeHighlight(highlight);
            highlight = null;
        }
    }

    private void highlightLine(int line, Color color) throws BadLocationException
    {
        int start = expressions.getLineStartOffset(line);

        String expression = getLineText(line);
        int end = start + expression.length();

        highlight(start, end, color);
    }

    private String chomp(String text)
    {
        return text.replaceFirst("\n", "");
    }

    private void reset()
    {
        equals.setEnabled(true);
        pointer = getLastLine();
        removeHighlight();
    }

    private void movePointer(boolean up)
    {
        if (up)
        {
            if (pointer > 0)
            {
                pointer--;
                equals.setEnabled(false);
            }
        }
        else if (pointer < getLastLine())
        {
            pointer++;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run() {
                new Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton answer;
    private javax.swing.JButton clear;
    private javax.swing.JList conversions;
    private javax.swing.JButton decimal;
    private javax.swing.JButton delete;
    private javax.swing.JButton divide;
    private javax.swing.JButton eight;
    private javax.swing.JButton equals;
    private javax.swing.JButton exponent;
    private javax.swing.JTextArea expressions;
    private javax.swing.JButton five;
    private javax.swing.JButton four;
    private javax.swing.JButton leftP;
    private javax.swing.JButton mod;
    private javax.swing.JButton multiply;
    private javax.swing.JButton nine;
    private javax.swing.JButton one;
    private javax.swing.JScrollPane pane;
    private javax.swing.JTextField result;
    private javax.swing.JButton rightP;
    private javax.swing.JButton seven;
    private javax.swing.JButton six;
    private javax.swing.JButton subtract;
    private javax.swing.JButton three;
    private javax.swing.JButton two;
    private javax.swing.JButton zero;
    // End of variables declaration//GEN-END:variables
}