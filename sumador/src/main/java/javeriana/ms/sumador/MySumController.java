package javeriana.ms.sumador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class MySumController {

    @Autowired
    Environment environment;

    @GetMapping("/suma")
    public String sum( @RequestParam int a ,  @RequestParam int b){
        String port = environment.getProperty("local.server.port");
        String response = "Resultado:" + String.valueOf(a+b) + " Respuesta originada desde: " + port;
        return response;
    }
    
}
