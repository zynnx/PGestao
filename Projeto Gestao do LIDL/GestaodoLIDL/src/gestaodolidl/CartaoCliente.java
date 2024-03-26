/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaodolidl;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Mário Seabra
 */
public class CartaoCliente extends Clientes{
    private static final AtomicInteger count = new AtomicInteger(9999);
    private float saldoCompras;
    private int pontos, idCartao;
    private LinkedList<Movimentos> movimentos;

    public CartaoCliente(float saldoCompras, int pontos, LinkedList<Movimentos> movimentos, String nome, String cartaoCidadao, String nif, String morada, String telefone, String email) {
        super(nome, cartaoCidadao, nif, morada, telefone, email);
        this.saldoCompras = saldoCompras;
        this.pontos = pontos;
        this.idCartao = count.incrementAndGet();
        this.movimentos = movimentos;
    }

    public CartaoCliente( String nome, String cartaoCidadao, String nif, String morada, String telefone, String email) {
        super( nome, cartaoCidadao, nif, morada, telefone, email);
    }

    public float getSaldoCompras() {
        return saldoCompras;
    }

    public void setSaldoCompras(float saldoCompras) {
        this.saldoCompras = saldoCompras;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public LinkedList<Movimentos> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(LinkedList<Movimentos> movimentos) {
        this.movimentos = movimentos;
    }
}