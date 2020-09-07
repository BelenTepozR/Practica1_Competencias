package practica1_20084_competencia;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
public class Hilo2 extends Thread{
        private JTextArea area;
        boolean pausar; 
       boolean detener;   
        public Hilo2(JTextArea area){
                this.area = area;
                pausar=false;
                detener=false;
        }
        public void run(){
                int i = 0;
                while(true){
                        area.append(i+"\n");
                        i++;
                           try {
                                 synchronized (this) {
                                while (pausar) {
                                       wait();
                                }
                                if (detener) join();
                              }
                        } catch (InterruptedException ex) {
                                Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
        }
          synchronized void detenerhilo(){
        detener=true;
        pausar=false;
        notify();
    }

    synchronized void pausarrhilo(){
        pausar=true;
    }

    synchronized void reanudarhilo(){
        pausar=false;
        notify();
    }
}
