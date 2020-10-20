package main;

public class ProcessadorThread extends Thread{
  int posicaoInicial;
  int posicaoFinal;

  ProcessadorThread(int posicaoInicial, int posicaoFinal){
    this.posicaoFinal = posicaoFinal;
    this.posicaoInicial = posicaoInicial;
  }

  void preencherVetor()   {
    int var = 0;
    for (int i = posicaoInicial; i < posicaoFinal; i++) {
      for (int j = posicaoInicial; j < 300; j ++){
        Structure.vetor[i] = j;
      }
      Structure.vetor[i] = i;
    }
  }

  public void run (){
    preencherVetor();
  }
}
