import java.util.List;

public abstract class ReportGenerator {

    public final Customer customer;

    public ReportGenerator(Customer customer) {
        this.customer = customer;
    }

    public String invoke() {
        // Move accumulation to collecting parameter Done
        StringBuffer result = new StringBuffer();
        // Template Method Pattern

        // Extract method(getHeader) in CustomerReportGenerator Done
        getHeader(result);

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

            // Extract method(getPoint), Move method to Rental, RentalPriceStrategy //TODO: ??? how to move RentalPriceStrategy
            // Strategy Pattern?
            eachPoint = each.getPoint();

            // Smell: Feature envy
            // Extract method(getPointPenalty), Move method to Rental Done
            eachPoint = each.getPointPenalty(eachPoint, daysRented);

            // Extract method(getReportForCustomer) in CustomerReportGenerator Done
            getReportForCustomer(result, each, eachCharge, eachPoint, daysRented);

            // Extract method for accumulation(getTotalCharge) Done
            totalCharge = getTotalCharge(totalCharge, eachCharge);
            // Extract method for accumulation(getTotalPoint) Done
            totalPoint = getTotalPoint(totalPoint, eachPoint);
        }
        // Extract method Done
        getResultForChargeAndPoint(result, totalCharge, totalPoint);

        if ( totalPoint >= 10 ) {
            System.out.println("Congrat! You earned one free coupon");
        }
        if ( totalPoint >= 30 ) {
            System.out.println("Congrat! You earned two free coupon");
        }
        return result.toString();
    }

    protected abstract void getResultForChargeAndPoint(StringBuffer result, double totalCharge, int totalPoint);

    protected abstract int getTotalPoint(int totalPoint, int eachPoint);

    protected abstract double getTotalCharge(double totalCharge, double eachCharge);

    protected abstract void getReportForCustomer(StringBuffer result, Rental each, double eachCharge, int eachPoint, int daysRented);

    protected abstract void getHeader(StringBuffer result);
}
