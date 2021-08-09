package Basic.java.Ticket_Sale1;

public class Theater {
   private TicketSeller ticketseller;
   
   public Theater(TicketSeller ticketSeller){
       this.ticketseller = ticketSeller;
   }

   public void enter(Audience audience){
       if(audience.getBag().hasInvitation()){
           Ticket ticket = ticketseller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
       }else{
           Ticket ticket = ticketseller.getTicketOffice().getTicket();
           audience.getBag().minusAmount(ticket.getFee());
           ticketseller.getTicketOffice().plusAmount(ticket.getFee());
           audience.getBag().setTicket(ticket);
       }
   }
}
