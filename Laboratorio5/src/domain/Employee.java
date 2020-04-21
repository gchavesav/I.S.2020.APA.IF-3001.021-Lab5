/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import util.Utility;
/**
 *
 * @author Profesor Lic. Gilberth Chaves A.
 */
public class Employee {
    private int id;
    private String lastname;
    private String firstname;
    private String title; //profesion
    private Date birthday;

    //Constructor
    public Employee(int id, String lastname, String firstname, String title, Date birthday) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.title = title;
        this.birthday = birthday; //fecha de nacimiento
    }

        
    public int getAge(){
        return Utility.getAge(birthday);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    @Override
    public String toString(){
	String	result  = "(Cedula)"+id +"/ (Nombre)"+lastname+", "+firstname
                        + " /(Fecha nac.)"+Utility.dateFormat(birthday)+ " /(Profesion)"+title
                        +" /(Edad)"+Utility.getAge(birthday);
	return result;
    }
    
    public String show(){
        return lastname+","+firstname;
        
    }
    
}
