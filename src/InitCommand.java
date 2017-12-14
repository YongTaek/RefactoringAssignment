public class InitCommand extends Command{
    public InitCommand(VRUI vrui) {
        super(vrui);
    }

    @Override
    public boolean execute() {
        vrui.init();
        return false;
    }
}
