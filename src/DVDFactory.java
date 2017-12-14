public class DVDFactory extends VideoFactory{
    @Override
    public Video createVideo(String title, int priceCode) {
        return new DVDVideo(title, priceCode);
    }
}
