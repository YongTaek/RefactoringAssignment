import java.util.Date;

// Principle: SRP
// Smell: Large class
// Smell: Divergent change
public class Video {
	private String title ;

	// Replace type code with class
	private int priceCode ;
	public static final int REGULAR = 1 ;
	public static final int NEW_RELEASE =2 ;
	
	private int videoType ;
	// Replace type code with subclass
	public static final int VHS = 1 ;
	public static final int CD = 2 ;
	public static final int DVD = 3 ;
	
	// Extract class
	private Date registeredDate ;
	private boolean rented ;
	// long param
	public Video(String title, int videoType, int priceCode, Date registeredDate) {
		this.setTitle(title) ;
		this.setVideoType(videoType) ;
		this.setPriceCode(priceCode) ;
		this.registeredDate = registeredDate ;
	}

	public int getLateReturnPointPenalty() { 
		int pentalty = 0 ;
		switch ( videoType ) {
			case VHS: pentalty = 1 ; break ;
			case CD: pentalty = 2 ; break ;
			case DVD: pentalty = 3 ; break ;
		}
		return pentalty ;
	}
	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
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

	public int getVideoType() {
		return videoType;
	}

	public void setVideoType(int videoType) {
		this.videoType = videoType;
	}

	// Smell: Feature envy
    // Move method to Video
    public int getDaysRentedLimit(Rental rental) {
        int limit = 0;
        int daysRented = new DaysRentedComputation(rental).invoke();
        if (daysRented <= 2) return limit;

        switch (getVideoType()) {
            case VHS:
                limit = 5;
                break;
            case CD:
                limit = 3;
                break;
            case DVD:
                limit = 2;
                break;
        }
        return limit;
    }
}
