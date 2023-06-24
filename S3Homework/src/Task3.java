import java.util.ArrayList;
import java.util.Collections;

public class Task3 {
    /***
     *Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка
     */

    public void findMinMaxAverage() {
        ArrayList<Integer> arrayList = Task2.createArrayListWithRandomNumbers(5, 0, 10);
        System.out.println(arrayList);

        int minValue = Collections.min(arrayList);
        int maxValue = Collections.max(arrayList);

        double averageValue = 0;
        for (int number : arrayList) averageValue += number;
        averageValue /= arrayList.size();

        System.out.println("Min: " + minValue);
        System.out.println("Max: " + maxValue);
        System.out.println("Average: " + averageValue);
    }
}
