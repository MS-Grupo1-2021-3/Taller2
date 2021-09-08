package javeriana.ms.calculadora;

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

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    
    @GetMapping("/calculadora/suma")
    private String calculadoraSuma(@RequestParam int a , @RequestParam int b){
        String response = restTemplate.getForObject("http://sumador/suma?a={a}&b={b}", String.class, a,b);
        return response;

    }
}
