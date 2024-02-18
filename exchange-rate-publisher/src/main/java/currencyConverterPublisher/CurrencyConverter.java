package currencyConverterPublisher;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import static java.time.temporal.ChronoUnit.SECONDS;

public class CurrencyConverter {
    HttpClient httpClient = null;
    HttpRequest httpRequest = null;

    public CurrencyConverter(String baseCurrency) throws IOException, InterruptedException, JSONException {
        String api_url = getAPI_URL(baseCurrency);

        //Cliente para fazer as solicitações HTTP
        httpClient = HttpClient.newHttpClient();

        //Cria o objeto que representa a solicitação que será enviada
        httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(api_url))
                .timeout(Duration.of(30, SECONDS))
                .GET()
                .build();

        //Envia a solicitação e recebe a resposta
        //HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        //JSONObject jsonResponse = new JSONObject(response.body());

        String sampleResponse = "{\n" +
                " \"result\":\"success\",\n" +
                " \"documentation\":\"https://www.exchangerate-api.com/docs\",\n" +
                " \"terms_of_use\":\"https://www.exchangerate-api.com/terms\",\n" +
                " \"time_last_update_unix\":1708214401,\n" +
                " \"time_last_update_utc\":\"Sun, 18 Feb 2024 00:00:01 +0000\",\n" +
                " \"time_next_update_unix\":1708300801,\n" +
                " \"time_next_update_utc\":\"Mon, 19 Feb 2024 00:00:01 +0000\",\n" +
                " \"base_code\":\"BRL\",\n" +
                " \"conversion_rates\":{\n" +
                "  \"BRL\":1,\n" +
                "  \"EUR\":0.1867,\n" +
                "  \"USD\":0.2011\n" +
                " }\n" +
                "}";


        JSONObject jsonResponse = new JSONObject(sampleResponse);
        System.out.println(jsonResponse);
    }

    private String getAPI_URL(String baseCurrency){
        //Recupera a chave da API a partir da variável de ambiente
        //Uma chave pode ser obtida em https://app.exchangerate-api.com/
        Map<String, String> env = System.getenv();
        String api_key = env.get("API_KEY");
        return "https://v6.exchangerate-api.com/v6/" + api_key + "/latest/" + baseCurrency;
    }

}
