package au.com.telstra.simcardactivator;

import au.com.telstra.simcardactivator.Sim;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimCardController {

    private final ActuatorHandler actuatorHandler;

    public SimCardController(ActuatorHandler actuatorHandler) {
        this.actuatorHandler = actuatorHandler;
    }

    @PostMapping(value = "/activate")
    public void handleActivationRequest(@RequestBody Sim simCard) {
        var actuationResult = actuatorHandler.actuate(simCard);
        System.out.println(actuationResult.getSuccess());
    }

}