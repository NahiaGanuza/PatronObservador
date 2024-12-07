import javax.swing.*;

public class UserGUI extends JFrame {
    private Subscriber subscriber;

    public UserGUI(String userName) {
        subscriber = new Subscriber(userName);
        setTitle("User: " + userName);
    }
}
