package au.com.telstra.simcardactivator;

import au.com.telstra.simcardactivator.ActuatorResponse;
import au.com.telstra.simcardactivator.Sim;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActuatorHandler {
    private final RestTemplate restTemplate;
    private final String incentiveApiUrl;

    public ActuatorHandler(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
        this.incentiveApiUrl = "http://localhost:8444/actuate";
    }

    public ActuatorResponse actuate(Sim simCard) {
        return restTemplate.postForObject(incentiveApiUrl, simCard, ActuatorResponse.class);
    }

}