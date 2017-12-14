public class VHSVideo extends Video{
    public VHSVideo(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return 1;
    }


    @Override
    public int getLimit() {
        return 5;
    }
}
