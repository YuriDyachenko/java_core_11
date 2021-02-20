package kurs;
/*
класс КОРОБКА
*/
import java.util.ArrayList;

public class Box<T extends Fruit> {
    //будем как-то различать коробки - первая, вторая...
    private final String name;
    //все фрукты размещаем в ArrayList
    private final ArrayList<T> list = new ArrayList<>();

    public Box(String name) {
        this.name = name;
    }

    //добавить в коробку фрукт такого же типа
    public void add(T fruit) {
        list.add(fruit);
    }

    //хитрость, чтобы быстро добавлять несколько, но ссылка-то будет оставаться одна и та же
    public void add(T fruit, int how) {
        for (int i = 0; i < how; i++) {
            add(fruit);
        }
    }

    //посчитать вес коробки, вес одного фрукта берем из первого элемента
    public float getWeight() {
        return (list.isEmpty()) ? 0f : list.size() * list.get(0).getWeight();
    }

    //сравнить вес с весом коробки любого типа
    public boolean compare(Box<?> box) {
        return getWeight() == box.getWeight();
    }

    //пересыпать в другую коробку такого же типа
    public void overload(Box<T> box) {
        if (list.isEmpty()) return;
        for (T fruit: list) box.add(fruit);
        list.clear();
    }

    //переопределим отображение, что именно - берем из первого элемента
    @Override
    public String toString() {
        return String.format("{Коробка %s: %s}", name, (list.isEmpty()) ?
                "пустая" : list.get(0).getPluralName() + String.format(" %.1f кг", getWeight()));
    }
}
