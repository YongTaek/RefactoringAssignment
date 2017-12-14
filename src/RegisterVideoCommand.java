public class RegisterVideoCommand extends Command{
    public RegisterVideoCommand(VRUI vrui) {
        super(vrui);
    }

    @Override
    public boolean execute() {
        vrui.registerVideo();
        return false;
    }
}
