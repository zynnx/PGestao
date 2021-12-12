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
public class Artigos {
    private static final AtomicInteger count = new AtomicInteger(999);
    int codigoArtigo, stock;
    float preco;
    String descricao;

    public Artigos(int stock, float preco, String descricao) {
        this.codigoArtigo = count.incrementAndGet();
        this.stock = stock;
        this.preco = preco;
        this.descricao = descricao;
    }
}
   