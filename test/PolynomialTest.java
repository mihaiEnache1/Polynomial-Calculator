import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class PolynomialTest {

    @Test
    public void testAddition(){
        Polynomial firstPolynomial = new Polynomial();
        Polynomial secondPolynomial = new Polynomial();
        String firstOperand = "2x^5+x^4-5x^3-8x+1";
        LinkedList<Monomial> monomials1 = firstPolynomial.getPoly(firstOperand);
        firstPolynomial.setP(monomials1);
        String secondOperand = "x^2-3";
        LinkedList<Monomial> monomials2 = secondPolynomial.getPoly(secondOperand);
        secondPolynomial.setP(monomials2);
        Polynomial result = firstPolynomial.add(secondPolynomial);
        StringBuilder r = result.show(result);
        assertEquals(String.valueOf(r), "+2.00x^5+x^4-5.00x^3+x^2-8.00x-2.00");
    }

    @Test
    public void testSubtraction(){
        Polynomial firstPolynomial = new Polynomial();
        Polynomial secondPolynomial = new Polynomial();
        String firstOperand = "2x^5+x^4-5x^3-8x+1";
        LinkedList<Monomial> monomials1 = firstPolynomial.getPoly(firstOperand);
        firstPolynomial.setP(monomials1);
        String secondOperand = "x^2-3";
        LinkedList<Monomial> monomials2 = secondPolynomial.getPoly(secondOperand);
        secondPolynomial.setP(monomials2);
        Polynomial result = firstPolynomial.subtract(secondPolynomial);
        StringBuilder r = result.show(result);
        assertEquals(String.valueOf(r), "+2.00x^5+x^4-5.00x^3-x^2-8.00x+4.00");
    }

    @Test
    public void testMultiplication(){
        Polynomial firstPolynomial = new Polynomial();
        Polynomial secondPolynomial = new Polynomial();
        String firstOperand = "2x^5+x^4-5x^3-8x+1";
        LinkedList<Monomial> monomials1 = firstPolynomial.getPoly(firstOperand);
        firstPolynomial.setP(monomials1);
        String secondOperand = "x^2-3";
        LinkedList<Monomial> monomials2 = secondPolynomial.getPoly(secondOperand);
        secondPolynomial.setP(monomials2);
        Polynomial result = firstPolynomial.multiply(secondPolynomial);
        StringBuilder r = result.show(result);
        assertEquals(String.valueOf(r), "+2.00x^7+x^6-11.00x^5-3.00x^4+7.00x^3+x^2+24.00x-3.00");
    }

    @Test
    public void testDivision(){
        Polynomial firstPolynomial = new Polynomial();
        Polynomial secondPolynomial = new Polynomial();
        String firstOperand = "2x^5+x^4-5x^3-8x+1";
        LinkedList<Monomial> monomials1 = firstPolynomial.getPoly(firstOperand);
        firstPolynomial.setP(monomials1);
        String secondOperand = "x^2-3";
        LinkedList<Monomial> monomials2 = secondPolynomial.getPoly(secondOperand);
        secondPolynomial.setP(monomials2);
        ArrayList<Polynomial> result = firstPolynomial.divide(secondPolynomial);
        Polynomial quote = result.get(0);
        Polynomial remainder = result.get(1);
        StringBuilder r1 = quote.show(quote);
        StringBuilder r2 = remainder.show(remainder);
        assertEquals(String.valueOf(r1), "+2.00x^3+x^2+x+3.00");
        assertEquals(String.valueOf(r2), "-5.00x+10.00");
    }

    @Test
    public void testDerivative(){
        Polynomial firstPolynomial = new Polynomial();
        String firstOperand = "2x^5+x^4-5x^3-8x+1";
        LinkedList<Monomial> monomials1 = firstPolynomial.getPoly(firstOperand);
        firstPolynomial.setP(monomials1);
        Polynomial result = firstPolynomial.derivative(firstPolynomial);
        StringBuilder r = result.show(result);
        assertEquals(String.valueOf(r), "+10.00x^4+4.00x^3-15.00x^2-8.00");
    }

    @Test
    public void testIntegration(){
        Polynomial firstPolynomial = new Polynomial();
        String firstOperand = "2x^5+x^4-5x^3-8x+1";
        LinkedList<Monomial> monomials1 = firstPolynomial.getPoly(firstOperand);
        firstPolynomial.setP(monomials1);
        Polynomial result = firstPolynomial.integrate(firstPolynomial);
        StringBuilder r = result.show(result);
        assertEquals(String.valueOf(r), "+0.33x^6+0.20x^5-1.25x^4-4.00x^2+x");
    }
}
