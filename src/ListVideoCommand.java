public class ListVideoCommand extends Command{
    public ListVideoCommand(VRUI vrui) {
        super(vrui);
    }

    @Override
    public boolean execute() {
        vrui.listVideos() ;
        return false;
    }
}
