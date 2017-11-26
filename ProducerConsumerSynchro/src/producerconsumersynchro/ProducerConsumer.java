/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumersynchro;

import java.util.logging.Level;
import java.util.logging.Logger;
import static producerconsumersynchro.ProducerConsumerSynchro.count;
import static producerconsumersynchro.ProducerConsumerSynchro.item;
import static producerconsumersynchro.ProducerConsumerSynchro.list;

/**
 *
 * @author rapha
 */
public class ProducerConsumer {
    final int N;

    public ProducerConsumer(int N) {
        this.N = N;
    }
    
    int wtf(){
        return 0;
    }
    
    void insertItem(int n){
        list.add(n);
    }
    
    void remove(int n){
        list.remove(n);
    }
    
    public synchronized void produce(){
        while(true){
            item = wtf();
            if(count == N){
                System.out.println("Producer going to sleep...");
                try {
                    this.wait();
                        
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            insertItem(item);
            count++;
            System.out.println("Producer inserted. count: " + count);
            if(count == 1){
                System.out.println("Producer waking up consumer...");
                this.notify();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public synchronized void consume(){
        while(true){
            if(count == 0){
                System.out.println("Consumer going to sleep");
                try {
                    this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            item = wtf();
            count--;
            System.out.println("Consumer removed item, count: " + count);
            if(count == N-1){
                System.out.println("Consumer waking up Producer...");
                  this.notify();
            }
            remove(item);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
