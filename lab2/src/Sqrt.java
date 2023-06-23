public class Sqrt implements Command{
    @Override
    public void makeCommand(String[] arguments) {
        try {
            if (ExecutionContext.stack.empty()) {
                throw new Exception("stack is empty for sqrt");
            }
            Double a = ExecutionContext.stack.pop();
            if (a < 0)
                throw new Exception("number is less then zero in command sqrt");
            ExecutionContext.stack.push(Math.sqrt(a));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
