/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Calendar;
import org.testng.annotations.Test;

/**
 *
 * @author Profesor Lic. Gilberth Chaves A.
 */
public class CircularLinkedListNGTest {
    
    public CircularLinkedListNGTest() {
    }

    @Test
    public void testSomeMethod() {
        CircularLinkedList list = new CircularLinkedList();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, 1, 30);
        list.add(new Employee(111111111, "Quesada", "Maria", "informática", calendar.getTime()));
        System.out.println(list.toString());
    }
    
    
    //Este metodo retorna una lista circular con los rangos de edades
    //indicadas
    private CircularLinkedList getAgeList(CircularLinkedList list,
            int low, int high) throws ListException{
        CircularLinkedList tempList = new CircularLinkedList();
        for (int i = 1; i <= list.size(); i++) {
            /*agregar el codigo de validacion*/
            
        }
        return !tempList.isEmpty()?tempList:null;
    }
    
}
