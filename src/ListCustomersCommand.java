public class ListCustomersCommand extends Command {
    public ListCustomersCommand(VRUI vrui) {
        super(vrui);
    }

    @Override
    public boolean execute() {
        vrui.listCustomers();
        return false;
    }
}
