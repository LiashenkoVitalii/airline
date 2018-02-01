package liashenko.airline;

import liashenko.airline.controller.CommandsHandler;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Main class of the application
public class Runner {
    private static final Logger logger = Logger.getLogger(Runner.class);

    public static void main(String[] args) {
        boolean isContinue = true;

        System.out.print("Enter command and press <Enter> (\"help\" to get help; \"exit\" to quit).");
        System.out.println();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (isContinue) {
                System.out.print(">_ ");
                String input = br.readLine();
                String resultString = CommandsHandler.handleCommand(input);
                if (resultString.equals("exit")) {
                    isContinue = false;
                } else {
                    System.out.println(resultString);
                    System.out.println("-----------------");
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        System.out.println("Exit!");
        System.exit(0);
    }
}
