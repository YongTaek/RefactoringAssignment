public class ReturnVideoCommand extends Command{
    public ReturnVideoCommand(VRUI vrui) {
        super(vrui);
    }

    @Override
    public boolean execute() {
        vrui.returnVideo() ;
        return false;
    }
}
