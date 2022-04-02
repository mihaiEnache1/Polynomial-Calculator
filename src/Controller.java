import java.util.ArrayList;

public class Controller {
    private final View view;
    private final Polynomial firstPolynomial;
    private final Polynomial secondPolynomial;
    private Polynomial resultPolynomial;
    private Polynomial remainderPolynomial;
    private ArrayList<Polynomial> resultDivision;

    public Controller(View view){
        this.view = view;

        firstPolynomial = new Polynomial();
        secondPolynomial = new Polynomial();

        this.view.addAdditionButton(e -> {
            if(e.getSource() == this.view.getAdditionButton()) {
                firstPolynomial.setP(firstPolynomial.getPoly(this.view.getFirstPoly()));
                secondPolynomial.setP(secondPolynomial.getPoly(this.view.getSecondPoly()));
                resultPolynomial = new Polynomial();
                resultPolynomial = firstPolynomial.add(secondPolynomial);
                StringBuilder result = resultPolynomial.show(resultPolynomial);
                this.view.setResult(String.valueOf(result));
                this.view.setRemainder(null);
            }
        });

        this.view.addSubtractionButton(e -> {
            if(e.getSource() == this.view.getSubtractionButton()) {
                firstPolynomial.setP(firstPolynomial.getPoly(this.view.getFirstPoly()));
                secondPolynomial.setP(secondPolynomial.getPoly(this.view.getSecondPoly()));
                resultPolynomial = new Polynomial();
                resultPolynomial = firstPolynomial.subtract(secondPolynomial);
                StringBuilder result = resultPolynomial.show(resultPolynomial);
                this.view.setResult(String.valueOf(result));
                this.view.setRemainder(null);
            }
        });

        this.view.addMultiplicationButton(e -> {
            if(e.getSource() == this.view.getMultiplicationButton()) {
                firstPolynomial.setP(firstPolynomial.getPoly(this.view.getFirstPoly()));
                secondPolynomial.setP(secondPolynomial.getPoly(this.view.getSecondPoly()));
                resultPolynomial = new Polynomial();
                if(view.getSecondPoly().contains("0")){
                    Monomial m = new Monomial();
                    m.setCoefficient(0);
                    m.setDegree(0);
                    resultPolynomial.getP().add(m);
                    this.view.setResult("0");
                }
                else {
                    resultPolynomial = firstPolynomial.multiply(secondPolynomial);
                    StringBuilder result = resultPolynomial.show(resultPolynomial);
                    this.view.setResult(String.valueOf(result));

                }
                this.view.setRemainder(null);
            }
        });

        this.view.addDivisionButton(e -> {
            if(e.getSource() == this.view.getDivisionButton()){
                firstPolynomial.setP(firstPolynomial.getPoly(this.view.getFirstPoly()));
                secondPolynomial.setP(secondPolynomial.getPoly(this.view.getSecondPoly()));
                if(view.getSecondPoly().contains("0")){
                    view.showMessage("Bad input");
                }
                resultDivision = new ArrayList<>();
                resultDivision = firstPolynomial.divide(secondPolynomial);
                resultPolynomial = resultDivision.get(0);
                remainderPolynomial = resultDivision.get(1);
                StringBuilder result = resultPolynomial.show(resultPolynomial);
                if(remainderPolynomial.getP().size() == 1 && remainderPolynomial.getP().get(0).getCoefficient() == 0)
                    this.view.setRemainder("0");
                else{
                    StringBuilder remainder = remainderPolynomial.show(remainderPolynomial);
                    this.view.setRemainder(String.valueOf(remainder));
                }
                this.view.setResult(String.valueOf(result));
            }
        });

        this.view.addDerivativeButton(e -> {
            if(e.getSource() == this.view.getDerivativeButton()){
                firstPolynomial.setP(firstPolynomial.getPoly(this.view.getFirstPoly()));
                resultPolynomial = new Polynomial();
                resultPolynomial = resultPolynomial.derivative(firstPolynomial);
                StringBuilder result = resultPolynomial.show(resultPolynomial);
                this.view.setResult(String.valueOf(result));
                this.view.setRemainder(null);
            }
        });

        this.view.addIntegrationButton(e -> {
            if(e.getSource() == this.view.getIntegrationButton()){
                firstPolynomial.setP(firstPolynomial.getPoly(this.view.getFirstPoly()));
                resultPolynomial = new Polynomial();
                resultPolynomial = resultPolynomial.integrate(firstPolynomial);
                StringBuilder result = resultPolynomial.show(resultPolynomial);
                this.view.setResult(String.valueOf(result));
                this.view.setRemainder(null);
            }
        });
    }
}