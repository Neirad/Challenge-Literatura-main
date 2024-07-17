package com.alura.challange.literalura.client;

import com.alura.challange.literalura.client.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alura.challange.literalura.client.repository.AutorRepository;
import com.alura.challange.literalura.client.repository.LibroRepository;

@SpringBootApplication
public class ChallengeLiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository libroRepositorio;
	@Autowired
	private AutorRepository autorRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal client = new Principal(libroRepositorio, autorRepositorio);
		client.menu();
	}

}
