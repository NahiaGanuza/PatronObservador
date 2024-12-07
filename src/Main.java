public class Main {
    public static void main(String[] args) {
        // Crear canal YouTube y suscriptores
        YouTubeChannel channel = new YouTubeChannel("musica");
        Subscriber subscriber1 = new Subscriber("Juan");
        Subscriber subscriber2 = new Subscriber("Maria");

        // Suscribirse al canal
        channel.subscribe(subscriber1);
        channel.subscribe(subscriber2);

        // Interactuar con la API
        YouTubeAPIService apiService = new YouTubeAPIService();
        apiService.fetchVideos(channel);
    }
}
