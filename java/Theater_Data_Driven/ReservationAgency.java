package Theater_Data_Driven;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount){
        Movie movie = screening.getMovie();

        boolean discounttable = false;
        for(DiscountCondition condition : movie.getDiscounConditions()){
            if(condition.getType() == DiscountConditionType.PERIOD){
                discounttable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
                 condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                  condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;     
            } else{
                discounttable = condition.getSequence() == screening.getSequence();
            }

            if(discounttable){
                break;
            }
        }

        Money fee;
        if(discounttable){
            Money discountAmount = Money.ZERO;
            switch(movie.getMovieType()){
                case AMOUNT_DISCOUNT:
                    discountAmount = movie.getDiscountAmount();
                    break;
                case PERCENT_DISCOUNT:
                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
                    break;
                case NON_DISCOUNT:
                    discountAmount = Money.ZERO;
                    break;
                }
                
            fee = movie.getFee().minus(discountAmount).times(audienceCount);
        } else {
            fee = movie.getFee();
        }

        return new Reservation(customer, screening, fee, audienceCount);
    }
}
