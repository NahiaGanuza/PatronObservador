import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class YouTubeAPIService {
    private static final String API_KEY = "AIzaSyC4TFkCYgOZeXeAUYpfmM2A6XFMqtRXSqI";
    private static final String BASE_URL = "https://www.googleapis.com/youtube/v3/search";

    public void fetchVideos(YouTubeChannel channel) {
        String searchQuery = channel.getSearchQuery();
        int maxResults = 5;

        try {
            String urlString = String.format("%s?part=snippet&maxResults=%d&q=%s&key=%s",
                    BASE_URL, maxResults, searchQuery.replace(" ", "%20"), API_KEY);

            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray items = jsonResponse.getJSONArray("items");

                for (int i = 0; i < items.length(); i++) {
                    JSONObject video = items.getJSONObject(i).getJSONObject("snippet");
                    String videoTitle = video.getString("title");
                    String channelTitle = video.getString("channelTitle");

                    // Notificar a los observadores
                    channel.notifyObservers(videoTitle, channelTitle);
                }
            } else {
                System.out.println("Error en la conexión: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
