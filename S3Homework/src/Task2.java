import java.util.ArrayList;

public class Task2 {
    /***
     *Пусть дан произвольный список целых чисел, удалить из него четные числа
     */

    public static void deleteEvenNumbers() {

        ArrayList<Integer> numbers = createArrayListWithRandomNumbers(5, 0, 10);
        System.out.println("Initial array: " + numbers);
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                i--;
            }
        }
        System.out.println("Same array without even numbers: " + numbers);
    }

    public static ArrayList<Integer> createArrayListWithRandomNumbers(int arrayListSize, int min, int max) {
        ArrayList<Integer> arrayList = new ArrayList<>(arrayListSize);
        for (int i = 0; i < arrayListSize; i++) {
            arrayList.add(i, min + (int) (Math.random() * max));
        }
        return arrayList;
    }
}
