public class CustomerReportGenerator extends ReportGenerator{


    public CustomerReportGenerator(Customer customer) {
        super(customer);
    }

    public void getResultForChargeAndPoint(StringBuffer result, double totalCharge, int totalPoint) {
        result.append("Total charge: " + totalCharge + "\tTotal Point:" + totalPoint + "\n");
    }

    public int getTotalPoint(int totalPoint, int eachPoint) {
        totalPoint += eachPoint ;
        return totalPoint;
    }

    public double getTotalCharge(double totalCharge, double eachCharge) {
        totalCharge += eachCharge;
        return totalCharge;
    }

    public void getReportForCustomer(StringBuffer result, Rental each, double eachCharge, int eachPoint, int daysRented) {
        result.append("\t" + each.getVideo().getTitle() + "\tDays rented: " + daysRented + "\tCharge: " + eachCharge
                + "\tPoint: " + eachPoint + "\n");
    }

    public void getHeader(StringBuffer result) {
        result.append("Customer Report for " + customer.getName() + "\n");
    }
}