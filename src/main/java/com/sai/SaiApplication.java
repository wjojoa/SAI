package com.sai;

import com.sai.repository.LibroDiarioRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaiApplication.class, args);
	}

	public static class LibroDiario {
		private LibroDiarioRepository libroDiarioRepository;
	}
}
