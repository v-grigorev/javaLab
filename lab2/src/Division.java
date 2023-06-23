public class Division implements Command{
    @Override
    public void makeCommand(String[] arguments) {
        try {
            if (ExecutionContext.stack.empty()) {
                throw new Exception("Stack is empty for command +");
            }
            Double a = ExecutionContext.stack.pop();
            if (ExecutionContext.stack.empty()) {
                throw new Exception("Stack is empty for command +");
            }
            Double b = ExecutionContext.stack.pop();
            if (b == 0) {
                ExecutionContext.stack.push(b);
                ExecutionContext.stack.push(a);
                throw new Exception("Division by zero");
            }
            ExecutionContext.stack.push(a / b);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
