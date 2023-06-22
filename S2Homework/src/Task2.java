import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task2 {
    /***
     * 2) Реализуйте алгоритм сортировки пузырьком числового массива.
     * Результат после каждой итерации запишите в лог-файл.
     */

    void bubbleSortWithLogging() {
        Logger logger = Logger.getLogger(Task4.class.getName());
        try {
            FileHandler fileHandler = new FileHandler("task2log.txt");
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] array = {3, 1, 5, 0, 2, 4};
        logger.info("Array before sort: " + Arrays.toString(array));
        int arrayLength = array.length;
        int temp = 0;
        for (int i = 0; i < arrayLength; i++) {
            logger.info("i#" + i + ": " + Arrays.toString(array));
            for (int j = 1; j < arrayLength - i; j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    logger.info(" j#" + j + ": " + Arrays.toString(array));
                }
            }
        }
        logger.info("Array after sort: " + Arrays.toString(array));
    }
}
