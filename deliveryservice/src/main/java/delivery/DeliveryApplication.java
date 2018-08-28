package delivery;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DeliveryApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DeliveryApplication.class).run(args);
    }
}
