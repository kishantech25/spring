package PropertyEditors;

public class ComplexNumber {
    private int base;
    private int expo;

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getExpo() {
        return expo;
    }

    public void setExpo(int expo) {
        this.expo = expo;
    }

    @Override
    public String toString() {
        return "ComplexNumber{" +
                "base=" + base +
                ", expo=" + expo +
                '}';
    }
}
