package javeriana.ms.resta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyMinusController {

    @Autowired
    Environment environment;

    @Autowired
    MongoDB mongoDB;

    @GetMapping("/minus")
    public String minus( @RequestParam int a ,  @RequestParam int b, @RequestParam String user){
        String port = environment.getProperty("local.server.port");
        mongoDB.save(user, "minus");
        return "Resultado: " + String.valueOf(a - b) + " Respuesta originada desde: " + port;
    }
    
    @GetMapping("/logs")
    public ResponseLog minusLogs(){
        String port = environment.getProperty("local.server.port");
        return mongoDB.getDocuments("minus");
    }
}
