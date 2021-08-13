package Theater;

public class NoneDicountPolicy extends DiscountPolicy{
    @Override
    protected Money getDiscountAmount(Screening screening){
        return Money.ZERO;
    }
}
