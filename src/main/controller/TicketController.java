package main.controller;


import main.model.Ticket;
import main.service.TicketService;

public class TicketController {
    TicketService ticketService;
    public TicketController(){
        ticketService = new TicketService();
    }

    public void creatTicket(Ticket ticket){
        ticketService.creatTicket(ticket);
    }

    public void updateTicketStatusById(Long id){
        ticketService.updateTicketStatusById(id);
    }


}
