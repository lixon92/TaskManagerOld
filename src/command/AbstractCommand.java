package command;

public abstract class AbstractCommand {

    public abstract String command();
    public abstract void execute();
    public abstract String description();

}
