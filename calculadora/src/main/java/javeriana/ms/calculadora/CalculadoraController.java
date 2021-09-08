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
    public String calculadoraSuma(@RequestParam int a , @RequestParam int b){
        return restTemplate.getForObject("http://sumador/suma?a={a}&b={b}", String.class, a,b);
    }

    @GetMapping("/calculadora/minus")
    public String calculadoraMinus(@RequestParam int a , @RequestParam int b){
        return restTemplate.getForObject("http://resta/minus?a={a}&b={b}", String.class, a,b);
    }

    @GetMapping("/calculadora/multiply")
    public String calculadoraMultiplication(@RequestParam int a , @RequestParam int b){
        return restTemplate.getForObject("http://multiplicador/multiply?a={a}&b={b}", String.class, a,b);
    }

    @GetMapping("/calculadora/division")
    public String calculadoraDivision(@RequestParam int a , @RequestParam int b){
        return restTemplate.getForObject("http://divisor/division?a={a}&b={b}", String.class, a,b);
    }
}
