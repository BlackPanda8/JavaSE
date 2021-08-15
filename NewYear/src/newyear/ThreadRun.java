
package newyear;


public class ThreadRun implements Runnable{

    @Override
    public void run() {
               for(int i = 0; i <= 30; i++){
            new WindowFrame();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
