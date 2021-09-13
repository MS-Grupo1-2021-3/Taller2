package javeriana.ms.calculadora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CalculadoraController {
    @Autowired 
    RestTemplate restTemplate;

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    //
    private String[] operations = {"sumador", "resta", "multiplicador", "division"};
    @GetMapping("/calculadora/suma")
    public String calculadoraSuma(@RequestParam int a , @RequestParam int b, @RequestParam String user){
        return restTemplate.getForObject("http://sumador/suma?a={a}&b={b}&user={user}", String.class, a,b, user);
    }

    @GetMapping("/calculadora/minus")
    public String calculadoraMinus(@RequestParam int a , @RequestParam int b, @RequestParam String user){
        return restTemplate.getForObject("http://resta/minus?a={a}&b={b}&user={user}", String.class, a,b, user);
    }

    @GetMapping("/calculadora/multiply")
    public String calculadoraMultiplication(@RequestParam int a , @RequestParam int b, @RequestParam String user){
        return restTemplate.getForObject("http://multiplicador/multiply?a={a}&b={b}&user={user}", String.class, a,b, user);
    }

    @GetMapping("/calculadora/division")
    public String calculadoraDivision(@RequestParam int a , @RequestParam int b, @RequestParam String user){
        return restTemplate.getForObject("http://divisor/division?a={a}&b={b}&user={user}", String.class, a,b, user);
    }

    @GetMapping("/calculadora/logs")
    public ResponseLog getLogs(){
        List<Log> logs = new ArrayList<>();
        Log lg = new Log("+", "");
        logs.add(lg);
        ResponseLog log = restTemplate.getForObject("http://sumador/logs", ResponseLog.class);
        logs.addAll(log.getList());
        lg = new Log("-", "");
        logs.add(lg);
        log = restTemplate.getForObject("http://resta/logs", ResponseLog.class);
        logs.addAll(log.getList());
        lg = new Log("*", "");
        logs.add(lg);
        log = restTemplate.getForObject("http://multiplicador/logs", ResponseLog.class);
        logs.addAll(log.getList());
        lg = new Log("/", "");
        logs.add(lg);
        log = restTemplate.getForObject("http://divisor/logs", ResponseLog.class);
        logs.addAll(log.getList());
        log.setList(logs);
        return log;
    }
}
