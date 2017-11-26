/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerproblem;

import java.util.logging.Level;
import java.util.logging.Logger;
import static producerconsumerproblem.ProducerConsumerProblem.count;
import static producerconsumerproblem.ProducerConsumerProblem.item;
import static producerconsumerproblem.ProducerConsumerProblem.list;

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
                try {
                    synchronized(this){this.wait();}
            } catch (InterruptedException ex) {
                Logger.getLogger(ConsumerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            item = remove();
            count--;
            System.out.println("Consumer removed item, count: " + count);
            if(count == N-1){
                System.out.println("Consumer waking up Producer...");
                  synchronized(this){this.notify();}
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
