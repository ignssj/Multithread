package main.matriz;

import java.util.Random;

public class MatrizThread extends  Thread{
  int colunaInicial;
  int colunaFinal;
  int tamanhoDeLinhas;
  int fator;

  MatrizThread(int colunaInicial, int colunaFinal, int tamanhoDeLinhas){
    this.colunaInicial = colunaInicial;
    this.colunaFinal = colunaFinal;
    this.tamanhoDeLinhas = tamanhoDeLinhas;
  }

  void preencherMatriz()   {
    Random random = new Random();
    System.out.println("preencher  : " + colunaInicial + " até " + colunaFinal);
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
