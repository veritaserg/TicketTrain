package main.service;



import main.model.Ticket;
import main.repository.TicketRepository;
import main.repository.io.JavaIOTicketRepositoryImpl;

import java.io.IOException;

public class TicketService {
TicketRepository ticketR = new JavaIOTicketRepositoryImpl();

public void creatTicket(Ticket ticket)
{
ticketR.create(ticket);


}

    public void updateTicketStatusById(Ticket ticket){
        try {
            ticketR.update(ticket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}
