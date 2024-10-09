package com.example.transacao.dto;

public class TransacaoResponseDTO {
    private ContaDTO origem;
    private ContaDTO destino;
    private Double valor;

    public TransacaoResponseDTO(ContaDTO origem, ContaDTO destino, Double valor) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
    } 

    public ContaDTO getOrigem() {
        return origem;
    }

    public void setOrigem(ContaDTO origem) {
        this.origem = origem;
    }

    public ContaDTO getDestino() {
        return destino;
    }

    public void setDestino(ContaDTO destino) {
        this.destino = destino;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}