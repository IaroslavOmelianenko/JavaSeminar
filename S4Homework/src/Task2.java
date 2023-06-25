import java.util.LinkedList;

public class Task2 {
    /***
     *2. Реализуйте очередь с помощью LinkedList со следующими методами:
     * enqueue() - помещает элемент в конец очереди,
     * dequeue() - возвращает первый элемент из очереди и удаляет его,
     * first() - возвращает первый элемент из очереди, не удаляя.
     */

    public static void createLinkedListQueue(){
        LinkedList<Integer> linkedList = Task1.createLinkedListWithRandomNumbers(3, 10);
        System.out.println("LinkedList: " + linkedList);
        System.out.println("enqueue(99): " + enqueue(linkedList,99));
        System.out.println("dequeue(): " + dequeue(linkedList));
        System.out.println("LL after dequeue(): " + linkedList);
        System.out.println("first(): " + first(linkedList));
        System.out.println("LL after first(): " + linkedList);

    }


    private static LinkedList<Integer> enqueue(LinkedList<Integer> linkedList, int element){
        linkedList.addLast(element);
        return linkedList;
    }

    private static int dequeue(LinkedList<Integer> linkedList){
        return linkedList.pollFirst();
    }

    private static int first(LinkedList<Integer> linkedList){
        return linkedList.getFirst();
    }
}
