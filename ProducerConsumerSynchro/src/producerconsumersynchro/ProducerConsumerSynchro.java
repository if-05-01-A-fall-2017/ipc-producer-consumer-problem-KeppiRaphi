/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumersynchro;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rapha
 */
public class ProducerConsumerSynchro {
public static int item;
    public static int count;
    public static List<Integer> list = new ArrayList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProducerConsumer produ = new ProducerConsumer(10);
        Thread producer = new Thread(new Runnable(){
            @Override
            public void run() {
                produ.produce();
            }
            
        });
        Thread consumer = new Thread(new Runnable(){
            @Override
            public void run() {
                produ.consume();
            }
            
        });
           
        System.out.println("Consumer starting...");
        consumer.start();
        
        System.out.println("Producer starting...");
        producer.start();
    }
    
}
