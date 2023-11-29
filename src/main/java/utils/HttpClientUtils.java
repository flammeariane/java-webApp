package utils;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Supplier;

public class HttpClientUtils {

    private static final HttpClient httpClient;

    static {
        // Init  gestionnaire de cookies pour le client HTTP
        CookieHandler.setDefault(new CookieManager());
        httpClient = HttpClient.newBuilder()
            .cookieHandler(CookieHandler.getDefault())
            .build();
    }


    public static HttpResponse<String> sendRequest(Supplier<HttpRequest> requestSupplier) throws IOException, InterruptedException {
        HttpRequest request = requestSupplier.get();
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
