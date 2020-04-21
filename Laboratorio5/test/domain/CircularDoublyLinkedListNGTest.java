/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Calendar;
import org.testng.annotations.Test;
import util.Utility;

/**
 *
 * @author Profesor Lic. Gilberth Chaves A.
 */
public class CircularDoublyLinkedListNGTest {
    
    public CircularDoublyLinkedListNGTest() {
    }

    @Test
    public void testSomeMethod() {
        try {
            CircularDoublyLinkedList a = new CircularDoublyLinkedList();
            CircularDoublyLinkedList b = new CircularDoublyLinkedList();
            CircularDoublyLinkedList c = new CircularDoublyLinkedList();
            CircularDoublyLinkedList d = new CircularDoublyLinkedList();

            CircularLinkedList list = new CircularLinkedList();
            Calendar calendar = Calendar.getInstance();
            int years[] = {1999, 1995, 1994, 1990, 1989, 1985, 1981, 1980, 1977, 1975,
                1971, 1969, 1964, 1962, 1959, 1955, 1953};
            //configuro calendar para que tome los años que requiero
            //calendar.set(year, month, date)
            //agrego 10 empleados
            for (int i = 0; i < 10; i++) {
                //calendar.set(years[random.nextInt(16)], random.nextInt(29)+1, 30);
                calendar.set(years[Utility.random(16)], Utility.random(29)+1, 30);
                list.add(
                        new Employee(Utility.random(999999999), Utility.getLastName(),
                                Utility.getFirstName(), Utility.getTitle(),
                                calendar.getTime()));
            }
            //agrego el contenido en a 
            CircularLinkedList auxList = getAgeList(list, 18, 25);
            if(auxList!=null){
                for (int i = 1; i <= auxList.size(); i++) {
                    a.add(auxList.getNode(i).data);
                }
                auxList.clear(); //anulo la lista auxiliar
            }

            //agrego el contenido en b            
            auxList = getAgeList(list, 26, 40);
            if(auxList!=null){
                for (int i = 1; i <= auxList.size(); i++) {
                    b.add(auxList.getNode(i).data);
                }
                auxList.clear(); //anulo la lista auxiliar
            }
            
            //agrego el contenido en c
            auxList = getAgeList(list, 41, 55);
            if(auxList!=null){
                for (int i = 1; i <= auxList.size(); i++) {
                    c.add(auxList.getNode(i).data);
                }
                auxList.clear(); //anulo la lista auxiliar
            }
            
            //agrego el contenido en d
            auxList = getAgeList(list, 56, 100);
            if(auxList!=null){
                for (int i = 1; i <= auxList.size(); i++) {
                    d.add(auxList.getNode(i).data);
                }
                auxList.clear(); //anulo la lista
            }
            
            //Muestro por consola el contenido de cada lista
            System.out.println("CONTENIDO DE LA LISTA A");
            System.out.println("RANGO DE EDAD ENTRE 18 Y 25 AÑOS");
            System.out.println(a.toString());
            System.out.println("CONTENIDO DE LA LISTA B");
            System.out.println("RANGO DE EDAD ENTRE 26 Y 40 AÑOS");
            System.out.println(b.toString());
            System.out.println("CONTENIDO DE LA LISTA C");
            System.out.println("RANGO DE EDAD ENTRE 41 Y 55 AÑOS");
            System.out.println(c.toString());
            System.out.println("CONTENIDO DE LA LISTA D");
            System.out.println("RANGO DE EDAD MAYOR A 55 AÑOS");
            System.out.println(d.toString());
            
            //Objeto tipo nodo
            Node referencia = new Node();
            //conecto referencia con el nodo 1 de la lista a
            if(a.isEmpty()) System.exit(0);
            
            referencia.next = a.getNode(1);
            //conecto el ultimo nodo de la lista a con el primero de b
            a.getNode(a.size()).next = b.getNode(1);
            //conecto el ultimo nodo de la lista b con el primero de c
            b.getNode(b.size()).next = c.getNode(1);
            //conecto el ultimo nodo de la lista c con el primero de d
            c.getNode(c.size()).next = d.getNode(1);
            
            //ponemos una marca para el final
            d.getNode(d.size()).next = null;
            
//            System.out.println("\n\nLISTA CIRCULAR ENLAZADA DOBLE - TEST2");
//            System.out.println("LISTA a: "+a.toString());
//            System.out.println("LISTA b: "+b.toString());
//            System.out.println("LISTA c: "+c.toString());
//            System.out.println("LISTA d: "+d.toString());
//            System.out.println("\n\nMUESTRO LA INFORMACIÓN DESDE EL NODO REFERENCIA");
            Node aux = referencia.next;
            System.out.println("SE MUESTRA LA INFO A TRAVES DEL NODO -REFERENCIA- ENLAZADO");
            while (aux!=null){
                System.out.println(aux.data);
                aux = aux.next;
            }
            
//            System.out.println("\n---INICIO EN A.GETNODE(1)");
//            aux = a.getNode(1);
//            while (aux!=null){
//                System.out.println(aux.data);
//                aux = aux.next;
//            }
//            
//            System.out.println("\nEL DATA DEL NEXT DEL ULT NODO LISTA A"
//                    +"\n"+a.getNode(a.size()).next.data);
////                    +"\nEL DATA DEL NEXT DEL APUNTADOR LAST"
////                    +a.last.next.data);

        } catch (ListException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private CircularLinkedList getAgeList(CircularLinkedList list, int low, int high) throws ListException {
        CircularLinkedList myList = new CircularLinkedList();
        for (int i = 1; i <= list.size(); i++) {
            Employee e = (Employee)list.getNode(i).data;
            if(Utility.isBetween(e.getAge(), low, high)){
                myList.add(e);
            }
        }
        return !myList.isEmpty()?myList:null;
    }
}
