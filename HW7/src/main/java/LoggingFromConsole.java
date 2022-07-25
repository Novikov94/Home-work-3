import org.apache.log4j.Logger;

import java.util.Scanner;

public class LoggingFromConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final Logger logger;
        logger = Logger.getLogger(Calculation.class.getName());
        String action;
        System.out.println("Enter level of logging");
        action = scanner.nextLine();

        switch (action) {
            case "Debug" -> logger.debug("Debug level log");
            case "Info" -> logger.info("Info level log");
            case "Error" -> logger.error("Error level log");
            case "Warn" -> logger.warn("Warn level log");
            default -> {
                System.out.println("Incorrect operation!");
            }
        }
    }


}
