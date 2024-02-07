package currencyConverterPublisher;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Map;

public class CurrencyConverter {
    HttpClient httpClient = null;
    HttpRequest httpRequest = null;

    public CurrencyConverter(){
        httpClient = HttpClient.newHttpClient();
        //httpRequest = HttpRequest.newBuilder()
        //        .uri(URI.create(API_URL))
        //        .build();
    }

    private String getAPI_URL(String baseCurrency){
        //Recupera a chave da API a partir da variável de ambiente
        //Uma chave pode ser obtida em https://app.exchangerate-api.com/
        Map<String, String> env = System.getenv();
        String api_key = env.get("API_KEY");
        return "https://v6.exchangerate-api.com/v6/" + api_key + "/latest/" + baseCurrency;
    }

}
