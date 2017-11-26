/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumersemaphore;

import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import static producerconsumersemaphore.ProducerConsumerSemaphore.count;
import static producerconsumersemaphore.ProducerConsumerSemaphore.item;
import static producerconsumersemaphore.ProducerConsumerSemaphore.list;
import static producerconsumersemaphore.ProducerConsumerSemaphore.s;


/**
 *
 * @author rapha
 */
public class ProducerThread extends Thread{
    final int N;

    public ProducerThread(int N) {
        this.N = N;
    }
        
    int produce(){
        return 0;
    }

    void insertItem(int n){
        list.add(n);
    }
    
    @Override
    public void run() {
        while(true){
            item = produce();
            if(count == N){
                System.out.println("Producer going to sleep...");
                s.release();
        }
            insertItem(item);
            count++;
            System.out.println("Producer inserted. count: " + count);
            if(count == 1){
                System.out.println("Producer waking up consumer...");
                try {
                    s.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProducerThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
