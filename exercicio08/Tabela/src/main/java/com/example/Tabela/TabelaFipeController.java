package com.example.Tabela;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TabelaFipeController {

    private static final String URL_API_FIPE = "https://veiculos.fipe.org.br/api/veiculos";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/valor-tabela-fipe")
    public ResponseEntity<Map<String, Object>> getValorTabelaFipe(@RequestBody Carro carro) {
        Map<String, Object> resultado = new HashMap<>();

        try {
            // Monta a URL para a requisição à API da Tabela FIPE
            String url = URL_API_FIPE + "?marca=" + carro.getMarca() + "&modelo=" + carro.getModelo() + "&ano=" + carro.getAno();

            // Faz a requisição à API da Tabela FIPE
            ResponseEntity<ValorTabelaFipeResponse> resposta = restTemplate.getForEntity(url, ValorTabelaFipeResponse.class);

            // Verifica se a resposta foi bem-sucedida
            if (resposta.getStatusCode().is2xxSuccessful()) {
                // Extrai o valor de tabela FIPE da resposta
                ValorTabelaFipeResponse dados = resposta.getBody();
                resultado.put("valor", dados.getValor());
                resultado.put("mes", dados.getMes());
            } else {
                resultado.put("erro", "Erro ao obter o valor de tabela FIPE");
            }
        } catch (Exception e) {
            resultado.put("erro", "Erro ao obter o valor de tabela FIPE: " + e.getMessage());
        }

        return ResponseEntity.ok(resultado);
    }
}