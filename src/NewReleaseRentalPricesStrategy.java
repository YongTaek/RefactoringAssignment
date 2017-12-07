public class NewReleaseRentalPricesStrategy implements RentalPricesStrategy {
    @Override
    public int getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getPoint() {
        return 0;
    }
}
