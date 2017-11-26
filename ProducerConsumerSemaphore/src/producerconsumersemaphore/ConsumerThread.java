/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumersemaphore;

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
public class ConsumerThread extends Thread{
    final int N;

    public ConsumerThread(int N) {
        this.N = N;
    }
   
    int remove(){
        return 0;
    }
    
    void consume(int n){
        list.remove(n);
    }
    
    @Override
    public void run() {
        while(true){
            if(count == 0){
                System.out.println("Consumer going to sleep");
                s.release();
            }
            item = remove();
            count--;
            System.out.println("Consumer removed item, count: " + count);
            if(count == N-1){
                System.out.println("Consumer waking up Producer...");
                try {
                    s.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ConsumerThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            consume(item);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ConsumerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
