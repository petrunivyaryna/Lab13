package ucu.edu.thirdtask;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class OpenAIEnricher {
    @SneakyThrows
    public static String extract(String prompt) {
        String myUrl = "https://api.openai.com/v1/chat/completions";
        String apiKey = System.getenv("MY_OPEN_AI_API");
        String model = "gpt-3.5-turbo";

        try {
            URL obj = new URI(myUrl).toURL();
            HttpURLConnection connection = 
                        (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setRequestProperty("Content-Type", "application/json");

            String body = "{\"model\": \"" + model +
        "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";

            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(
                    connection.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line;

            StringBuffer response = new StringBuffer();

            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            return extractMessageFromJSONResponse(response.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String extractMessageFromJSONResponse(String response) {
        int start = response.indexOf("content")+ 11;

        int end = response.indexOf("\"", start);

        return response.substring(start, end);

    }
}