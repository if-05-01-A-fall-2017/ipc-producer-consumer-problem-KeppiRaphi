/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerproblem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rapha
 */
public class ProducerConsumerProblem {
    public static int item;
    public static int count;
    public static List<Integer> list = new ArrayList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProducerThread p = new ProducerThread(10);
        ConsumerThread c = new ConsumerThread(10);
           
        System.out.println("Consumer starting...");
        c.start();
        
        System.out.println("Producer starting...");
        p.start();
        
        
 
        
    }
    
}
