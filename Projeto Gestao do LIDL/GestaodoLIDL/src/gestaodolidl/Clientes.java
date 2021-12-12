/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaodolidl;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Mário Seabra
 * @author Tiago Carvalho
 */
public class Clientes {

    private static final AtomicInteger count = new AtomicInteger(-1);
    int idCliente;
    String nome, cartaoCidadao, nif, morada, telefone, email;

    public Clientes(String nome, String cartaoCidadao, String nif, String morada, String telefone, String email) {
        this.idCliente = count.incrementAndGet();
        this.nome = nome;
        this.cartaoCidadao = cartaoCidadao;
        this.nif = nif;
        this.morada = morada;
        this.telefone = telefone;
        this.email = email;
    }
    
}
