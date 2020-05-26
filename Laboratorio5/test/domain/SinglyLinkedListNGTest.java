/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Profesor Lic. Gilberth Chaves Avila
 */
public class SinglyLinkedListNGTest {
    
    public SinglyLinkedListNGTest() {
    }

    @Test
    public void test1() {
        try {
            SinglyLinkedList list = new SinglyLinkedList();
            for (int i = 0; i < 1000; i++) {
                list.add(util.Utility.getFirstName());
            }
            System.out.println(list);
            list.sort();
            System.out.println("LISTA ORDENADA(STRING): "+list.show());
        } catch (ListException ex) {
            Logger.getLogger(SinglyLinkedListNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void test2() {
        try {
            SinglyLinkedList list = new SinglyLinkedList();
            for (int i = 0; i < 1000; i++) {
                list.add(util.Utility.random(500));
            }
            System.out.println(list);
            list.sort();
            System.out.println("LISTA ORDENADA(INTEGER): "+list.show());
        } catch (ListException ex) {
            Logger.getLogger(SinglyLinkedListNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
