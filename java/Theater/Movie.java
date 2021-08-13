package Theater;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy){
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee(){
        return fee;
    }

    public Money calculateMovieFee(Screening screening){
        /*
        할인 정책이 없음을 예외 케이스로 취급.
        일관성있던 협력 방식이 무너짐.
        책임의 위치를 결정하기 위해 조건문을 사용하는 것은 협력의 설계 측면에서 대부분 좋지 않음.
        if(discountPolicy == null){
            return fee;
        }
        */ 
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
