package Theater_Data_Driven;

import java.time.Duration;
import java.util.List;
import java.util.Collections;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;
    
    private MovieType movietype;
    private Money discountAmount;
    private double discountPercent;

    public Movie(String title, Duration runningTime){
        this.title = title;
        this.runningTime = runningTime;
    }

    public MovieType getMovieType(){
        return movietype;
    }

    public void setMovieType(MovieType movieType){
        this.movietype = movieType;
    }

    public Money getFee(){
        return fee;
    }

    public void setFee(Money fee){
        this.fee = fee;
    }

    public List<DiscountCondition> getDiscounConditions(){
        return Collections.unmodifiableList(discountConditions);
    }

    public void setDiscountConditions(
        List<DiscountCondition> discountConditions
    ){
        this.discountConditions = discountConditions;
    }

    public Money getDiscountAmount(){
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount){
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent(){
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent){
        this.discountPercent = discountPercent;
    }
}
