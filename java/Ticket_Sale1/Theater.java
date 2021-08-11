package Ticket_Sale1;

public class Theater {
   private TicketSeller ticketseller;
   
   public Theater(TicketSeller ticketSeller){
       this.ticketseller = ticketSeller;
   }

   /*
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
   }*/

   public void enter(Audience audience){
       ticketseller.sellTo(audience);
       System.out.println("Audience is Enterring the Theater");
   }
   
   public static void main(String[] args) {
    Ticket ticket = new Ticket(100);
    Invitation invitation = new Invitation();   

    Bag bag = new Bag(1000);
    Audience one = new Audience(bag);

    TicketOffice ticketOffice = new TicketOffice(0, ticket);
    TicketSeller ticketseller = new TicketSeller(ticketOffice);

    Theater theater = new Theater(ticketseller);

    theater.enter(one);
} 
}
