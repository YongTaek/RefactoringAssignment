import java.util.Date;

public class DVDVideo extends Video{
    public DVDVideo(String title, PriceCode priceCode) {
        super(title, priceCode);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return 3;
    }

    @Override
    public int getLimit() {
        return 2;
    }
}
