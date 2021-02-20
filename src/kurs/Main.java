package kurs;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        testSwapAndToArrayList();
        testBoxes();
    }

    //поменять местами два элемента в массиве любого типа
    private static <T> void swap(T[] array, int index1, int index2) {
        if (array == null || index1 < 0 || index1 >= array.length || index2 < 0 ||
                index2 >= array.length || index1 == index2) {
            return;
        }
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    //преобразовать массив в ArrayList
    private static <T> ArrayList<T> toArrayList(T[] array) {
        if (array == null) return null;
        return new ArrayList<>(Arrays.asList(array));
    }

    private static void testSwapAndToArrayList() {
        testSome(new String[] {"Нулевой", "Первый", "Второй", "Третий", "Четвертый", "Пятый"}, 1, 4);
        testSome(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 7, 3);
        testSome(new Boolean[] {true, false}, 1, 0);
    }

    private static <T> void testSome(T[] array, int index1, int index2) {
        if (array == null || array.length == 0) return;
        System.out.printf("\n----- массив %s -----\n", array[0].getClass().getSimpleName());
        System.out.println("  " + Arrays.toString(array));
        System.out.printf("меняем местами элементы с индексами %d и %d:\n", index1, index2);
        swap(array, index1, index2);
        System.out.println("  " + Arrays.toString(array));
        System.out.println("создаем ArrayList:");
        ArrayList<T> arrayList = toArrayList(array);
        System.out.println("  " + arrayList.getClass().getSimpleName() + arrayList);
    }

    private static void testBoxes() {
        System.out.println("\n----- коробки с фруктами -----");

        Box<Apple> appleBox1 = new Box<>("1");
        Box<Apple> appleBox2 = new Box<>("2");
        Box<Orange> orangeBox1 = new Box<>("3");
        Box<Orange> orangeBox2 = new Box<>("4");

        appleBox1.add(new Apple(), 6);
        System.out.println("заполяем первую коробку яблоками: " + appleBox1);
        appleBox1.overload(appleBox2);
        System.out.println("пересыпаем во вторую: " + appleBox2);
        System.out.println("в первой ничего не осталось: " + appleBox1);

        orangeBox1.add(new Orange(), 4);
        System.out.println("заполняем третью коробку апельсинами: " + orangeBox1);
        orangeBox1.overload(orangeBox2);
        System.out.println("пересыпаем в четвертую: " + orangeBox2);
        System.out.println("в третьей ничего не осталось: " + orangeBox1);

        System.out.println("\n----- сравнение по весу -----");
        System.out.printf("(%s == %s) = %b\n", appleBox1, orangeBox1, appleBox1.compare(orangeBox1));
        System.out.printf("(%s == %s) = %b\n", appleBox2, orangeBox2, appleBox2.compare(orangeBox2));
        System.out.printf("(%s == %s) = %b\n", appleBox1, orangeBox2, appleBox1.compare(orangeBox2));
    }

}
