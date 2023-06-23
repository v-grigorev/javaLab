public class Print implements Command {
    @Override
    public void makeCommand(String[] arguments) {
        try {
            if (arguments != null) {
                throw new Exception("PRINT don't have arguments");
            }
            System.out.println(ExecutionContext.stack.peek());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
