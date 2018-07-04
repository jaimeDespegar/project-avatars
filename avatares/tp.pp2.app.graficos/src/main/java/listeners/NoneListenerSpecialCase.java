package listeners;

public class NoneListenerSpecialCase implements Listener {

    @Override
    public void doAction() {
        System.out.println("Do not action , no exists a Listener associated a this key Pressed");
    }

}
