import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    private static final String API_KEY = "AIzaSyC4TFkCYgOZeXeAUYpfmM2A6XFMqtRXSqI";
    private static final String BASE_URL = "https://www.googleapis.com/youtube/v3/search";

    public static void main(String[] args) {
        // Palabra clave para buscar en YouTube
        String searchQuery = "musica";
        int maxResults = 5; // Número máximo de resultados que deseas obtener

        try {
            // Construcción de la URL
            String urlString = String.format("%s?part=snippet&maxResults=%d&q=%s&key=%s",
                    BASE_URL, maxResults, searchQuery.replace(" ", "%20"), API_KEY);

            // Crear la conexión HTTP
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Comprobar el código de respuesta
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Leer la respuesta
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                // Mostrar el resultado
                System.out.println("Respuesta de la API:");
                System.out.println(response.toString());
            } else {
                System.out.println("Error en la conexión: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}