package main.matriz;

import java.util.Random;

public class MatrizThread extends  Thread{
  int colunaInicial;
  int colunaFinal;
  int tamanhoDeLinhas;

  MatrizThread(int colunaInicial, int colunaFinal, int tamanhoDeLinhas){
    this.colunaInicial = colunaInicial;
    this.colunaFinal = colunaFinal;
    this.tamanhoDeLinhas = tamanhoDeLinhas;
  }

  void preencherMatriz()   {
    Random random = new Random();
    System.out.println("preencher  da coluna: " + colunaInicial + " até " + colunaFinal + " todas as " + tamanhoDeLinhas + " linhas");
    for (int i = 0; i < tamanhoDeLinhas; i++) {
      for (int j = colunaInicial; j < colunaFinal; j ++){
        Matriz.value[i][j] = random.nextInt(100);
      }
    }
  }

  public void run (){
    preencherMatriz();
  }
}
