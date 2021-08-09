package Basic.java.Ticket_Sale1;

import java.Ticket_Sale1.Bag;

public class Audience {
    private Bag bag;
    
    public Audience(Bag bag){
        this.bag = bag;
    }

    /* TicketSeller 의존성 제거
    public Bag getBag(){
        return bag;
    }
    */

    public long buy(Ticket ticket){
        if(bag.hasInvitation()){
            bag.setTicket(ticket);
            System.out.println("Audience has a ticket. Doesn't need to buy a ticket");
            return 0L;
        }else{
            bag.setTicket(ticket);
            bag.minusAmount(ticket.getFee());
            System.out.println("Audience doesn't have a ticket. Buy a ticket(Fee : " + ticket.getFee() + ")");
            return ticket.getFee();
        }
    }
}
