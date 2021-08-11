package Ticket_Sale1;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import Ticket_Sale1.Ticket;

public class TicketOffice {
    private long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(long amount, Ticket ...tickets){
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public void sellTIcketTo(Audience audience){
        plusAmount(audience.buy(getTicket()));
    } // -> 오히려 audience에 대한 정보를 알아야 함.
    
    public Ticket getTicket(){
        return tickets.remove(0);
    }

    public void minusAmount(long amount){
        this.amount -= amount;
    }

    public void plusAmount(long amount){
        this.amount += amount;
    }

}
