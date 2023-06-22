import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task4 {
    /***
     * 4) К калькулятору добавить логирование.
     */

    public void simpleCalculation(int number1, int number2, char mathAction) {

        Logger logger = Logger.getLogger(Task4.class.getName());
        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false);

        SimpleFormatter formatter = new SimpleFormatter();
        consoleHandler.setFormatter(formatter);

        double result;
        switch (mathAction) {
            case '+':
                result = number1 + number2;
                logger.info("Calculating " + number1 + " + " + number2);
                break;
            case '-':
                result = number1 - number2;
                logger.info("Calculating " + number1 + " - " + number2);
                break;
            case '*':
                result = number1 * number2;
                logger.info("Calculating " + number1 + " * " + number2);
                break;
            case '/':
                result = number1 / number2;
                logger.info("Calculating " + number1 + " / " + number2);
                break;
            default:
                System.out.println("Simple calculator supports only +, -, *, / actions");
                logger.info("Wrong math action");
                return;
        }
        System.out.println(number1 + " " + mathAction + " " + number2 + " = " + result);
    }
}
