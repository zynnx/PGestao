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
 */
public class Clientes {

    private static final AtomicInteger count = new AtomicInteger(-1);
    private int idCliente;
    private String nome, cartaoCidadao, nif, morada, telefone, email;

    public Clientes(String nome, String cartaoCidadao, String nif, String morada, String telefone, String email) {
        this.idCliente = count.incrementAndGet();
        this.nome = nome;
        this.cartaoCidadao = cartaoCidadao;
        this.nif = nif;
        this.morada = morada;
        this.telefone = telefone;
        this.email = email;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCartaoCidadao() {
        return cartaoCidadao;
    }

    public void setCartaoCidadao(String cartaoCidadao) {
        this.cartaoCidadao = cartaoCidadao;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}