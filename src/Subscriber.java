import java.util.HashMap;

public class Subscriber implements Observer {
    private String name;
    private HashMap<String,String> lastVideos = new HashMap<String, String>();

    public Subscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(String videoTitle, String channelTitle) {
        lastVideos.put(videoTitle, channelTitle);
    }

    @Override
    public void clearLastNotifications() {
        lastVideos.clear();
    }

    public HashMap<String,String> getLastVideos() {
        return lastVideos;
    }
}
