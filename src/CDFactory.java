public class CDFactory extends VideoFactory {


    public Video createVideo(String title, int priceCode) {
        return new CDVideo(title, priceCode);
    }
}
