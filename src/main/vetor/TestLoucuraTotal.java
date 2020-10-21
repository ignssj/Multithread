package main.vetor;

import java.util.*;

public class TestLoucuraTotal {
  public static void main(String[] args){
    ehOsGuriPai();
//    fidedigna();
  }


  public static void ehOsGuriPai(){
    int [][] matriz = new int[10][10];
    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz[i].length; j++) {
        matriz[i][j] = j + ( matriz[i].length * i);
      }
    }
    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz[i].length; j++) {
        System.out.println(matriz[i][j]);
      }
    }
  }


  public static void fidedigna(){
    int tam = 10000000;
    System.out.println("Inicio da execucao");
    long tempoInicial = System.currentTimeMillis();
    long tempoFinal;

    SortedSet<Integer> tree=new TreeSet<>();
    for (int i = 0 ; i < tam; i ++){
      tree.add(i);
    }
    int num[]=new int[tam];

    while(tree.size() != 0){
      int randomico = (int) (Math.random() * tam);
      if(tree.contains(randomico) == true){
        num[randomico] = randomico;
        tree.remove(randomico);
      }
    }

    tempoFinal = System.currentTimeMillis() - tempoInicial;
    System.out.printf("\n  %.3f ms%n", tempoFinal / 1000d);
    System.out.println("Fim da execucao");
  }
}
