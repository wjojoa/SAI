package com.sai;

import com.sai.model.LibroDiario;
import com.sai.repository.LibroDiarioCrudRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaiApplication.class, args);
	}

	public static class LibroDiario {
		private LibroDiarioCrudRepository libroDiarioCrudRepository;
	}
}
