import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandFactory {
    public static Command createCommand(String command) {
        try {
            Class<?> c = Class.forName(command);
            Constructor<?> constructor = c.getDeclaredConstructor();
            return (Command) constructor.newInstance();
        }
        catch (ClassNotFoundException e){
            //System.out.println("Class not found");
        }
        catch (InstantiationException e) {
            System.out.println("InstantiationException");
        }
        catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException");
        } catch (NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
