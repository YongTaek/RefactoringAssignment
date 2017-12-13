import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VRUI {
	private static Scanner scanner = new Scanner(System.in) ;

	// Separate domain from presentation
	
	// Replace data value with object: CustomerManager Done
	private CustomerManager customerManager = new CustomerManager();

	// Replace data value with object: VideoManager Done
	private VideoManager videoManager = new VideoManager();
	
	public static void main(String[] args) {
		VRUI ui = new VRUI() ;
		
		boolean quit = false ;
		while ( ! quit ) {
			// Replace conditional dispatcher with Command Pattern
			int command = ui.showCommand() ;
			switch ( command ) {
				case 0: quit = true ; break ;
				case 1: ui.listCustomers() ; break ;
				case 2: ui.listVideos() ; break ;
				case 3: ui.registerCustomer() ; break ;
				case 4: ui.registerVideo(); ; break ;
				case 5: ui.rentVideo() ; break ;
				case 6: ui.returnVideo() ; break ;
				case 7: ui.getCustomerReport() ; break; 
				case 8: ui.clearRentals() ; break ;
				case -1: ui.init() ; break ;
				default: break ;
			}
		}
		System.out.println("Bye");
	}

	public void clearRentals() {
		System.out.println("Enter customer name: ") ;
		String customerName = scanner.next() ;
		
		// Extract method(findCustomer), Move method to CustomerManager Done
		Customer foundCustomer = customerManager.findCustomer(customerName);

		if ( foundCustomer == null ) {
			System.out.println("No customer found") ;
		}
		else {
			// Principle: SRP
			// Separate query from modifier Done
			// query
			foundCustomer.printCurrentRental();
			// modifier
			foundCustomer.clearRental();
		}
	}


	public void returnVideo() {
		System.out.println("Enter customer name: ") ;
		String customerName = scanner.next() ;
		
		Customer foundCustomer = customerManager.findCustomer(customerName);
		if ( foundCustomer == null ) return ;
		
		System.out.println("Enter video title to return: ") ;
		String videoTitle = scanner.next() ;

		returnVideo(foundCustomer, videoTitle);
	}

	//TODO: Check
	private void returnVideo(Customer foundCustomer, String videoTitle) {
		List<Rental> customerRentals = foundCustomer.getRentals() ;
		for ( Rental rental: customerRentals ) {
			// Introduce explaining variable Done
			boolean isVideoMatched = rental.getVideo().getTitle().equals(videoTitle);
			boolean isVideoRented = rental.getVideo().isRented();
			if ( isVideoMatched && isVideoRented ) {
				rental.returnVideo();
				rental.getVideo().setRented(false);
				break ;
			}
		}
	}

	private void init() {
		Customer james = new Customer("James") ;
		Customer brown = new Customer("Brown") ;
		customerManager.addCustomer(james) ;
		customerManager.addCustomer(brown) ;
		Video v1 = new CDVideo("v1", PriceCode.REGULAR) ;
		Video v2 = new DVDVideo("v2", PriceCode.NEW_RELEASE) ;
		videoManager.addVideo(v1) ;
		videoManager.addVideo(v2) ;
		
		Rental r1 = new Rental(v1) ;
		Rental r2 = new Rental(v2) ;
		
		james.addRental(r1) ;
		james.addRental(r2) ;
	}

	public void listVideos() {
		System.out.println("List of videos");
		
		for ( Video video: videoManager.getVideos() ) {
			System.out.println("Price code: " + video.getPriceCode() +"\tTitle: " + video.getTitle()) ;
		}
		System.out.println("End of list");
	}

	public void listCustomers() {
		System.out.println("List of customers");
		
		// Extract method(getCustomerList), Move method to CustomerManager Done
		customerManager.getCustomerList();
		System.out.println("End of list");
	}

	public void getCustomerReport() {
		System.out.println("Enter customer name: ") ;
		String customerName = scanner.next() ;
		
		// Extract method(findCustomer), Move method to CustomerManager Done
		Customer foundCustomer = customerManager.findCustomer(customerName);

		if ( foundCustomer == null ) {
			System.out.println("No customer found") ;
		}
		else {
			String result = foundCustomer.getReport() ;
			System.out.println(result);
		}
	}

	public void rentVideo() {
		System.out.println("Enter customer name: ") ;
		String customerName = scanner.next() ;

		// Extract method, Move method to CustomerManager Done
		Customer foundCustomer = customerManager.findCustomer(customerName);
		if ( foundCustomer == null ) return ;
		
		System.out.println("Enter video title to rent: ") ;
		String videoTitle = scanner.next() ;

		// Extract method, Move method to VideoManager Done
		Video foundVideo = videoManager.findVideo(videoTitle);
		if ( foundVideo == null ) return ;
		
		Rental rental = new Rental(foundVideo) ;
		foundVideo.setRented(true);
		
		// Smell: Inappropriate intimacy
		// Encapsulate collection Done
		foundCustomer.addRental(rental);
	}

	// Replace parameter with explicit methods Done
	private void registerVideo() {
		System.out.println("Enter video title to register: ") ;
		String title = scanner.next() ;

		System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):") ;
		int videoType = scanner.nextInt();

		System.out.println("Enter price code( 1 for Regular, 2 for New Release ):") ;
		int priceCode = scanner.nextInt();

		// Factory Method Pattern
		// Replace parameter(registereddDate) with method
		// Extract method(addVideo(title, priceCode)), Move method to VideoManager
		Date registeredDate = new Date();
		Video video = new Video(title, videoType, priceCode);
		videoManager.addVideo(video);
	}

	private void registerCustomer() {
		System.out.println("Enter customer name: ") ;
		String name = scanner.next();

		// Factory Method Pattern
		// Extract method(addCustomer(name)), Move method to CustomerManager Done
		customerManager.addCustomer(name);
	}

	public int showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. List customers");
		System.out.println("\t 2. List videos");
		System.out.println("\t 3. Register customer");
		System.out.println("\t 4. Register video");
		System.out.println("\t 5. Rent video");
		System.out.println("\t 6. Return video");
		System.out.println("\t 7. Show customer report");
		System.out.println("\t 8. Show customer and clear rentals");
		
		int command = scanner.nextInt() ;
		
		return command ;
		
	}
}
