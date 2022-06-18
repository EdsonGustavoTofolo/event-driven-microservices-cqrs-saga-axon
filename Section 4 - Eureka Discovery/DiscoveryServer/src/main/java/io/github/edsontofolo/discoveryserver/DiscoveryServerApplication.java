package io.github.edsontofolo.discoveryserver;

import org.bouncycastle.jcajce.provider.digest.MD2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@EnableEurekaServer
@SpringBootApplication
public class DiscoveryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServerApplication.class, args);

        List<Integer> integers = List.of(1, 2, 3, 4);
    }

}
