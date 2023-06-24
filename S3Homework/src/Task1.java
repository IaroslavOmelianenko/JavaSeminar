import java.util.Arrays;

public class Task1 {
    /***
     *Реализовать алгоритм сортировки слиянием
     */

    public static void mergeSort() {
        int[] buffer1 = createRandomArray(5,0,100);
        System.out.println("Array before sort: " + Arrays.toString(buffer1));

        int[] buffer2 = new int[buffer1.length];

        int[] result = mergeSortInner(buffer1, buffer2, 0, buffer1.length);
        System.out.println("Array after sort: " + Arrays.toString(result));
    }

    public static int[] createRandomArray(int arrayLength, int min, int max) {
        int[] randomArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = min + (int) (Math.random() * max);
        }
        return randomArray;
    }


    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        //sorted
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        //merge
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}
