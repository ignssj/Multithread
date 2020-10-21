package main.vetor;

import java.util.*;

public class TestLoucuraTotal {
  public static void main(String[] args){
    SortedSet<Integer> tree=new TreeSet<>();
    for (int i = 0 ; i < 1000000; i ++){
      tree.add(i);
    }
    int num[]=new int[1000000];//Criando vetor

    while(tree.size() != 0){
      int randomico = (int) (Math.random() * 1000000); //gerando número aleatório
//      System.out.print("Contem o valor randomico " + randomico + " ? ");
//      System.out.println(tree.contains(randomico));
      if(tree.contains(randomico) == true){
        num[randomico] = randomico;
//        tree.forEach((value) ->{
//        System.out.print(value + "|");
//      });
//        System.out.println("\nRemovendo:" + randomico);
        tree.remove(randomico);
      }
    }

    System.out.println("imprimindo Vetor");
    for (int i = 0; i < num.length; i++) {
      System.out.print(num[i] + "|");
    }

  }
}
