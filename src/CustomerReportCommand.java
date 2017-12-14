public class CustomerReportCommand extends Command{
    public CustomerReportCommand(VRUI vrui) {
        super(vrui);
    }

    @Override
    public boolean execute() {
        vrui.getCustomerReport() ;
        return false;
    }
}
