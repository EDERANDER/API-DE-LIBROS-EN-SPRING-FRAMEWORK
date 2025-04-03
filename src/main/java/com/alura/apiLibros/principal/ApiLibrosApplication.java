package com.alura.apiLibros.principal;

import com.alura.apiLibros.service.Consumo;
import com.alura.apiLibros.service.InformacioLibro;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiLibrosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiLibrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EstructuraPrincipal estructuraPrincipal = new EstructuraPrincipal();
		estructuraPrincipal.menuPrincipal();


	}
}
