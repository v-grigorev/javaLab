public class Push implements Command {
    @Override
    public void makeCommand(String[] arguments) {
        try {
            if (arguments.length > 1) {
                throw new Exception("Wrong amount of arguments in command PUSH");
            }
            if (arguments[0].chars().allMatch(Character::isDigit)) {   // если аргумент это число
                Double argument = Double.parseDouble(arguments[0]);
                ExecutionContext.stack.push(argument);
            }
            else {
                Double argument = ExecutionContext.map.get(arguments[0]);
                if (argument == null) {
                    throw new Exception("Unknown parameter in command PUSH");
                }
                ExecutionContext.stack.push(argument);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
