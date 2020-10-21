package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {

  public void imprimirVetor(int tamanho, int[] vetor, int nrThreads, long tempoExecucao, String caminhoUsuario){
    System.out.println("Escrita no arquivo");
    String caminhoAbsoluto = caminhoUsuario + nrThreads+ "threads.txt";
    FileWriter arq = null;
    try {
      arq = new FileWriter(caminhoAbsoluto);
    } catch (IOException e) {
      e.printStackTrace();
    }
    PrintWriter gravarArq = new PrintWriter(arq);
    gravarArq.println("\nPreenchimento com  " + nrThreads  + " threads, tempo final de "  + tempoExecucao / 1000d+"ms" )  ;
    for (int i=0; i<tamanho; i++) {
      gravarArq.printf("%d|", vetor[i]);
    }
    gravarArq.println("\nPreenchimento com  " + nrThreads  + " threads, tempo final de "  + tempoExecucao / 1000d+"ms" )  ;

    try {
      arq.close();
      System.out.println("Final da Escrita");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public void imprimirMatriz(int tamanho, int[][] matriz, int nrThreads, long tempoExecucao, String caminhoUsuario){
    System.out.println("Escrita no arquivo");
    String caminhoAbsoluto = caminhoUsuario + nrThreads+ "threads.txt";
    FileWriter arq = null;
    try {
      arq = new FileWriter(caminhoAbsoluto);
    } catch (IOException e) {
      e.printStackTrace();
    }
    PrintWriter gravarArq = new PrintWriter(arq);
    gravarArq.println("\nPreenchimento com  " + nrThreads  + " threads, tempo final de "  + tempoExecucao / 1000d+"ms" )  ;
    for (int i=0; i<tamanho; i++) {
      for (int j = 0 ; j < matriz[i].length; j++){
        gravarArq.printf("%d|", matriz[i][j]);
      }
//      gravarArq.println( )  ;
    }
    gravarArq.println("\nPreenchimento com  " + nrThreads  + " threads, tempo final de "  + tempoExecucao / 1000d+"ms" )  ;

    try {
      arq.close();
      System.out.println("Final da Escrita");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
