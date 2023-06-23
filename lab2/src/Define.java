public class Define implements Command {
    @Override
    public void makeCommand(String[] arguments) {
        try {
            if (arguments.length != 2) {
                throw new Exception("Wrong count of arguments in command DEFINE");
            }
            if (arguments[0].chars().allMatch(Character::isDigit)) {
                throw new Exception("First argument in DEFINE must be a letter");
            }
            ExecutionContext.map.put(arguments[0], Double.parseDouble(arguments[1]));
            Double c = ExecutionContext.map.get(arguments[0]);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
