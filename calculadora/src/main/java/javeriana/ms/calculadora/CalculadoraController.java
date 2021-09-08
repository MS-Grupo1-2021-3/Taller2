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
        return restTemplate.getForObject("http://sumador/suma?a={a}&b={b}", String.class, a,b);
    }

    @GetMapping("/calculadora/minus")
    private String calculadoraMinus(@RequestParam int a , @RequestParam int b){
        return restTemplate.getForObject("http://multiplier/multiply?a={a}&b={b}", String.class, a,b);
    }

    @GetMapping("/calculadora/suma")
    private String calculadoraMultiplication(@RequestParam int a , @RequestParam int b){
        return restTemplate.getForObject("http://minus/minus?a={a}&b={b}", String.class, a,b);
    }

    @GetMapping("/calculadora/division")
    private String calculadoraDivision(@RequestParam int a , @RequestParam int b){
        return restTemplate.getForObject("http://divisor/division?a={a}&b={b}", String.class, a,b);
    }
}
