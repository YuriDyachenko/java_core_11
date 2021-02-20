package kurs;
/*
класс АПЕЛЬСИН, вес 1.5
*/
public class Orange extends Fruit{

    @Override
    public float getWeight() {
        return 1.5f;
    }

    @Override
    public String getPluralName() {
        return "апельсины";
    }
}
