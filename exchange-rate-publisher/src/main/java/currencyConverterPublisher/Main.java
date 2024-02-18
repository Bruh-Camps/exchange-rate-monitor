package currencyConverterPublisher;

import org.json.JSONException;

import java.io.IOException;
import java.net.http.HttpTimeoutException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        try {
            CurrencyConverter currencyConverter = new CurrencyConverter("BRL");
        }catch (IOException | InterruptedException | JSONException ex){
            System.out.println("Não foi possível obter a taxa de câmbio atual. Verifique a conexão com a internet! " + ex);
        }



    }



}