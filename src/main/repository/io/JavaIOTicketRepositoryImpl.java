package main.repository.io;


import main.model.Ticket;
import main.repository.TicketRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class JavaIOTicketRepositoryImpl implements TicketRepository {
String ticketPath = "C:\\Users\\server\\IdeaProjects\\ templates\\com\\sergeev\\TrainTicket\\src\\main\\resource\\ticket.csv";

     public void create(Ticket ticket) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bf = Files.newBufferedReader(Paths.get(ticketPath))) {
            while (bf.ready()) {
                list.add(bf.readLine());
            }
            long id = 0L;

            if (list.size()>0) {
                id = Long.parseLong(list.get(list.size()-1).split(",")[0]);
            }
            Path pathTicket = Paths.get(ticketPath);
            String ticketString = (++id) + "," + ticket.getRoute() + "," + ticket.getNumberCar() + "," + ticket.getTypeCar() + "," +
                    ticket.getNumberSeats() + "," + ticket.getStatus() + "\n";

                Files.write(pathTicket, ticketString.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
                e.printStackTrace();
            }

        }

    public void update(Ticket ticket) throws IOException {
       List<String> list = new ArrayList<>();
       List<String> newlist = new ArrayList<>();
        try (BufferedReader bf = Files.newBufferedReader(Paths.get(ticketPath))) {
            while (bf.ready()) {
                list.add(bf.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter writer = Files.newBufferedWriter(Paths.get(ticketPath));
        for (String tickets:list){
                        newlist.add(tickets);
          if (tickets.split(",")[0].equals(String.valueOf(ticket.getId()))){
              if (tickets.split(",")[9].equals("DELETE")){
                  newlist.add(tickets.substring(0,tickets.length()-6)+"ACTIVE");
              }
            else   newlist.add(tickets.substring(0,tickets.length()-6)+"DELETE");
              newlist.remove(tickets);
        }}
      for (String newList :newlist) {
          writer.write(newList + "\n");
      }
        writer.flush();
writer.close();
        }

        @Override
    public Ticket getById(Long id) {

        return null;
    }




    @Override
    public List<Ticket> getAll() {
        return null;
    }
}
