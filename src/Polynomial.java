import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private LinkedList<Monomial> p;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Polynomial() {
        p = new LinkedList<>();
    }

    public void setP(LinkedList<Monomial> monomials) {
        this.p = monomials;
    }

    public LinkedList<Monomial> getP() {
        return p;
    }

    public LinkedList<Monomial> getPoly(String Poly) {
        Pattern pattern = Pattern.compile("[-+]?([\\d]+)?x\\^?\\d?|[-+][\\d]+"); //pattern for breaking the polynomial into monomials
        Matcher matcher = pattern.matcher(Poly);
        LinkedList<Monomial> monomials = new LinkedList<>();
        while (matcher.find()) {
            if (matcher.group().trim().length() > 0) {
                Pattern pattern1 = Pattern.compile("(?<=\\^)\\d"); //pattern for obtaining the monomial coefficient
                Matcher matcher1 = pattern1.matcher(matcher.group());
                Pattern pattern3 = Pattern.compile("[-+]?[\\d]+?(?=x)"); //pattern for obtaining the degree of monomial
                Matcher matcher3 = pattern3.matcher(matcher.group());
                Monomial m = new Monomial();
                if (matcher3.find())
                    m.setCoefficient(Double.parseDouble(matcher3.group()));
                else {
                    if (matcher.group().contains("-"))
                        m.setCoefficient(-1.0);
                    else
                        m.setCoefficient(1.0);
                }
                if (matcher1.find()) {
                    m.setDegree(Integer.parseInt(matcher1.group()));
                } else {
                    Pattern pattern2 = Pattern.compile("x");
                    Matcher matcher2 = pattern2.matcher(matcher.group());
                    if (matcher2.find()) {
                        m.setDegree(1);
                    } else {
                        m.setDegree(0);
                        m.setCoefficient(Double.parseDouble(matcher.group()));
                    }
                }
                monomials.add(m);
            }
        }
        return monomials;
    }

    public Polynomial add(Polynomial polynomial) {
        Polynomial result = new Polynomial();
        int sizeSecondPolynomial = polynomial.p.size();
        int i = 0, j = 0;
        while (i < this.p.size() && j < sizeSecondPolynomial) {
            if (this.p.get(i).getDegree() > polynomial.p.get(j).getDegree()) {
                Monomial r = new Monomial();
                r.setCoefficient(this.p.get(i).getCoefficient());
                r.setDegree(this.p.get(i).getDegree());
                result.getP().add(r);
                i++;
            } else if (this.p.get(i).getDegree() < polynomial.p.get(j).getDegree()) {
                Monomial r = new Monomial();
                r.setDegree(polynomial.p.get(j).getDegree());
                r.setCoefficient(polynomial.p.get(j).getCoefficient());
                result.getP().add(r);
                j++;
            } else {
                if (this.p.get(i).getCoefficient() + polynomial.p.get(j).getCoefficient() != 0) {
                    Monomial r = new Monomial();
                    r.setDegree(this.p.get(i).getDegree());
                    r.setCoefficient(this.p.get(i).getCoefficient() + polynomial.p.get(j).getCoefficient());
                    result.getP().add(r);
                    i++;
                    j++;
                }
            }
        }
        while(i < this.p.size()){
            Monomial r = new Monomial();
            r.setCoefficient(this.p.get(i).getCoefficient());
            r.setDegree(this.p.get(i).getDegree());
            result.p.add(r);
            i++;
        }
        while(j < polynomial.p.size()){
            Monomial r = new Monomial();
            r.setDegree(polynomial.p.get(j).getDegree());
            r.setCoefficient(polynomial.p.get(j).getCoefficient());
            result.p.add(r);
            j++;
        }
        return result;
    }

    public Polynomial subtract(Polynomial polynomial) {
        Polynomial result = new Polynomial();
        int sizeSecondPolynomial = polynomial.p.size();
        int i = 0, j = 0;
        while (i < this.p.size() && j < sizeSecondPolynomial) {
            if (this.p.get(i).getDegree() > polynomial.p.get(j).getDegree()) {
                Monomial r = new Monomial();
                r.setCoefficient(this.p.get(i).getCoefficient());
                r.setDegree(this.p.get(i).getDegree());
                result.p.add(r);
                i++;
            } else if (this.p.get(i).getDegree() < polynomial.p.get(j).getDegree()) {
                Monomial r = new Monomial();
                r.setDegree(polynomial.p.get(j).getDegree());
                r.setCoefficient(-polynomial.p.get(j).getCoefficient());
                result.p.add(r);
                j++;
            } else {
                Monomial r = new Monomial();
                r.setDegree(this.p.get(i).getDegree());
                r.setCoefficient(this.p.get(i).getCoefficient() - polynomial.p.get(j).getCoefficient());
                result.p.add(r);
                i++;
                j++;
            }
        }
        while(i < this.p.size()){
            Monomial r = new Monomial();
            r.setDegree(this.p.get(i).getDegree());
            r.setCoefficient(this.p.get(i).getCoefficient());
            result.p.add(r);
            i++;
        }
        while(j < sizeSecondPolynomial){
            Monomial r = new Monomial();
            r.setDegree(polynomial.p.get(j).getDegree());
            r.setCoefficient(polynomial.p.get(j).getCoefficient());
            result.p.add(r);
            j++;
        }
        return result;
    }

    public Polynomial multiply(Polynomial polynomial){
        Polynomial intermediate = new Polynomial();
        Polynomial result = new Polynomial();
        for(Monomial x : this.p) {
            for (Monomial y : polynomial.p) {
                Monomial m = new Monomial();
                m.setCoefficient(x.getCoefficient() * y.getCoefficient());
                m.setDegree(x.getDegree() + y.getDegree());
                intermediate.p.add(m);
            }
        }
        Collections.sort(intermediate.p);
        int i = 0, j;
        int pair;
        while(i < intermediate.p.size()){
            j = i+1;
            Monomial m = new Monomial();
            pair = 0;
            while(j < intermediate.p.size()){
                if(intermediate.p.get(i).getDegree() == intermediate.p.get(j).getDegree()){
                    m.setCoefficient(intermediate.p.get(i).getCoefficient() + intermediate.p.get(j).getCoefficient());
                    m.setDegree(intermediate.p.get(i).getDegree());
                    pair++;
                }
                j++;
            }
            if(pair == 0){
                m.setDegree(intermediate.p.get(i).getDegree());
                m.setCoefficient(intermediate.p.get(i).getCoefficient());
            }
            i += pair+1;
            result.p.add(m);
        }
        return result;
    }

    public ArrayList<Polynomial> divide(Polynomial p){
        ArrayList<Polynomial> d = new ArrayList<>();
        Polynomial q = new Polynomial();
        while(this.p.get(0).getDegree() >= p.p.get(0).getDegree()){
            Monomial m = new Monomial();
            m.setCoefficient(this.p.get(0).getCoefficient()/p.p.get(0).getCoefficient());
            m.setDegree(this.p.get(0).getDegree()-p.p.get(0).getDegree());
            Polynomial old = new Polynomial();
            old.p.add(m);
            q.p.add(m);
            Polynomial n = old.multiply(p);
            Polynomial p1 = new Polynomial();
            p1.setP(this.p);
            p1 = p1.subtract(n);
            this.setP(p1.p);
            this.p.remove(0);
        }
        d.add(q);
        d.add(this);
        return d;
    }

    public Polynomial derivative(Polynomial polynomial){
        Polynomial result = new Polynomial();
        for(Monomial x : polynomial.p){
            if(x.getDegree() > 0) {
                Monomial m = new Monomial();
                m.setCoefficient(x.getCoefficient() * x.getDegree());
                m.setDegree(x.getDegree() - 1);
                result.p.add(m);
            }
        }
        return result;
    }

    public Polynomial integrate(Polynomial polynomial){
        Polynomial result = new Polynomial();
        for(Monomial x : polynomial.p) {
            Monomial m = new Monomial();
            m.setCoefficient(x.getCoefficient() * 1/(x.getDegree()+1));
            m.setDegree(x.getDegree()+1);
            result.p.add(m);
        }
        return result;
    }

    public StringBuilder show(Polynomial polynomial){
        StringBuilder result = new StringBuilder();
        for (Monomial x : polynomial.getP())
            if (x.getDegree() > 0) {
                if (x.getDegree() == 1) {
                    if (x.getCoefficient() == -1)
                        result.append("-x");
                    else if (x.getCoefficient() == 1)
                        result.append("+x");
                    else {
                        if(x.getCoefficient() <0)
                            result.append(df.format(x.getCoefficient())).append("x");
                        else {
                            if (x.getCoefficient() > 0)
                                result.append("+").append(df.format(x.getCoefficient())).append("x");
                        }
                    }
                } else {
                    if (x.getCoefficient() < 0) {
                        if (x.getCoefficient() != -1)
                            result.append(df.format(x.getCoefficient())).append("x").append("^").append(x.getDegree());
                        else
                            result.append("-x").append("^").append(x.getDegree());
                    }
                    else if (x.getCoefficient() != 1)
                        result.append("+").append(df.format(x.getCoefficient())).append("x").append("^").append(x.getDegree());
                    else
                        result.append("+x").append("^").append(x.getDegree());
                }
            } else {
                if (x.getCoefficient() != 0) {
                    if (x.getCoefficient() < 0)
                        result.append(df.format(x.getCoefficient()));
                    else
                        result.append("+").append(df.format(x.getCoefficient()));
                }
            }
        return result;
    }
}