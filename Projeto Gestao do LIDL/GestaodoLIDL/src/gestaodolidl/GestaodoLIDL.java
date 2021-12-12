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
 * @author Tiago Carvalho
 */
public class GestaodoLIDL {

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
                System.out.println(" ");
                System.err.print("Nao e um numero. Por favor tenta outra vez!!!");
                System.out.println(" ");
            }
            int stock = ler.nextInt();
            System.out.println("Indique o preço unitario " + i + ":");
            while (!ler.hasNextFloat()) {
                ler.next();
                System.err.print("Nao e um numero. Por favor tenta outra vez!!!");
            }
            float preco = ler.nextFloat();
            list.add(new Artigos(stock, preco, nome));
        }
    }

    /**
     * imprimir lista
     *
     * @param list lista de artigos
     */
    public static void imprimirArtigos(LinkedList<Artigos> list) {
        System.out.println("----------Artigos---------");
        System.out.println("");
        if (list.isEmpty()) {
            System.out.println(" ");
            System.out.println("A lista esta vazia!!!");
        } else {
            for (Artigos str : list) {
                System.out.println("Codigo do Artigo: " + str.codigoArtigo + " / " + "Nome: " + str.descricao + " / " + "Stock: " + str.stock + " / " + "Preço Unitario: " + str.preco + "€;");
            }
        }
        System.out.println("");
    }

    /**
     * actualiza a quantidade de stock de um certo produto
     *
     * @param list lista de artigos
     */
    public static void actualizarStock(LinkedList<Artigos> list) {
        Scanner ler = new Scanner(System.in);
        if (list.isEmpty()) {
            System.out.println(" ");
            System.out.println("A lista esta vazia!!!");
        } else {
            System.out.println("Insira o codigo do Artigo:");
            while (!ler.hasNextInt()) {
                ler.next();
                System.out.println(" ");
                System.err.print("Nao e um numero. Por favor tenta outra vez!!!");
                System.out.println(" ");
            }
            int id = ler.nextInt();

            for (Artigos str : list) {
                if (str.codigoArtigo == id) {
                    System.out.println("Indique a quantidade de stock: ");
                    while (!ler.hasNextInt()) {
                        ler.next();
                        System.out.println(" ");
                        System.err.print("Nao e um numero. Por favor tenta outra vez!!!");
                        System.out.println(" ");
                    }
                    int stock = ler.nextInt();
                    str.stock = stock;
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
            System.out.println(" ");
            System.out.println("A lista esta vazia!!!");
        } else {
            System.out.println("Insira o ID");
            while (!ler.hasNextInt()) {
                ler.next();
                System.out.println(" ");
                System.err.print("Nao e um numero. Por favor tenta outra vez!!!");
                System.out.println(" ");
            }
            int id = ler.nextInt();
            for (Artigos str : list) {
                if (str.codigoArtigo == id) {
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
    public static void registo(LinkedList<CartaoCliente> list, LinkedList<Artigos> artigoList, LinkedList<Movimetos> movimentos) {
        if (list.isEmpty()) {
            System.out.println("A lista esta vazia!!!");
        } else {
            Scanner ler = new Scanner(System.in);
            float totalCompra = 0;
            int somaPontos = 3, j = 0;

            System.out.println("Introduza o seu ID:");
            while (!ler.hasNextInt()) {
                ler.next();
                System.out.println(" ");
                System.err.print("Nao e um numero. Por favor tenta outra vez!!!");
                System.out.println(" ");
            }
            int id = ler.nextInt();

            System.out.println("Quantos artigos deseja comprar? ");
            while (!ler.hasNextInt()) {
                ler.next();
                System.out.println(" ");
                System.err.print("Nao e um numero. Por favor tenta outra vez!!!");
                System.out.println(" ");
            }
            int num = ler.nextInt();
            while (j < num) {
                for (CartaoCliente str : list) {
                    if (str.idCliente == id) {
                        System.out.println("Escolha o artigo pelo numero do id que deseja comprar: ");
                        while (!ler.hasNextInt()) {
                            ler.next();
                            System.out.println(" ");
                            System.err.print("Nao e um numero. Por favor tenta outra vez!!!");
                            System.out.println(" ");
                        }
                        int escolha = ler.nextInt();
                        for (Artigos strArt : artigoList) {
                            if (strArt.codigoArtigo == escolha) {
                                System.out.println("Quantidade que deseja deste artigo: " + strArt.descricao);
                                while (!ler.hasNextInt()) {
                                    ler.next();
                                    System.out.println(" ");
                                    System.err.print("Nao e um numero. Por favor tenta outra vez!!!");
                                    System.out.println(" ");
                                }
                                int compra = ler.nextInt();
                                if (strArt.stock >= compra) {
                                    totalCompra = compra * strArt.preco;
                                    strArt.stock -= compra;

                                    str.pontos += (somaPontos * (totalCompra / 50));

                                    movimentos.add(new Movimetos(strArt.descricao, compra, strArt.preco));

                                    str.saldoCompras = totalCompra;
                                    str.movimentos = movimentos;
                                }
                            } else {
                                System.out.println(" ");
                                System.out.println("Nao existe quantidade que deseja");
                                System.out.println(" ");
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
    public static void imprimirMovimentos(LinkedList<Movimetos> list, LinkedList<CartaoCliente> listCli) {
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
                if (strClientes.idCliente == id) {
                    for (Movimetos str : list) {
                        System.out.println("Nome do artigo: " + str.nome + " / " + "Quantidades: " + str.quantidade + " / " + "Preço: " + str.preco + "€;");
                    }
                }
            }

        }
        System.out.println("");
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
                if (str.idCliente == id) {
                    System.out.println("Os seus pontos são: " + str.pontos);
                }
            }
        }
        System.out.println("");
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
                System.out.println("Codigo do Cliente: " + str.idCliente + " / Nome: " + str.nome + " / Cartao Cidadao: " + str.cartaoCidadao + " / NIF: " + str.nif + " / Morada: " + str.morada + " / Telefone: " + str.telefone + " / Email: " + str.email + ";");
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
                System.err.print("Nao e um numero. Por favor tenta outra vez!!!");
                System.out.println("");
            }
            int id = ler.nextInt();
            for (CartaoCliente str : list) {
                if (str.idCliente == id) {
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
        LinkedList<Movimetos> movimentos = new LinkedList<>();
        int escolha;
        Scanner ler = new Scanner(System.in);

        do {
            System.out.println("");
            System.out.println("---Menu Principal---");
            System.out.println("");
            System.out.println("1 - Gestão de Artigos");
            System.out.println("2 - Gestão de Clientes");
            System.out.println("0 - Sair");
            System.out.println(" ");
            System.out.println("Por favor escolha uma opção: ");
            while (!ler.hasNextInt()) {
                ler.next();
                System.out.println(" ");
                System.err.print("Nao e um numero. Por favor tenta outra vez!!!");
                System.out.println(" ");
            }
            escolha = ler.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("");
                    System.out.println("---Gerir Artigos---");
                    System.out.println("");
                    System.out.println("1 - Adicionar Artigo");
                    System.out.println("2 - Actualizar Stock ");
                    System.out.println("3 - Eliminar Artigo");
                    System.out.println("4 - Consultar Atigos ");
                    System.out.println("9 - Voltar Menu anterior");
                    System.out.println("0 - Sair do programa");
                    System.out.println(" ");
                    System.out.println("Por favor escolha uma opção: ");
                    while (!ler.hasNextInt()) {
                        ler.next();
                        System.out.println(" ");
                        System.err.print("Nao e um numero. Por favor tenta outra vez!!!");
                        System.out.println(" ");
                    }
                    escolha = ler.nextInt();

                    switch (escolha) {
                        case 1:
                            System.out.println("Quantos Artigos pertende adicionar?");
                            while (!ler.hasNextInt()) {
                                ler.next();
                                System.out.println(" ");
                                System.err.print("Nao e um numero. Por favor tenta outra vez!!!");
                                System.out.println(" ");
                            }
                            int quantidade = ler.nextInt();
                            criarArtigo(listArtigos, quantidade);
                            break;
                        case 2:
                            actualizarStock(listArtigos);
                            clrscr();
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
                    System.out.println("");
                    System.out.println("---Gerir Clientes---");
                    System.out.println("");
                    System.out.println("1 - Adicionar Cliente");
                    System.out.println("2 - Registar Compras");
                    System.out.println("3 - Consultar Compras");
                    System.out.println("4 - Consultar Pontos");
                    System.out.println("5 - Consultar Clientes");
                    System.out.println("6 - Remover Clientes");
                    System.out.println("9 - Voltar Menu anterior");
                    System.out.println("0 - Sair do programa");
                    System.out.println("");
                    System.out.println("Por favor escolha uma opção: ");
                    while (!ler.hasNextInt()) {
                        ler.next();
                        System.out.println(" ");
                        System.err.print("Nao e um numero. Por favor tenta outra vez!!!");
                        System.out.println(" ");
                    }
                    escolha = ler.nextInt();
                    switch (escolha) {
                        case 1:
                            System.out.println("Quantos clientes pertende adicionar?");
                            while (!ler.hasNextInt()) {
                                ler.next();
                                System.out.println(" ");
                                System.err.print("Nao e um numero. Por favor tenta outra vez!!!");
                                System.out.println(" ");
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
    
    /**
     * Tentativa de limpar consola
     */
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final IOException e) {
            //  Handle any exceptions.
        }
    }
    
    /**
     * Tentativa de limpar consola
     */
    public static void clrscr() {
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {
        }
    }
    
    /**
     * Tentativa de limpar consola
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
