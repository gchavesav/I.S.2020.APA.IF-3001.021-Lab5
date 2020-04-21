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
        //calendar.set(2000, 1, 30);
//        list.add(new Employee(111111111, "Quesada", "Maria", "informática", calendar.getTime()));
//        System.out.println(list.toString());
        int years[] = {1999, 1995, 1994, 1990, 1989, 1985, 1981, 1980, 1977, 1975,
                1971, 1969, 1964, 1962, 1959, 1955, 1953};
        for (int i = 0; i < 10; i++) {
            calendar.set(years[util.Utility.random(16)]
                , util.Utility.random(29)+1, 30);
            list.add(
                new Employee(util.Utility.random(999999999)
                        ,util.Utility.getLastName()
                        ,util.Utility.getFirstName()
                        ,util.Utility.getTitle()
                        ,calendar.getTime()));
            }
            System.out.println(list.toString());
            
        try{
            //mostrar personas de acuerdo a rangos de edades
//            CircularLinkedList aaa = getAgeList(list, 18, 25);
//            if(aaa!=null){
//                System.out.println(aaa.toString());
//            }
            System.out.println("\n\nPersonas con rango de edad entre 18 y 25");
            System.out.println(getAgeList(list, 18, 25)!=null
                    ?getAgeList(list, 18, 25).show():"ninguna");
            System.out.println("\nPersonas con rango de edad entre 26 y 40");
            System.out.println(getAgeList(list, 26, 40)!=null
                    ?getAgeList(list, 26, 40).show():"ninguna");
            System.out.println(getAgeList(list, 26, 40)!=null
                    ?getAgeList(list, 26, 40).show2():"ninguna");
            System.out.println("\nPersonas con rango de edad entre 41 y 55");
            System.out.println(getAgeList(list, 41, 55)!=null
                    ?getAgeList(list, 41, 55).show():"ninguna");
            System.out.println("\nPersonas con rango de edad mayor a 55");
            System.out.println(getAgeList(list, 56, 100)!=null
                    ?getAgeList(list, 56, 100).show():"ninguna");
            
            System.out.println();
            for (int i = 0; i < 5; i++) {
                String title = util.Utility.getTitle();
                System.out.println("\nPersonas que pertenecen a la profesion: "
                        +title);
                System.out.println(getTitleList(list, title)!=null
                            ?getTitleList(list, title).show():"ninguna");
                
            }
            
        }catch(ListException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
    //Este metodo retorna una lista circular con los rangos de edades
    //indicadas
    private CircularLinkedList getAgeList(CircularLinkedList list,
            int low, int high) throws ListException{
        CircularLinkedList tempList = new CircularLinkedList();
        for (int i = 1; i <= list.size(); i++) {
            Employee e = (Employee)list.getNode(i).data;
            if(util.Utility.isBetween(e.getAge(), low, high)){
                tempList.add(e);
            }
        }
        return !tempList.isEmpty()?tempList:null;
    }
    
    private CircularLinkedList getTitleList(CircularLinkedList list, String title) throws ListException {
        CircularLinkedList tempList = new CircularLinkedList();
        for (int i = 1; i <= list.size(); i++) {
            Employee e = (Employee)list.getNode(i).data;
            if(e.getTitle().equalsIgnoreCase(title)){
                tempList.add(e);
            }
        }
        return !tempList.isEmpty()?tempList:null;
    }
    
}
