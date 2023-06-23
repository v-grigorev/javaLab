public class LineProcessing {
    public static String getCommand(String line) {
        String[] parts = line.split(" ");
        return parts[0];
    }

    public static String[] getArgument(String line) {

        String[] parts = line.split(" ");
        if (parts.length == 1) {
            return null;
        }
        String[] arguments = new String[parts.length - 1];
        System.arraycopy(parts, 1, arguments, 0, arguments.length);
        return arguments;
    }
}
