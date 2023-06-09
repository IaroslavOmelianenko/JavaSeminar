import java.util.Arrays;

public class Task2 {
    /***
     * 2) Реализовать алгоритм пирамидальной сортировки (HeapSort)(найти метод в Интернете и включить в проект)
     */

    public static void lunchHeapSort() {
        int[] arr = {1000, 1, -10, 0, 10, 1};
        System.out.println("Array before sort: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("Array after sort: " + Arrays.toString(arr));
    }


    //Метод создания дерева массива
    public static void heapSort(int[] arr) {
        //Длина массива
        int n = arr.length;

        //Создаём дерево, построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, i, n);

        //Делаем сортировку массива, уже отсортированного дерева,
        //Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {

            //Перемещаем текущий корень в конец
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, 0, i);
        }
    }

     //Главный метод в котором будет меняться структура данных так,
     //чтобы родительский элемент был максимальны элементом по сравнению со своими дочерними элементами в дереве
    private static void heapify(int[] arr, int i, int n) {
        //Левый дочерний элемент
        int l = i * 2 + 1;

        //Правый дочерний элемент
        int r = i * 2 + 2;

        //Инициализируем наибольший элемент как корень
        int largest = i;

        //Проверка чтоб дочерние элементы не стали больше чем родительские
        //Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        //Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;

        //Если, ребёнок оказался больше родителя, то делаем обмен, ребёнка с родителем.
        //Если самый большой элемент не корень
        if (i != largest) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            //Проверяем ещё раз чтобы дочерние элементы были меньше чем родительские,
            //если у дочерних элементов есть свои дочерние элементы.
            //Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, largest, n);
        }
    }
}
