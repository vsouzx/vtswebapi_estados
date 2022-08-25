package br.vtsoliveira.vtswebapi_estados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
public class VtswebapiEstadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(VtswebapiEstadosApplication.class, args);
	}

}
