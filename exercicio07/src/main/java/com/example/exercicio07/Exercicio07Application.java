package com.example.exercicio07;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exercicio07Application {

	@GetMapping("/recomendar")
	public String recomendarFilme(
			@RequestParam String genero,
			@RequestParam String ambiente) {

		String recomendacao = "Não tenho uma recomendação para essa combinação.";

		if ("acao".equalsIgnoreCase(genero)) {
			if ("futurista".equalsIgnoreCase(ambiente)) {
				recomendacao = "Homens de Preto";
			} else if ("medieval".equalsIgnoreCase(ambiente)) {
				recomendacao = "Coração Valente";
			}
		} else if ("comedia".equalsIgnoreCase(genero)) {
			if ("escola".equalsIgnoreCase(ambiente)) {
				recomendacao = "American Pie";
			} else if ("trabalho".equalsIgnoreCase(ambiente)) {
				recomendacao = "Se Beber, Não Case!";
			}
		} else if ("romance".equalsIgnoreCase(genero)) {
			if ("cidade".equalsIgnoreCase(ambiente)) {
				recomendacao = "Antes do Amanhecer";
			} else if ("campo".equalsIgnoreCase(ambiente)) {
				recomendacao = "O Segredo de Brokeback Mountain";
			}
		} else if ("terror".equalsIgnoreCase(genero)) {
			if ("floresta".equalsIgnoreCase(ambiente)) {
				recomendacao = "O Projeto Bruxa de Blair";
			} else if ("casa".equalsIgnoreCase(ambiente)) {
				recomendacao = "O Invocação do Mal";
			}
		}

		return recomendacao;
	}
}