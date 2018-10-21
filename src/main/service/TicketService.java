package main.service;



import main.model.Ticket;
import main.repository.TicketRepository;
import main.repository.io.JavaIOTicketRepositoryImpl;

import java.io.IOException;

public class TicketService {
TicketRepository ticketR;
public TicketService(){
    ticketR = new JavaIOTicketRepositoryImpl();
}

public void creatTicket(Ticket ticket)
{
ticketR.create(ticket);


}

    public void updateTicketStatusById(Long id){
        try {

            ticketR.update(ticketR.getById(id));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}
