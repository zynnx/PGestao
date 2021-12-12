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
 * @author Tiago Carvalho
 */
public class CartaoCliente extends Clientes{
    private static final AtomicInteger count = new AtomicInteger(9999);
    float saldoCompras;
    int pontos, idCartao;
    LinkedList<Movimetos> movimentos;

    public CartaoCliente(float saldoCompras, int pontos, LinkedList<Movimetos> movimentos, String nome, String cartaoCidadao, String nif, String morada, String telefone, String email) {
        super(nome, cartaoCidadao, nif, morada, telefone, email);
        this.saldoCompras = saldoCompras;
        this.pontos = pontos;
        this.idCartao = count.incrementAndGet();
        this.movimentos = movimentos;
    }

    public CartaoCliente( String nome, String cartaoCidadao, String nif, String morada, String telefone, String email) {
        super( nome, cartaoCidadao, nif, morada, telefone, email);
    }
}