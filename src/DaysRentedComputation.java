import java.util.Date;

class DaysRentedComputation {
    private Rental rental;

    public DaysRentedComputation(Rental rental) {
        this.rental = rental;
    }

    public int invoke() {
        int daysRented;
        if (rental.getStatus() == 1) { // returned Video
            long diff = rental.getReturnDate().getTime() - rental.getRentDate().getTime();
            daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;
        } else { // not yet returned
            long diff = new Date().getTime() - rental.getRentDate().getTime();
            daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;
        }
        return daysRented;
    }
}
