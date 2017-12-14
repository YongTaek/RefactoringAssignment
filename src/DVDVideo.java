public class DVDVideo extends Video{
    public DVDVideo(String title, int priceCode) {
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
