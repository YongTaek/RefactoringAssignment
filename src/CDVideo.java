import java.util.Date;

public class CDVideo extends Video{
    public CDVideo(String title, PriceCode priceCode) {
        super(title, priceCode);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return 2;
    }

    @Override
    public int getLimit() {
        return 3;
    }
}
