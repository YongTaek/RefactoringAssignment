public class VHSFactory extends VideoFactory{
    @Override
    public Video createVideo(String title, int priceCode) {
        return new VHSVideo(title, priceCode);
    }
}
