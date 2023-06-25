import java.util.LinkedList;
import java.util.Random;

public class Task1 {
    /***
     * 1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
     */

    public static void reverseLinkedList(){
        LinkedList<Integer> linkedList = createLinkedListWithRandomNumbers(5, 10);
        System.out.println("Before reverse: " + linkedList);

        LinkedList<Integer> reversedLinkedList = new LinkedList<>();
        for (int i = linkedList.size()-1; i >=0; i--) {
            reversedLinkedList.add(linkedList.get(i));
        }
        System.out.println("After reverse: " + reversedLinkedList);
    }

    public static LinkedList<Integer> createLinkedListWithRandomNumbers(int size, int max){
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            linkedList.add(i, random.nextInt(max));
        }
        return linkedList;
    }
}
