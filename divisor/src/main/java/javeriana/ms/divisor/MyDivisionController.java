package javeriana.ms.divisor;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyDivisionController {

    @Autowired
    Environment environment;

    @Autowired
    MongoDB mongoDB;

    @GetMapping("/division")
    public String division( @RequestParam int a ,  @RequestParam int b, @RequestParam String user) throws UnknownHostException{
        String port = environment.getProperty("local.server.port");
        mongoDB.save(user, "division");
        return "Resultado: " + String.valueOf(a / b) + " Respuesta originada desde: " + port;
    }
    
    @GetMapping("/logs")
    public ResponseLog minusLogs(){
        String port = environment.getProperty("local.server.port");
        return mongoDB.getDocuments("division");
    }
}
