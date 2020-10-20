package main.vetor;

import java.util.Random;

public class VetorThread extends Thread{
  int posicaoInicial;
  int posicaoFinal;

  VetorThread(int posicaoInicial, int posicaoFinal){
    this.posicaoFinal = posicaoFinal;
    this.posicaoInicial = posicaoInicial;
  }

  void preencherVetor()   {
    Random random = new Random();
    for (int i = posicaoInicial; i < posicaoFinal; i++) {
      Vetor.value[i] = random.nextInt(100);
    }
  }

  public void run (){
    preencherVetor();
  }
}
