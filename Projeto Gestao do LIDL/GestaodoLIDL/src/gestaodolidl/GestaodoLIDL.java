/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaodolidl;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.*;

/**
 *
 * @author Mário Seabra
 */
public class GestaodoLIDL {

    /**
     * Cria artigos e adiciona a uma linklist
     *
     * @param list lista Artigos
     * @param num quantidade a adicionar
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
    }*/

    /**
     * imprimir lista
     *
     * @param list lista de artigos
     */
    public static void imprimirArtigos(LinkedList<Artigos> list) {
        System.out.println("----------Artigos---------\n");
        if (list.isEmpty()) {
            System.out.println("\nA lista esta vazia!!!\n");
        } else {
            for (Artigos str : list) {
                System.out.println("Codigo do Artigo: " + str.getCodigoArtigo() + " / " + "Nome: " + str.getDescricao() + " / " + "Stock: " + str.getStock() + " / " + "Preço Unitario: " + str.getPreco() + "€;\n");
            }
        }
    }

    /**
     * actualiza a quantidade de stock de um certo produto
     *
     * @param list lista de artigos
     */
    public static void actualizarStock(LinkedList<Artigos> list) {
        Scanner ler = new Scanner(System.in);
        if (list.isEmpty()) {
            System.out.println("\nA lista esta vazia!!!");
        } else {
            System.out.println("Insira o codigo do Artigo:");
            while (!ler.hasNextInt()) {
                ler.next();
                System.err.print("\nNao e um numero. Por favor tenta outra vez!!!\n");
            }
            int id = ler.nextInt();

            for (Artigos str : list) {
                if (str.getCodigoArtigo() == id) {
                    System.out.println("Indique a quantidade de stock: ");
                    while (!ler.hasNextInt()) {
                        ler.next();
                        System.err.print("\nNao e um numero. Por favor tenta outra vez!!!\n");
                    }
                    int stock = ler.nextInt();
                    str.setStock(stock);
                } else {
                    System.out.println("Nao existe");
                }
            }
        }
    }

    /**
     * Remove um artigo completo da lista
     *
     * @param list lista de artigos
     */
    public static void removerArtigos(LinkedList<Artigos> list) {
        Scanner ler = new Scanner(System.in);
        if (list.isEmpty()) {
            System.out.println("\nA lista esta vazia!!!");
        } else {
            System.out.println("Insira o ID");
            while (!ler.hasNextInt()) {
                ler.next();
                System.err.print("\nNao e um numero. Por favor tenta outra vez!!!\n");
            }
            int id = ler.nextInt();
            for (Artigos str : list) {
                if (str.getCodigoArtigo() == id) {
                    list.remove(str);
                } else {
                    System.out.println("Esse id não existe");
                }
            }
        }
    }

    /**
     * Cria clientes e adiciona a uma linklist
     *
     * @param list lista CartaoCliente
     * @param num quantidade a criar de Clientes
     */
    public static void criarCliente(LinkedList<CartaoCliente> list, int num) {
        Scanner ler = new Scanner(System.in);

        for (int i = 1; i <= num; i++) {
            System.out.println("Dados do Cliente " + i);
            System.out.println("Indique o nome: ");
            String nome = ler.next();
            System.out.println("Indique o numero do cartao de cidadão:");
            String cartaoCidadao = ler.next();
            System.out.println("Indique o numero de identificação fiscal:");
            String nif = ler.next();
            System.out.println("Indique a morada:");
            String morada = ler.next();
            System.out.println("Indique o numero de telemovel:");
            String telefone = ler.next();
            while (!VerificarTele(telefone)) {
                System.err.print("Numero invalido. Por favor tenta outra vez: ");
                telefone = ler.next();
            }
            System.out.println("Indique o email:");
            String email = ler.next();
            while (!validate(email)) {
                System.err.print("Email invalido. Por favor tenta outra vez: ");
                email = ler.next();
            }
            list.add(new CartaoCliente(nome, cartaoCidadao, nif, morada, telefone, email));
        }
    }

    /**
     * Regista a quantidade de artigos que um certo cliente comprou e adicona o
     * movimneto que fez a uma outra lista
     *
     * @param list lista CartaoCliente
     * @param artigoList lista Artigos
     * @param movimentos lista Movimentos
     */
    public static void registo(LinkedList<CartaoCliente> list, LinkedList<Artigos> artigoList, LinkedList<Movimentos> movimentos) {
        if (list.isEmpty()) {
            System.out.println("A lista esta vazia!!!");
        } else {
            Scanner ler = new Scanner(System.in);
            float totalCompra = 0;
            int somaPontos = 3, j = 0;

            System.out.println("Introduza o seu ID:");
            while (!ler.hasNextInt()) {
                ler.next();
                System.err.print("\nNao e um numero. Por favor tenta outra vez!!!\n");
            }
            int id = ler.nextInt();

            System.out.println("Quantos artigos deseja comprar? ");
            while (!ler.hasNextInt()) {
                ler.next();
                System.err.print("\nNao e um numero. Por favor tenta outra vez!!!\n");
            }
            int num = ler.nextInt();
            while (j < num) {
                for (CartaoCliente str : list) {
                    if (str.getIdCliente() == id) {
                        System.out.println("Escolha o artigo pelo numero do id que deseja comprar: ");
                        while (!ler.hasNextInt()) {
                            ler.next();
                            System.err.print("\nNao e um numero. Por favor tenta outra vez!!!\n");
                        }
                        int escolha = ler.nextInt();
                        for (Artigos strArt : artigoList) {
                            if (strArt.getCodigoArtigo() == escolha) {
                                System.out.println("Quantidade que deseja deste artigo: " + strArt.getDescricao());
                                while (!ler.hasNextInt()) {
                                    ler.next();
                                    System.err.print("\nNao e um numero. Por favor tenta outra vez!!!\n");
                                }
                                int compra = ler.nextInt();
                                if (strArt.getStock() >= compra) {
                                    totalCompra = compra * strArt.getPreco();
                                    strArt.setStock(strArt.getStock() - compra);

                                    int pontosGanhos = (int) (somaPontos * (totalCompra / 50));
                                    str.setPontos(str.getPontos() + pontosGanhos);
                                    str.setSaldoCompras(str.getSaldoCompras() + totalCompra);

                                    str.getMovimentos().add(new Movimentos(strArt.getDescricao(), compra, strArt.getPreco()));

                                    System.out.println("Compra realizada com sucesso!");
                                }
                            } else {
                                System.out.println("\nNao existe quantidade que deseja\n");
                            }
                        }
                    } else {
                        System.out.println("Não existe esse cliente");
                    }
                }
                j++;
            }
        }
    }

    /**
     * Imprime todos os movimentos que cada cliente fez
     *
     * @param list lista Movimetos
     * @param listCli lista CartaoCliente
     */
    public static void imprimirMovimentos(LinkedList<Movimentos> list, LinkedList<CartaoCliente> listCli) {
        Scanner ler = new Scanner(System.in);
        System.out.println("----------Movimetos Cartao---------");
        System.out.println("");
        if (list.isEmpty()) {
            System.out.println(" ");
            System.out.println("A lista esta vazia´!!!");
            System.out.println(" ");
        } else {
            System.out.println("Introduza o seu Codigo de Cliente:");
            while (!ler.hasNextInt()) {
                ler.next();
                System.out.println(" ");
                System.err.print("Nao e um numero. Por favor tenta outra vez!!!");
                System.out.println(" ");
            }
            int id = ler.nextInt();

            for (CartaoCliente strClientes : listCli) {
                if (strClientes.getIdCliente() == id) {
                    for (Movimentos str : list) {
                        System.out.println("Nome do artigo: " + str.getNome() + " / " + "Quantidades: " + str.getQuantidade() + " / " + "Preço: " + str.getPreco() + "€;");
                    }
                }
            }

        }
        System.out.println();
    }

    /**
     * Consulata todos os pontos que o cliente ganha se fizer compras com mais
     * de 50€
     *
     * @param list lista CartaoCliente
     */
    public static void consultaPontos(LinkedList<CartaoCliente> list) {
        if (list.isEmpty()) {
            System.out.println("A lista esta vazia!!");
        } else {
            Scanner ler = new Scanner(System.in);
            System.out.println("Introdusa o seu ID:");
            while (!ler.hasNextInt()) {
                ler.next();
                System.out.println(" ");
                System.err.print("Nao e um numero. Por favor tenta outra vez!!!");
                System.out.println(" ");
            }
            int id = ler.nextInt();
            for (CartaoCliente str : list) {
                if (str.getIdCliente() == id) {
                    System.out.println("Os seus pontos são: " + str.getPontos());
                }
            }
        }
        System.out.println();
    }

    /**
     * Imprime todos os clientes com todos os campos introduzidos
     *
     * @param list lista CartaoCliente
     */
    public static void imprimirClientes(LinkedList<CartaoCliente> list) {
        System.out.println("----------Clientes---------");
        System.out.println("");
        if (list.isEmpty()) {
            System.out.println("A lista esta vazia!!");
        } else {
            for (Clientes str : list) {
                System.out.println("Codigo do Cliente: " + str.getIdCliente() + " / Nome: " + str.getNome() + " / Cartao Cidadao: " + str.getCartaoCidadao() + " / NIF: " + str.getNif() + " / Morada: " + str.getMorada() + " / Telefone: " + str.getTelefone() + " / Email: " + str.getEmail() + ";");
            }
        }
        System.out.println("");
    }

    /**
     * Remove um cliente completo da lista
     *
     * @param list lista CartaoCliente
     */
    public static void removerClientes(LinkedList<CartaoCliente> list) {
        Scanner ler = new Scanner(System.in);
        if (list.isEmpty()) {
            System.out.println(" ");
            System.out.println("A lista esta vazia!!!");
        } else {
            System.out.println("Insira o ID");
            while (!ler.hasNextInt()) {
                ler.next();
                System.err.print("\nNao e um numero. Por favor tenta outra vez!!!\n");
            }
            int id = ler.nextInt();
            for (CartaoCliente str : list) {
                if (str.getIdCliente() == id) {
                    list.remove(str);
                } else {
                    System.out.println("Esse id não existe");
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        LinkedList<CartaoCliente> listCartClientes = new LinkedList<>();
        LinkedList<Artigos> listArtigos = new LinkedList<>();
        LinkedList<Movimentos> movimentos = new LinkedList<>();
        int escolha;
        Scanner ler = new Scanner(System.in);

        do {

            System.out.println("\n---Menu Principal---\n");
            System.out.println("1 - Gestão de Artigos");
            System.out.println("2 - Gestão de Clientes");
            System.out.println("0 - Sair\n");
            System.out.println("Por favor escolha uma opção: ");
            while (!ler.hasNextInt()) {
                ler.next();
                System.err.print("\nNao e um numero. Por favor tenta outra vez!!!\n");
            }
            escolha = ler.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("\n---Gerir Artigos---\n");
                    System.out.println("1 - Adicionar Artigo");
                    System.out.println("2 - Actualizar Stock ");
                    System.out.println("3 - Eliminar Artigo");
                    System.out.println("4 - Consultar Atigos ");
                    System.out.println("9 - Voltar Menu anterior");
                    System.out.println("0 - Sair do \n");
                    System.out.println("Por favor escolha uma opção: ");
                    while (!ler.hasNextInt()) {
                        ler.next();
                        System.err.print("\nNao e um numero. Por favor tenta outra vez!!!\n");
                    }
                    escolha = ler.nextInt();

                    switch (escolha) {
                        case 1:
                            System.out.println("Quantos Artigos pertende adicionar?");
                            while (!ler.hasNextInt()) {
                                ler.next();
                                System.err.print("\nNao e um numero. Por favor tenta outra vez!!!\n");
                            }
                            int quantidade = ler.nextInt();
                            Artigos.criarArtigo(listArtigos, quantidade);
                            break;
                        case 2:
                            actualizarStock(listArtigos);
                            break;
                        case 3:
                            removerArtigos(listArtigos);
                            break;
                        case 4:
                            imprimirArtigos(listArtigos);
                            break;
                        case 9:
                            break;
                        default:
                            System.out.println("Escolha não encontrada");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("\n---Gerir Clientes---\n");
                    System.out.println("1 - Adicionar Cliente");
                    System.out.println("2 - Registar Compras");
                    System.out.println("3 - Consultar Compras");
                    System.out.println("4 - Consultar Pontos");
                    System.out.println("5 - Consultar Clientes");
                    System.out.println("6 - Remover Clientes");
                    System.out.println("9 - Voltar Menu anterior");
                    System.out.println("0 - Sair do programa\n");
                    System.out.println("Por favor escolha uma opção: ");
                    while (!ler.hasNextInt()) {
                        ler.next();
                        System.err.print("\nNao e um numero. Por favor tenta outra vez!!!\n");
                    }
                    escolha = ler.nextInt();
                    switch (escolha) {
                        case 1:
                            System.out.println("Quantos clientes pertende adicionar?");
                            while (!ler.hasNextInt()) {
                                ler.next();
                                System.err.print("\nNao e um numero. Por favor tenta outra vez!!!\n");
                            }
                            int quantidade = ler.nextInt();
                            criarCliente(listCartClientes, quantidade);
                            break;
                        case 2:
                            System.out.println("Artigos:");
                            imprimirArtigos(listArtigos);
                            registo(listCartClientes, listArtigos, movimentos);
                            System.out.println("-----Stock Actualizado-----");
                            imprimirArtigos(listArtigos);
                            break;
                        case 3:
                            imprimirMovimentos(movimentos, listCartClientes);
                            break;
                        case 4:
                            consultaPontos(listCartClientes);
                            break;
                        case 5:
                            imprimirClientes(listCartClientes);
                            break;
                        case 6:
                            removerClientes(listCartClientes);
                            break;
                        case 9:
                            break;
                        default:
                            System.out.println("Escolha não encontrada");
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Programa Terminado");
                    break;
                default:
                    System.out.println("Escolha não encontrada");
                    break;
            }
        } while (escolha != 0);
    }
    
    /**
     *  Validacao de todos os campos a introduzir num email
     */
    public static final Pattern VALID_EMAIL
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /**
     *  verifica se o email esta comforme a validacao 
     * @param email recebe o email que o utilizador introduzio
     * @return returna se corresponde a validacao
     */
    public static boolean validate(String email) {
        Matcher matcher = VALID_EMAIL.matcher(email);
        return matcher.find();
    }

    /**
     *  Verifica se o numero introduzido tem 9 digitos
     * @param s recebe o numero que o utilizador introduzio
     * @return returna se corresponde a validacao
     */
    public static boolean VerificarTele(String s) {
        Pattern pattern = Pattern.compile("\\d{9}");
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }
}