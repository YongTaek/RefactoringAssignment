import java.util.Date;

// Principle: SRP
// Smell: Large class
// Smell: Divergent change
public abstract class Video {
	private String title ;

	// Replace type code with class Done
	private PriceCode priceCode ;
	
	// Replace type code with subclass Done
	
	// Extract class
	private Date registeredDate ;
	private boolean rented ;
	// long param
	public Video(String title, PriceCode priceCode, Date registeredDate) {
		this.setTitle(title) ;
		this.setPriceCode(priceCode) ;
		this.registeredDate = registeredDate ;
	}

	public abstract int getLateReturnPointPenalty();

	public PriceCode getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(PriceCode priceCode) {
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	// Smell: Feature envy
    // Move method to Video?
    public int getDaysRentedLimit(Rental rental) {
        int limit = 0;
        int daysRented = new DaysRentedComputation(rental).invoke();
        if (daysRented <= 2) return limit;

        return getLimit();
    }

    public abstract int getLimit();
}
