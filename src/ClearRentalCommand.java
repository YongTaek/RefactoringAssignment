public class ClearRentalCommand extends Command{
    public ClearRentalCommand(VRUI vrui) {
        super(vrui);
    }

    @Override
    public boolean execute() {
        vrui.clearRentals() ;
        return false;
    }
}
