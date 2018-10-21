//package main.view;
//
//import main.controller.TicketController;
//import main.model.Route;
//import main.model.Ticket;
//import main.model.TicketStatus;
//import main.model.Type;
//
//import java.io.IOException;
//
//public class TicketView {
//
//    TicketController ticketController = new TicketController();
//    RouteView routeView = new RouteView();
//    CarView carView;
//    static Route route;
//
//    public void searchByRoute() {
//        String departure;
//        String destination;
//        String date;
//        while (true) {
//            ConsoleHelper.writeToConsole("Введите город отправления :");
//            try {
//                departure = ConsoleHelper.readString();
//                ConsoleHelper.writeToConsole("Введите город прибытия :");
//                destination = ConsoleHelper.readString();
//                ConsoleHelper.writeToConsole("Введите дату отправки в формате день,месяц(через /) :");
//                date = ConsoleHelper.readString();
//                route = routeView.routeController.getRoute(departure, destination);
//                routeView.searchByRouteAndDate(departure, destination, date);
//
//                break;
//            } catch (IOException e) {
//                ConsoleHelper.writeToConsole("Повторите ввод.\n");
//            }
//        }
//    }
//
//    public void creatTicket(Type type) {
//        carView = new CarView();
//        int carNumber;
//        int seatNumber;
//
//        while (true) {
//            ConsoleHelper.writeToConsole("Введите № вагона :");
//            try {
//                carNumber = Integer.parseInt(ConsoleHelper.readString());
//                ConsoleHelper.writeToConsole("Выберите № места :");
//                seatNumber = Integer.parseInt(ConsoleHelper.readString());
//
//                Ticket ticket = new Ticket(
//                        route.getDeparture(),
//                        route.getDestination(),
//                        route.getDepartureDate(),
//                        route.getDestinationDate(), type, carNumber,
//                        route.getNumberTrain(), seatNumber, TicketStatus.ACTIVE);
//                ConsoleHelper.writeToConsole("Спасибо за покупку");
//                ticketController.creatTicket(ticket);
//                carView.changeStatus(carNumber, seatNumber);
//                break;
//            } catch (IOException e) {
//                ConsoleHelper.writeToConsole("Повторите ввод.\n");
//            }
//        }
//    }
//
//    public void returnTicket() {
//
//        while (true) {
//            ConsoleHelper.writeToConsole("Введите № билета для возврата :");
//            try {
//                long id = Long.parseLong(ConsoleHelper.readString());
//                ticketController.updateTicketStatusById(id);
//                ConsoleHelper.writeToConsole("Статус изменен");
//
//break;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//
//