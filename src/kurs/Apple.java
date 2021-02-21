package kurs;
/*
класс ЯБЛОКО, вес 1.0
*/
public class Apple extends Fruit{

    @Override
    public float getWeight() {
        return 1.0f;
    }

    @Override
    public String getPluralName() {
        return "яблоки";
    }

    @Override
    protected Object clone() {
        return new Apple();
    }
}
