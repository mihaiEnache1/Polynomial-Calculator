public class Monomial implements Comparable<Monomial>{
    private int degree;
    private double coefficient;

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public int compareTo(Monomial monomial) {
        return monomial.degree - this.degree;
    }
}