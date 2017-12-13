import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
	private String name;

	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rental> getRentals() {
		return Collections.unmodifiableList(rentals);
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);

	}

	// Principle: SRP
	// Smell: Divergent change
	// Smell: Feature envy
	// Smell: Long method
	// Smell: Switch statement
	
	// Replace method with method object(CustomerReportGenerator) Done
	public String getReport() {
		return new CustomerReportGenerator(this).invoke();
	}


	void getCusomerSummary() {
		System.out.println("Name: " + getName() +
                "\tRentals: " + getRentals().size()) ;
		for ( Rental rental: getRentals() ) {
            // Hide delegate: create getVideoTitle() in Rental
            System.out.print("\tTitle: " + rental.getVideoTitle() + " ") ;
            // Hide delegate: create getVideoPriceCode() in Rental
            System.out.print("\tPrice Code: " + rental.getVideoPriceCode()) ;

        }
	}

	void printCurrentRental() {
		System.out.println("Name: " + getName() +
                "\tRentals: " + getRentals().size()) ;
		for ( Rental rental: getRentals() ) {
            // Hide delegate: create getVideoTitle() in Rental Done
            //***** Client가 객체 위임  Class를 직접 호출 --> 서버에 Method를 만들어 대리객체(delegate)를 숨김
            System.out.print("\tTitle: " + rental.getVideoTitle() + " ") ;
            // Hide delegate: create getVideoPriceCode() in Rental Done
            System.out.print("\tPrice Code: " + rental.getVideoPriceCode()) ;
        }
	}

	void clearRental() {
		List<Rental> rentals = new ArrayList<Rental>() ;
		setRentals(rentals);
	}
}
