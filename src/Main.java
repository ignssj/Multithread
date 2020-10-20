import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  static void with8Threads(){
    int umOitavo = Matriz.vetor.length / 8;

    int parte1 = umOitavo;
    int parte2 = umOitavo * 2;
    int parte3 = umOitavo * 3;
    int parte4 = umOitavo * 4;
    int parte5 = umOitavo * 5;
    int parte6 = umOitavo * 6;
    int parte7 = umOitavo * 7;
    int parte8 = umOitavo * 8;

    ProcessadorThread[] threads = new ProcessadorThread[] {
      new ProcessadorThread(0 ,parte1 ),
      new ProcessadorThread(parte1 ,parte2 ),
      new ProcessadorThread(parte2 ,parte3 ),
      new ProcessadorThread(parte3 ,parte4 ),
      new ProcessadorThread(parte4 ,parte5 ),
      new ProcessadorThread(parte5 ,parte6 ),
      new ProcessadorThread(parte6 ,parte7 ),
      new ProcessadorThread(parte7 ,parte8 ),
    };

    ExecutorService pool = Executors.newFixedThreadPool(threads.length);
    for(int i = 0 ; i < threads.length; i ++){
      pool.execute(threads[i]);
    }

    pool.shutdown();
  }

  public static void main(String[] args) {
    with8Threads();    //2.5
//    with4Thread();     // 3.916
//    with1Thread();    // 14.0
  }


}
