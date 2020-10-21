package main.matriz;

import main.Arquivo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AppMatriz {


  public static void main(String[] args) {
    int cores = Runtime.getRuntime().availableProcessors();
//    withNrX(cores, "/home/michel/Documents/");
    withNrX(5, "/home/michel/Documents/");

//    withNrX(32, "/home/michel/Documents/");
  }

  private static void withNrX(int nrThreads, String caminhoDeEscrita) {
    MatrizThread[] threads = new MatrizThread[nrThreads];
    int nrDeColunas = Matriz.value[0].length;
    int nrDeLinhas = Matriz.value.length;
    int pedacoDeColuna = nrDeColunas / nrThreads;        //um pedaço das colunas exemplo uma matriz 1000X1000 e 4 threads entao tem 1000 colunas /4, logo serão 250 posições pra cada thread
    int partes[] = new int[nrThreads +1];

    /**
     * Definição das partes baseadas no numero de thread
     */
    for (int i = 0; i < partes.length; i++)
      partes[i] = pedacoDeColuna * (i);

    /**
     * Colocação de cada nova thread criada em um pool, as threads estão recebendo um vetor com a posição inicial e final
     * ( dando a ideia de cada uma thread executar uma parte do vetor
     */
    System.out.println("Colunas : de x a y");

    for (int k = 0; k < threads.length; k++) {
      threads[k] = new MatrizThread(partes[k], partes[k + 1], nrDeLinhas, Matriz.value[0].length);
      System.out.print(threads[k].colunaInicial + "-" + threads[k].colunaFinal + "|");
    }

    long tempoInicial = System.currentTimeMillis();
    long tempoFinal;

    /**
     * Execução dom pool de todas as threads que foram previamente colocadas nele
     */

    ExecutorService pool = Executors.newFixedThreadPool(threads.length);
    for (int i = 0; i < threads.length; i++)
      pool.execute(threads[i]);
    pool.shutdown();

    /**
     *  Final da execução a partir daqui é só para salvar no arquivo a matriz e e imprimir o tempo
     */

    try {
      /**
       * Esperar o termino das execução do pool
       */
      pool.awaitTermination(1, TimeUnit.DAYS);

    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      tempoFinal = System.currentTimeMillis() - tempoInicial;
      System.out.printf("\n  %.3f ms%n", tempoFinal / 1000d);

      Arquivo arquivo = new Arquivo();
      arquivo.imprimirMatriz(Matriz.value.length, Matriz.value, nrThreads, tempoFinal, caminhoDeEscrita);
    }
  }
}
