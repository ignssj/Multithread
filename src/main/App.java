package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

  public static void main(String[] args) {
    withNrX(8, "/home/michel/Documents/");
//    withNrX(32, "/home/michel/Documents/");
  }

  private static void withNrX(int nrThreads, String caminhoDeEscrita) {
    ProcessadorThread[] threads = new ProcessadorThread[nrThreads];
    int pedaco = Structure.vetor.length / nrThreads;        //um só pedaço do vetor exemplo 1000/4, logo cada parte ter 250 posições 
    int partes [] = new int[nrThreads + 1 ];

    /**
     * Definição das partes baseadas no numero de thread,
     * exemplo se tiver 4 threads e 250 posições essa parte do codigo é responsavel por definir as partes 
     * parte 1 = 250
     * parte 2 = 500
     * ṕarte 3 = 750
     * parte 4 = 1000
     */
    for (int i = 0; i < partes.length; i++)
      partes[i] = pedaco * (i);

    /**
     * Colocação de cada nova thread criada em um pool, as threads estão recebendo um vetor com a posição inicial e final
     * ( dando a ideia de cada uma thread executar uma parte do vetor
     * exemplo
     * a thread 1 inicia pela por 0 e vai até a parte 1 que é 250
     * a thread 2 inicia em 250 e vai até 500
     * a thread 3 inicia em 500 e vai até 750 e assim sucessivamente
     */
    for (int k = 0 ; k < threads.length; k ++){
      threads[k] = new ProcessadorThread(partes[k], partes[k + 1]);
      System.out.println(threads[k].posicaoInicial + "--"+ threads[k].posicaoFinal);
    }


    long tempoInicial = System.currentTimeMillis();
    long tempoFinal;

    /**
     * Execução do pool de todas as threads que foram previamente colocadas nele
     */

    ExecutorService pool = Executors.newFixedThreadPool(threads.length);
    for(int i = 0 ; i < threads.length; i ++)
      pool.execute(threads[i]);
    pool.shutdown();

    try {
      /**
       * Esperar o termino das execução do pool
       */
      pool.awaitTermination(1, TimeUnit.DAYS);

    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      tempoFinal =  System.currentTimeMillis() - tempoInicial;
      System.out.printf("\n  %.3f ms%n", tempoFinal / 1000d);

      Arquivo arquivo = new Arquivo();
      arquivo.imprimir(Structure.vetor.length, Structure.vetor, nrThreads, tempoFinal, caminhoDeEscrita);
    }

  }

}
