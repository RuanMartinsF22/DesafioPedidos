package Modelo;

import java.util.HashMap;

public class List {
    static HashMap<Integer, Produto> produtos = new HashMap<>();

    public static void main(String[] args) {
        produtos();

    }
    public static void produtos(){
        Produto p1 = new Produto("Lagosta Executiva", 55.5);
        Produto p2 = new Produto("File Mignon", 35.5);
        Produto p3 = new Produto("File ao molho madeira", 35.0);
        Produto p4 = new Produto("Frango a passarinho", 35.5);
        Produto p5 = new Produto("Parmediana", 45.0);
        Produto p6 = new Produto("Sobremesa do chef", 35.5);
        produtos.put(01, p1);
        produtos.put(02, p2);
        produtos.put(03, p3);
        produtos.put(04, p4);
        produtos.put(05, p5);
        produtos.put(06, p6);
        System.out.println("---------------- LISTA DE PRODUTOS ----------------");
        System.out.println(produtos.get(1));
        System.out.println("\n");
        System.out.println(produtos.get(2));
        System.out.println("\n");
        System.out.println(produtos.get(3));
        System.out.println("\n");
        System.out.println(produtos.get(4));
        System.out.println("\n");
        System.out.println(produtos.get(5));
        System.out.println("\n");
        System.out.println(produtos.get(6));
    }



}
