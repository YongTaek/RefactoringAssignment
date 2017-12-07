public class RegularRentalPricesStrategy implements RentalPricesStrategy {
    @Override
    public int getCharge(int daysRented) {
        int eachCharge = 2;
        // Smell: Shotgun surgery, 2 in Rental.getDaysRentalLimit
        // Place magic number with symbolic constant(BaseDaysRented) in Rental Done
        if (daysRented > Rental.BaseDaysRented)
            eachCharge += (daysRented - 2) * 1.5;
        return eachCharge;
    }

    @Override
    public int getPoint() {
        return 0;
    }
}
