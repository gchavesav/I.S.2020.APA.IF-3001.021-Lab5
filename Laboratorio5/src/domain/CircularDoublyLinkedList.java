/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import util.Utility;

/**
 * Lista circular doblemente enlazada
 * @author Profesor Lic. Gilberth Chaves A.
 */
public class CircularDoublyLinkedList implements List {
    private Node first; //apunta al inicio de la lista
    private Node last; //apunta al final de la lista
    
   //Constructor
    public CircularDoublyLinkedList(){
        this.first = this.last = null;
    }

    @Override
    public int size() throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is Empty");
        }
        Node aux = first;
        int count=0;
        while(aux!=last){
            count++;
            aux = aux.next; //lo movemos al sgte nodo
        }
        return count+1; //+1 para que cuente el ultimo
    }

    @Override
    public void clear() {
        first = last = null;
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public boolean contains(Object element) throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is Empty");
        }
        Node aux = first;
        while(aux!=last){
            if(Utility.equals(aux.data, element)){
                return true;
            }
            aux = aux.next; //lo movemos al sgte nodo
        }
        //se sale cuando aux==last
        //solo nos queda verificar si el elemento a buscar esta en el ultimo nodo
        return Utility.equals(aux.data, element);
    }

    @Override
    public void add(Object element) {
        Node newNode = new Node(element);
        if(isEmpty()){
            first = last = newNode;
            this.last.next = first; //enlace circular
        }
        else{
            last.next = newNode;
            //hago el doble enlace
            newNode.prev = last;
            last = newNode;
            
            //hago el enlace circular
            last.next = first;
            //hago el doble enlace
            first.prev = last;
        }
    }

    @Override
    public void addFirst(Object element) {
        Node newNode = new Node(element);
        if(isEmpty()){
            this.first = this.last = newNode;
            this.last.next = first; //enlace circular
        }
        newNode.next = first;
        //hago el doble enlace
        first.prev = newNode;
        first = newNode;
        
        //hago el enlace circular
        last.next = first;
    }

    @Override
    public void addLast(Object element) {
        add(element);
    }

    @Override
    public void addInSortedList(Object element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Object element) throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is Empty");
        }
        //caso1. El elemento a suprimir es el primero
        if(Utility.equals(first.data, element)){
            first = first.next;
        }
        //caso2. Elemento puede estar en medio o al final
        else{
            Node prev = first; //anterior
            Node aux = first.next;
            while(aux!=last&&!Utility.equals(aux.data, element)){
                prev = aux;
                aux = aux.next;
            }
            //se sale cuando alcanza aux=last
            //o cuando encuentra el elemento a suprimir
            if(Utility.equals(aux.data, element)){
                //desenlanza el nodo
                prev.next = aux.next;
                //mantengo el doble enlace
                aux.next.prev = prev;
                        
            }
            //debo asegurarme q last apunte al ultimo nodo
            if(aux==last){ //estamos en el ultimo nodo
                last=prev;
            }
        }//else
        //mantengo el enlace circular
        last.next = first;
        //q pasa si solo queda un nodo
        //y es el q quiero eliminar
        if(first==last&&Utility.equals(first.data, element)){
            clear(); //anulo la lista
        }
    }

    @Override
    public Object removeFirst() throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is Empty");
        }
        Object element = first.data;
        first = first.next; //muevo el apuntador al sgte nodo
        //hago el enlace circular
        last.next = first;
        return element;
    }

    @Override
    public Object removeLast() throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is Empty");
        }
        Node aux = first;
        Node prev = first; //anterior
        while(aux.next!=last){
            prev = aux; //dejo un rastro al nodo anterior
            aux = aux.next; //lo movemos al sgte nodo
        }
        //aux esta en el ultimo nodo
        Object element = aux.data; //es el ultimo en la lista
        prev.next = first; //elimino el ultimo nodo
        last = prev; //muevo el apuntador
        //hago el enlace circular
        last.next = first;
        return element;
    }

    @Override
    public void sort() throws ListException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int indexOf(Object element) throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is Empty");
        }
        Node aux = first;
        int index=1;
        while(aux!=last){
            if(Utility.equals(aux.data, element)){
                return index;
            }
            index++;
            aux = aux.next; //lo movemos al sgte nodo
        }
        //se sale cuando aux apunta a last (al ultimo nodo)
        if(Utility.equals(aux.data, element)){
            return index;
        }
        return -1; //indica q el elemento no existe
    }
    
    @Override
    public Object getFirst() throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is Empty");
        }
        return first.data;
    }

    @Override
    public Object getLast() throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is Empty");
        }
        return last.data; //es el ultimo en la lista
    }    

    @Override
    public Object getPrev(Object element) throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is Empty");
        }
        if(Utility.equals(first.data, element)){
            return "Es el inicio, no tiene anterior";
        }
        Node aux = first;
        while(aux.next!=last){
            //if(aux.next.data.equals(element)){
            if(Utility.equals(aux.next.data, element)){
                return aux.data;
            }
            aux = aux.next;
        }
        //se sale cuando aux.next apunta a last (al ultimo nodo)
        if(Utility.equals(aux.next.data, element)){
            return aux.data;
        }
        return "No existe en la lista";
    }

    @Override
    public Object getNext(Object element) throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is Empty");
        }
        Node aux = first; //dejar un rastro
        while(aux!=last){
            if(Utility.equals(aux.data, element)){
                if(aux.next!=null){
                    return aux.next.data; //el elemento posterior
                }else{
                    return "No tiene posterior";
                }
            }
            aux = aux.next; //lo movemos al sgte nodo
        }
        //se sale cuando aux==last
        if(Utility.equals(aux.data, element)){
            return aux.next.data; //el elemento anterior
        }
        return "El elemento no existe en la lista";
    }

    @Override
    public Node getNode(int index) throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is Empty");
        }
        Node aux = first;
        int i = 1; //posicion del primer nodo
        while(aux!=last){
            if(Utility.equals(i, index)){
                return aux;
            }
            i++;
            aux = aux.next; //lo movemos al sgte nodo
        }
        //se sale cuando aux==last
        if(Utility.equals(i, index)){
            return aux;
        }
        return null; //si llega aqui no encontro el nodo
    }    
    
    @Override
    public String toString() {
        String result = "\nCircular Doubly Linked List\n";
        Node aux = first;
        while(aux!=last){
            result+=aux.data+"\n";
            //result+="\n"+aux.data;
            aux = aux.next; //lo movemos al sgte nodo
        }
        //se sale cuando aux==last
        //agregamos la info del ultimo nodo
        return aux!=null
                ?result+"\n"+aux.data
                :"\nCircular Doubly Linked List is Empty!!!\n";
    }

}
