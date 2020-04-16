/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domain.CircularLinkedList;
import domain.ListException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Profesor Lic. Gilberth Chaves Avila
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            CircularLinkedList list = new CircularLinkedList();
            list.add(10);
            list.add(20);
            System.out.println(list.toString());
            for (int i = 1; i <= 30; i++) {  
                int value = util.Utility.random(99);
                list.add(value);
                System.out.println("Se ha agregado el valor: "+value);
            }
            System.out.println("Agregamos nuevos elementos al inicio de la lista");
            for (int i = 1; i <= 10; i++) {
                int value = util.Utility.random(99);
                list.addFirst(value);
                System.out.println("Se ha agregado al inicio el valor: "+value);
            }
            
            System.out.println(list.toString());
            System.out.println("Total de elementos: "+list.size());
        } catch (ListException ex) {
            System.out.println(ex.getMessage());
        }
            
    }
    
}
