package Basic.java.Ticket_Sale1;

import java.Ticket_Sale1.TicketOffice;

public class TicketSeller {
    private TicketOffice ticketOffice;
    
    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    /* 의존성 제거
    public TicketOffice getTicketOffice(){
        return ticketOffice;
    }
    */


    // 기존 Theater에 있던 기능을 ticketseller가 수행

    /* -> TicketSeller는 가방을 확인하지 않는다. (Bag의 정보를 모른다)
    public void sellTo(Audience audience){
        if(audience.getBag().hasInvitation()){
            Ticket ticket = ticketOffice.getTicket();
            audience.getBag().setTicket(ticket);
        }else{
            Ticket ticket = ticketOffice.getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketOffice.plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
    */

    public void sellTo(Audience audience){
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
        System.out.println("TicketSeller sold a ticket.");
    }
}
