import java.util.List;

public abstract class ReportGenerator {

    public String invoke() {
        // Move accumulation to collecting parameter
        // Template Method Pattern

        // Extract method(getHeader) in CustomerReportGenerator Done
        String result = getHeader();

        List<Rental> rentals = customer.getRentals();

        double totalCharge = 0;
        int totalPoint = 0;

        for (Rental each : rentals) {
            double eachCharge = 0;
            int eachPoint = 0 ;
            int daysRented = 0;

            // Smell: Duplicate code in Rental.getDaysRentedLimit

            // Extract method(getDaysRented), Move method to Rental Done

            // Replace method with method object(DaysRentedComputation) maybe Done

            // diff = duplicate
            daysRented = each.getDaysRented();

            // Strategy Pattern(RentalPriceStrategy) context: Rental
            // Extract method(getCharge), Move method to RentalPricePriceStategy maybe Done
            eachCharge = each.getPricesStrategy().getCharge(daysRented);

            // Extract method(getPoint), Move method to Rental, RentalPriceStrategy? //TODO: RentalPricesStrategy??
            // Strategy Pattern? //TODO: how?
            eachPoint = each.getPoint();

            // Smell: Feature envy
            // Extract method(getPointPenalty), Move method to Rental Done
            eachPoint = each.getPointPenalty(eachPoint, daysRented);

            // Extract method(getReportForCustomer) in CustomerReportGenerator Done
            result = getReportForCustomer(result, each, eachCharge, eachPoint, daysRented);

            // Extract method for accumulation(getTotalCharge) Done
            totalCharge = getTotalCharge(totalCharge, eachCharge);
            // Extract method for accumulation(getTotalPoint) Done
            totalPoint = getTotalPoint(totalPoint, eachPoint);
        }
        // Extract method
        result = getResultForChargeAndPoint(result, totalCharge, totalPoint);

        if ( totalPoint >= 10 ) {
            System.out.println("Congrat! You earned one free coupon");
        }
        if ( totalPoint >= 30 ) {
            System.out.println("Congrat! You earned two free coupon");
        }
        return result ;
    }

    protected abstract String getResultForChargeAndPoint(String result, double totalCharge, int totalPoint);

    protected abstract int getTotalPoint(int totalPoint, int eachPoint);

    protected abstract double getTotalCharge(double totalCharge, double eachCharge);

    protected abstract String getReportForCustomer(String result, Rental each, double eachCharge, int eachPoint, int daysRented);

    protected abstract String getHeader();
}
