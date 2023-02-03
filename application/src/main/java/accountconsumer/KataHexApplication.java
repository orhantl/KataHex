package accountconsumer;

import fr.bank.annotation.DomainService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.FilterType.ANNOTATION;

@SpringBootApplication
@ComponentScan(basePackages = "fr.bank", includeFilters = @ComponentScan.Filter(type = ANNOTATION, classes = DomainService.class))
public class KataHexApplication {

    public static void main(String[] args) {
        SpringApplication.run(KataHexApplication.class, args);
    }
}
