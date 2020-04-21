/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Profesor Lic. Gilberth Chaves Avila
 */
public class CircularLinkedList implements List {
    private Node first; //apuntador al inicio de la lista
    private Node last; //apuntador al final de la lista
    
    //Constructor
    public CircularLinkedList(){
        this.first = this.last = null;
    }

    @Override
    public int size() throws ListException {
        if(this.isEmpty()){
            throw new ListException("Circular Linked List is Empty");
        }
        Node aux = first;
        int count = 0;
        //me muevo por la lista hasta el ultimo nodo
        while(aux!=last){
            count++;
            aux = aux.next;
        }
        return count+1; //+1 para que cuente el ult nodo
    }

    @Override
    public void clear() {
        this.first = null;
    }

    @Override
    public boolean isEmpty() {
        return this.first==null;
    }

    @Override
    public boolean contains(Object element) throws ListException {
        if(this.isEmpty()){
            throw new ListException("Circular Linked List is Empty");
        }
        Node aux = first;
        //me muevo por la lista hasta el ultimo nodo
        while(aux!=last){
            if(util.Utility.equals(aux.data, element)){
                return true;
            }
            aux = aux.next;
        }
        //se sale cuando aux==last (cuando aux apunta al ult nodo)
        //entonces, solo nos queda verificar si el elemento a buscar
        //esta en el ult nodo
        return util.Utility.equals(aux.data, element);
    }

    @Override
    public void add(Object element) {
        Node newNode = new Node(element);
        if(this.isEmpty()){
            this.first = this.last = newNode;
            this.last.next = first; //enlace circular
        }
        else{
            last.next = newNode;
            last = newNode;
            //hago el enlace circular
            last.next = first;
        }
    }

    @Override
    public void addFirst(Object element) {
        Node newNode = new Node(element);
        if(this.isEmpty()){
            this.first = this.last = newNode;
            this.last.next = first; //enlace circular
        }
        else{
            newNode.next = this.first;
            this.first = newNode; //para garantizar q first apunte al primer nodo
            //hago el enlace circular
            this.last.next = this.first;
        }
    }

    @Override
    public void addLast(Object element) {
        this.add(element);
    }

    @Override
    public void addInSortedList(Object element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Object element) throws ListException {
        if(this.isEmpty()){
            throw new ListException("Circular Linked List is Empty");
        }
        //Caso 1. El elemento a suprimir es el primero de la lista
        if(util.Utility.equals(first.data, element)){
            this.first = this.first.next;
        }
        //Caso 2. El elemento a suprimir puede estar en cualquir otra parte
        else{
            Node aux = first.next; //apuntador al nodo sgte
            Node aux2 = first; //apuntador al nodo anterior
            while(aux!=last&&!util.Utility.equals(aux.data, element)){
                aux2 = aux; //dejamos un rastro
                aux = aux.next; //lo movemos al sgte nodo
            }
            //se sale del while cuando aux==last o cuando encuentra el elemento
            if(util.Utility.equals(aux.data, element)){
                //requerimos desenlazar el nodo con el elemento a suprimir
                aux2.next = aux.next;
            }
            //debemos asegurarnos que last apunte al ult nodo
            if(aux==last){ //si estamos en el ult nodo
                last = aux2;
            }
        }
        //mantengo el enlace circular
        last.next = first;
        //que pasa si solo queda un nodo y es el q quiero eliminar
        if(first==last&&util.Utility.equals(first.data, element)){
            this.clear(); //anulo la lista
        }
        
    }

    @Override
    public Object removeFirst() throws ListException {
        if(this.isEmpty()){
            throw new ListException("Circular Linked List is Empty");
        }
        Object element = this.first.data;
        this.first = this.first.next; //muevo el apuntador al sgte nodo
        //mantengo el enlace circular
        last.next = first;
        return element;
    }

    @Override
    public Object removeLast() throws ListException {
        if(this.isEmpty()){
            throw new ListException("Circular Linked List is Empty");
        }
        Node aux = this.first;
        Node aux2 = first; //va a ser un apuntador al nodo anterior
        while(aux.next!=last){
            aux2 = aux; //dejo un rastro al nodo anterior
            aux = aux.next; //lo movemos al sgte nodo
        }
        //se sale del while cuando aux esta en el ult nodo
        Object element = aux.data;
        aux2.next = first; //elimino el ultimo nodo
        return element;
    }

    @Override
    public void sort() throws ListException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(Object element) throws ListException {
        if(this.isEmpty()){
            throw new ListException("Circular Linked List is Empty");
        }
        Node aux = first;
        int index=1; //el primer nodo va a estar en el indice 1
        //me muevo por la lista hasta el ultimo nodo
        while(aux!=last){
            if(util.Utility.equals(aux.data, element)){
                return index;
            }
            index++;
            aux = aux.next;
        }
        //se sale cuando aux apunta a last
        if(util.Utility.equals(aux.data, element)){
            return index;
        }
        return -1; //indica q el elemento no existe
    }

    @Override
    public Object getFirst() throws ListException {
        if(this.isEmpty()){
            throw new ListException("Circular Linked List is Empty");
        }
        return this.first.data;
    }

    @Override
    public Object getLast() throws ListException {
        if(this.isEmpty()){
            throw new ListException("Circular Linked List is Empty");
        }
        return last.data; //retorna el elemento almacenado en el ult nodo
    }

    @Override
    public Object getPrev(Object element) throws ListException {
        if(this.isEmpty()){
            throw new ListException("Circular Linked List is Empty");
        }
        //Caso 1. Si es el inicio, no tiene anterior
        if(util.Utility.equals(first.data, element)){
            return "Es el inicio, no tiene anterior";
        }
        //Caso 2. Todo lo demas
        Node aux = first;
        while(aux.next!=last){
            if(util.Utility.equals(aux.next.data, element)){
                return aux.data;
            }
            aux = aux.next;
        }
        //se sale cuando aux.next apunta a last
        if(util.Utility.equals(aux.next.data, element)){
                return aux.data;
        }
        return "El elemento no existe en la lista";
    }

    @Override
    public Object getNext(Object element) throws ListException {
        if(this.isEmpty()){
            throw new ListException("Circular Linked List is Empty");
        }
        Node aux = first;
        while(aux!=last){
            if(util.Utility.equals(aux.data, element)){
                if(aux.next!=null){
                    return aux.next.data;
                }else{
                    return "no tiene";
                }
            }
            aux = aux.next;
        }
        //se sale cuando aux==last
        if(util.Utility.equals(aux.data, element)){
            return aux.next.data;
        }
        return "El elemento no existe en la lista";
    }

    @Override
    public Node getNode(int index) throws ListException {
        if(this.isEmpty()){
            throw new ListException("Circular Linked List is Empty");
        }
        Node aux = first;
        int i = 1; //posicion del primer nodo
        while(aux!=last){
            if(util.Utility.equals(i, index)){
                return aux; //debera retornar todo el nodo
            }
            i++;
            aux = aux.next;
        }
        //se sale cuando aux==last
        if(util.Utility.equals(i, index)){
            return aux;
        }
        return null; //si llega aqui, quiere decir q no encontro el nodo
    }

    @Override
    public String toString() {
        String result="Circular Linked List:\n";
        Node aux = first;
        while(aux!=last){
            result +=aux.data+"\n";
            aux = aux.next;
        }
        //se sale del while cuando aux==last
        //por lo tanto, agregamos la info del ult nodo
        result+=aux.data; //requerido pq muestre la info del ult nodo
        return result;
    }
    
    public String show() {
        String result = "";
        Node aux = first;
        while(aux!=last){
            result+=aux.data+"\n";
            aux = aux.next; //lo movemos al sgte nodo
        }
        //se sale cuando aux==last
        //agregamos la info del ultimo nodo
        return result+aux.data;
    }
    
    public String show2() {
        String result = "";
        Node aux = first;
        while(aux!=last){
            //result+=aux.data+"\n";
            Employee e = (Employee)aux.data;
            result+=e.show()+"\n";
            aux = aux.next; //lo movemos al sgte nodo
        }
        //se sale cuando aux==last
        //agregamos la info del ultimo nodo
        return result+aux.data;
    }
}
