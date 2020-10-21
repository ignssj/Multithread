package main.matriz;

import java.util.Random;
import java.util.TreeMap;

public class MatrizThread extends  Thread{
  int colunaInicial;
  int colunaFinal;
  int tamanhoTotalLinhas;
  int tamanhoTotalColunas;
  int qtdRandomInt = 100;
  TreeMap<Integer, int[]> treemap = new TreeMap<Integer, int[]>();

  MatrizThread(int colunaInicial, int colunaFinal, int tamanhoTotalLinhas, int tamanhoTotalColunas){
    this.colunaInicial = colunaInicial;
    this.colunaFinal = colunaFinal;
    this.tamanhoTotalLinhas = tamanhoTotalLinhas;
    this.tamanhoTotalColunas= tamanhoTotalColunas;
  }

  void processamentoAuxiliar(){
    /**
     * Carrega para uma arvore todas posições possiveis na matriz
     */
    Random random = new Random();
    for (int i = 0 ; i < tamanhoTotalLinhas; i ++){
      for (int j = colunaInicial; j < colunaFinal; j ++){
        int posicao = tamanhoTotalLinhas * i + j;
        treemap.put(posicao, new int[]{i, j, random.nextInt(qtdRandomInt)});
      }
    }
  }

  void preencherMatriz()   {
    System.out.println("preencher  da coluna: " + colunaInicial + " até " + colunaFinal + " todas as " + tamanhoTotalLinhas + " linhas");
    for (int i = 0; i < tamanhoTotalLinhas; i++) {
      for (int j = colunaInicial; j < colunaFinal; j ++){
        Matriz.value[i][j] = (tamanhoTotalLinhas * i) + j;
      }
    }
  }

  /**
   * Operação que verifica em uma arvore todas as posições possiveis
   * a cada inserção remove essa opção randomica  na arvore
   */

  void preencherMatrizRandomicamente(){
    /**
     * Aqui ele tem todas as posições possiveis da matriz mapeados em uma arvore
     * entao em cada interação até a arvore for 0 ele verifica se existe a posição
     * e insere na matriz
     */
    int tam = tamanhoTotalColunas * tamanhoTotalLinhas;
    while(treemap.size() != 0){
      int randomico = (int) (Math.random() * tam);
      if(treemap.containsKey(randomico) == true){
        int linha = treemap.get(randomico)[0];
        int coluna = treemap.get(randomico)[1];
        Matriz.value[linha][coluna] = treemap.get(randomico)[2];
        treemap.remove(randomico);
      }
    }
    System.out.println("Final do preenchimento");
  }

  public void run (){
    processamentoAuxiliar();
    preencherMatrizRandomicamente();
//    preencherMatriz();
  }
}
