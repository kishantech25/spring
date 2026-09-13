package PropertyEditors;

public class ScientificCalculator {
    private ComplexNumber complexNumber;

    public void setComplexNumber(ComplexNumber complexNumber){
        this.complexNumber =complexNumber;
    }

    @Override
    public String toString() {
          return "ScientificCalculator [ComplexNumber="+complexNumber+"]";
    }
}
