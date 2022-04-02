import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private final JButton additionButton;
    private final JButton subtractionButton;
    private final JButton multiplicationButton;
    private final JButton divisionButton;
    private final JButton derivativeButton;
    private final JButton integrationButton;
    private final JTextField firstPoly;
    private final JTextField secondPoly;
    private final JTextField result;
    private final JTextField remainder;

    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 802, 549);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextField txtPolynomialCalculator = new JTextField();
        txtPolynomialCalculator.setFont(new Font("Tahoma", Font.BOLD, 25));
        txtPolynomialCalculator.setHorizontalAlignment(SwingConstants.CENTER);
        txtPolynomialCalculator.setOpaque(false);
        txtPolynomialCalculator.setBorder(null);
        txtPolynomialCalculator.setText("Polynomial Calculator");
        txtPolynomialCalculator.setBounds(220, 10, 392, 43);
        contentPane.add(txtPolynomialCalculator);
        txtPolynomialCalculator.setColumns(10);

        JTextField txtFirstPolynomial = new JTextField();
        txtFirstPolynomial.setText("          First Polynomial = ");
        txtFirstPolynomial.setOpaque(false);
        txtFirstPolynomial.setBorder(null);
        txtFirstPolynomial.setFont(new Font("Tahoma", Font.BOLD, 25));
        txtFirstPolynomial.setBounds(10, 85, 301, 43);
        contentPane.add(txtFirstPolynomial);
        txtFirstPolynomial.setColumns(10);

        JTextField txtSecondPolynomial = new JTextField();
        txtSecondPolynomial.setText("     Second Polynomial = ");
        txtSecondPolynomial.setFont(new Font("Tahoma", Font.BOLD, 25));
        txtSecondPolynomial.setBorder(null);
        txtSecondPolynomial.setOpaque(false);
        txtSecondPolynomial.setColumns(10);
        txtSecondPolynomial.setBounds(10, 138, 301, 43);
        contentPane.add(txtSecondPolynomial);

        JTextField txtResult = new JTextField();
        txtResult.setText("                           Result = ");
        txtResult.setFont(new Font("Tahoma", Font.BOLD, 25));
        txtResult.setOpaque(false);
        txtResult.setBorder(null);
        txtResult.setColumns(10);
        txtResult.setBounds(10, 197, 301, 43);
        contentPane.add(txtResult);

        JTextField txtRemainder = new JTextField();
        txtRemainder.setText("                   Remainder = ");
        txtRemainder.setFont(new Font("Tahoma", Font.BOLD, 25));
        txtRemainder.setColumns(10);
        txtRemainder.setBounds(10, 253, 301, 43);
        txtRemainder.setBorder(null);
        txtRemainder.setOpaque(false);
        contentPane.add(txtRemainder);

        firstPoly = new JTextField();
        firstPoly.setBounds(330, 85, 430, 43);
        firstPoly.setHorizontalAlignment(SwingConstants.CENTER);
        firstPoly.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(firstPoly);
        firstPoly.setColumns(10);

        secondPoly = new JTextField();
        secondPoly.setColumns(10);
        secondPoly.setBounds(330, 138, 430, 43);
        secondPoly.setHorizontalAlignment(SwingConstants.CENTER);
        secondPoly.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(secondPoly);

        result = new JTextField();
        result.setColumns(10);
        result.setBounds(330, 197, 430, 43);
        result.setHorizontalAlignment(SwingConstants.CENTER);
        result.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(result);

        remainder = new JTextField();
        remainder.setColumns(10);
        remainder.setBounds(330, 253, 430, 43);
        remainder.setHorizontalAlignment(SwingConstants.CENTER);
        remainder.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(remainder);

        additionButton = new JButton();
        additionButton.setText("Addition");
        additionButton.setHorizontalAlignment(SwingConstants.CENTER);
        additionButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        additionButton.setBounds(142, 330, 215, 37);
        contentPane.add(additionButton);

        subtractionButton = new JButton();
        subtractionButton.setText("Subtraction");
        subtractionButton.setHorizontalAlignment(SwingConstants.CENTER);
        subtractionButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        subtractionButton.setBounds(142, 390, 215, 37);
        contentPane.add(subtractionButton);

        multiplicationButton = new JButton();
        multiplicationButton.setText("Multiplication");
        multiplicationButton.setHorizontalAlignment(SwingConstants.CENTER);
        multiplicationButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        multiplicationButton.setBounds(142, 450, 215, 37);
        contentPane.add(multiplicationButton);

        divisionButton = new JButton();
        divisionButton.setText("Division");
        divisionButton.setHorizontalAlignment(SwingConstants.CENTER);
        divisionButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        divisionButton.setBounds(380, 330, 215, 37);
        contentPane.add(divisionButton);

        derivativeButton = new JButton();
        derivativeButton.setText("Derivative");
        derivativeButton.setHorizontalAlignment(SwingConstants.CENTER);
        derivativeButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        derivativeButton.setBounds(380, 390, 215, 37);
        contentPane.add(derivativeButton);

        integrationButton = new JButton();
        integrationButton.setText("Integration");
        integrationButton.setHorizontalAlignment(SwingConstants.CENTER);
        integrationButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        integrationButton.setBounds(380, 450, 215, 37);
        contentPane.add(integrationButton);

        this.setVisible(true);
    }

    public JButton getAdditionButton() {
        return additionButton;
    }

    public JButton getSubtractionButton() {
        return subtractionButton;
    }

    public JButton getMultiplicationButton() {
        return multiplicationButton;
    }

    public JButton getDivisionButton() {
        return divisionButton;
    }

    public JButton getDerivativeButton() {
        return derivativeButton;
    }

    public JButton getIntegrationButton() {
        return integrationButton;
    }

    public void addAdditionButton(ActionListener action){
        additionButton.addActionListener(action);
    }

    public void addSubtractionButton(ActionListener action){
        subtractionButton.addActionListener(action);
    }

    public void addMultiplicationButton(ActionListener action){
        multiplicationButton.addActionListener(action);
    }

    public void addDivisionButton(ActionListener action){
        divisionButton.addActionListener(action);
    }

    public void addDerivativeButton(ActionListener action){
        derivativeButton.addActionListener(action);
    }

    public void addIntegrationButton(ActionListener action){
        integrationButton.addActionListener(action);
    }

    public String getFirstPoly(){
        return firstPoly.getText();
    }

    public String getSecondPoly(){
        return secondPoly.getText();
    }

    public void setResult(String s){
        result.setText(s);
    }

    public void setRemainder(String s){
        remainder.setText(s);
    }

    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
        refresh();
    }

    public void refresh(){
        secondPoly.setText(null);
    }

    public static void main(String[] args) {
        View view = new View();
        new Controller(view);
    }
}