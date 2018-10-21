package main.view;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void startApp() {

        showCommandsMenu();
    }

    private void showCommandsMenu() {
        TicketView ticketView = new TicketView();

        while (true) {
            try {
                writeToConsole("\nВыберите команду:\n\n" +
                        "0 - Купить билет\n" +
                        "1 - Сдать билет\n" +
                        "2 - Выход\n");
                switch (Integer.parseInt(readString())) {
                    case 0:
                        ticketView.searchByRoute();
                        break;
                    case 1:
                        ticketView.returnTicket();
                        break;
                    case 2:
                        return;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IOException e) {
                writeToConsole(e.getMessage());
            } catch (IllegalArgumentException e) {
                writeToConsole(e.getMessage());
                writeToConsole("Не правильная команда. Повторите ввод.");
            }
        }
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static void writeToConsole(String message) {
        System.out.println(message);
    }
}

