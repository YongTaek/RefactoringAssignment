public class RentVideoCommand extends Command{
    public RentVideoCommand(VRUI vrui) {
        super(vrui);
    }

    @Override
    public boolean execute() {
        vrui.rentVideo() ;
        return false;
    }
}
