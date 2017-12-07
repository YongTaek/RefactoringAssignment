public interface RentalPricesStrategy {

    int getCharge(int daysRented);

    int getPoint();
}
