public class Pop implements Command {
    @Override
    public void makeCommand(String[] arguments) {
        ExecutionContext.stack.pop();
    }
}
