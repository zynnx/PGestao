/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaodolidl;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Mário Seabra
 */
public class Artigos {
    private static final AtomicInteger count = new AtomicInteger(999);
    private int codigoArtigo;
    private int stock;
    private float preco;
    private String descricao;

    public Artigos(int stock, float preco, String descricao) {
        this.codigoArtigo = count.incrementAndGet();
        this.stock = stock;
        this.preco = preco;
        this.descricao = descricao;
    }

    public int getCodigoArtigo() {
        return codigoArtigo;
    }

    public void setCodigoArtigo(int codigoArtigo) {
        this.codigoArtigo = codigoArtigo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Cria artigos e adiciona a uma linklist
     *
     * @param list lista Artigos
     * @param num quantidade a adicionar
     */
    public static void criarArtigo(LinkedList<Artigos> list, int num) {
        Scanner ler = new Scanner(System.in);
        for (int i = 1; i <= num; i++) {
            System.out.println("Indique o nome do artigo " + i + ":");
            String nome = ler.next();
            System.out.println("Indique a quantidade de stock " + i + ":");
            while (!ler.hasNextInt()) {
                ler.next();
                System.err.print("\nNao e um numero. Por favor tenta outra vez!!!\n");
            }
            int stock = ler.nextInt();
            System.out.println("Indique o preço unitario " + i + ":");
            while (!ler.hasNextFloat()) {
                ler.next();
                System.err.print("\nNao e um numero. Por favor tenta outra vez!!!\n");
            }
            float preco = ler.nextFloat();
            list.add(new Artigos(stock, preco, nome));
        }
    }

}