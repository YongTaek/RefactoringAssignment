public abstract class Command {

    protected VRUI vrui;

    public Command(VRUI vrui) {
        this.vrui = vrui;
    }

    public abstract boolean execute();
}
