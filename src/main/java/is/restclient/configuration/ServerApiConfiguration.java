package is.restclient.configuration;

import is.restclient.ApiClient;
import is.restclient.api.BookControllerApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServerApiConfiguration {

    @Value("${restserver.address}")
    public String serverAddress;

    @Bean
    public BookControllerApi bookControllerApi(ApiClient apiClient) {
        return new BookControllerApi(apiClient);
    }

    @Bean
    public ApiClient apiClient() {
        final ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(serverAddress);
        return apiClient;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
