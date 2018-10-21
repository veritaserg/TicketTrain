package main.view;



import main.controller.CarController;
import main.model.Car;
import main.model.Type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarView {
    CarController carController = new CarController();
TicketView ticketView = new TicketView();
    Map<Long, List<Integer>> carAndSeats;

    public void getSeatsStatusOpen(List<Integer> numberCar) {
        List<Car> cars = carController.getCarByNumber(numberCar);

        while (true) {
            try {
                ConsoleHelper.writeToConsole("\nВыберите тип вагона:\n\n" +
                        "0 - Эконом\n" +
                        "1 - Купе\n" +
                        "2- СВ\n");
                              switch (Integer.parseInt(ConsoleHelper.readString())) {
                    case 0:
                        carAndSeats = carController.getSeatsStatusOpen(cars, "ECONOMY");
                        for (String seats : getSeatsOpen(carAndSeats))
                            ConsoleHelper.writeToConsole(seats);
                        ticketView.creatTicket(Type.ECONOMY);
                        break;
                    case 1:
                        carAndSeats = carController.getSeatsStatusOpen(cars, "COUPE");
                        for (String seats : getSeatsOpen(carAndSeats))
                            ConsoleHelper.writeToConsole(seats);
                        ticketView.creatTicket(Type.COUPE);
                        break;
                    case 2:
                        carAndSeats = carController.getSeatsStatusOpen(cars, "SV");
                        for (String seats : getSeatsOpen(carAndSeats))
                            ConsoleHelper.writeToConsole(seats);
                        ticketView.creatTicket(Type.SV);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                break;
            } catch (IOException e) {
                ConsoleHelper.writeToConsole(e.getMessage());
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeToConsole(e.getMessage());
                ConsoleHelper.writeToConsole("Не правильная команда. Повторите ввод.");
            }
        }
    }

    public List<String> getSeatsOpen(Map<Long, List<Integer>> carAndSeats) {
        List<String> seatOpen = new ArrayList<>();
        for (Map.Entry<Long, List<Integer>> pair : carAndSeats.entrySet()) {

            seatOpen.add("В вагоне №: " + pair.getKey() + " свободные места : "
                    + pair.getValue());
        }

        return (seatOpen);

    }
    public void changeStatus(int carNumber,int seatNumber){
        carController.changeStatus(carNumber,seatNumber);
    }

}