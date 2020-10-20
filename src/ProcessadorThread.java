public class ProcessadorThread extends Thread{
  int posicaoInicial;
  int posicaoFinal;

  ProcessadorThread(int posicaoInicial, int posicaoFinal){
    this.posicaoFinal = posicaoFinal;
    this.posicaoInicial = posicaoInicial;
  }

  void preencherVetor(){
    long tempoInicial = System.currentTimeMillis();
    for (int i = posicaoInicial; i < posicaoFinal; i++) {
      for (int j = 0 ; j < 300; j ++){
        Structure.vetor[i] = j + 300 % 2;
      }
    }
    long tempoFinal =  System.currentTimeMillis() - tempoInicial;
    Structure.variavel++;

    System.out.printf("\n  %.3f ms%n", tempoFinal / 1000d);
    System.out.println(Structure.variavel);
  }

  void preencherMatriz(){
    /**
     * Implementação
     */
  }
  public void run (){
    preencherVetor();
//    preencherMatriz();
  }
}
