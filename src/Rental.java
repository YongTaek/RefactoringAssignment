import java.util.Date;

public class Rental {

    public static final int BaseDaysRented = 2;


    private Video video;
    private int status; // 0 for Rented, 1 for Returned
    private Date rentDate;
    private Date returnDate;
    private RentalPricesStrategy pricesStrategy;

    public Rental(Video video) {
        this.video = video;
        status = 0;
        rentDate = new Date();
    }

    public RentalPricesStrategy getPricesStrategy() {
        return pricesStrategy;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public int getStatus() {
        return status;
    }

    public void returnVideo() {
        if (status == 1) {
            this.status = 1;
            returnDate = new Date();
        }
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getDaysRented() {
        return new DaysRentedComputation(this).invoke();
    }

    public int getPoint() {
        int eachPoint = 1;
        // Introduce explaining Variable(isNewRelease) maybe Done
        boolean isNewRelease = getVideo().getPriceCode() == PriceCode.NEW_RELEASE;
        if (isNewRelease)
            eachPoint++;
        return eachPoint;
    }

    public int getPointPenalty(int eachPoint, int daysRented) {
        if (daysRented > video.getDaysRentedLimit(this))
            eachPoint -= Math.min(eachPoint, getVideo().getLateReturnPointPenalty());
        return eachPoint;
    }

    public String getVideoTitle() {
        return video.getTitle();
    }

    public PriceCode getVideoPriceCode() {
        return video.getPriceCode();
    }
}