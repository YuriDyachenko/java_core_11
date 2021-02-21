package kurs;
/*
абстрактный класс ФРУКТ
*/
public abstract class Fruit {
    //абстрактный метод "вес" - чтобы наследники не забыли переопределить
    public abstract float getWeight();
    //абстрактный метод "название во множественном числе"
    public abstract String getPluralName();
    //переопределяем клонирование, абстрактный мы не создаем новый
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return null;
    }
}
