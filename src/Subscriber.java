public class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle, String channelTitle) {
        System.out.println("Hola " + name + ", nuevo video publicado:");
        System.out.println("Título: " + videoTitle);
        System.out.println("Canal: " + channelTitle);
    }
}
