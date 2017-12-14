public class RegisterCustomerCommand extends Command{
    public RegisterCustomerCommand(VRUI vrui) {
        super(vrui);
    }

    @Override
    public boolean execute() {
        vrui.registerCustomer() ;
        return false;
    }
}
