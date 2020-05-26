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
public class SinglyLinkedList implements List {
    private Node first; //apuntador al inicio de la lista
    
    //Constructor
    public SinglyLinkedList(){
        this.first = null;
    }

    @Override
    public int size() throws ListException {
        if(this.isEmpty()){
            throw new ListException("Singly Linked List is Empty");
        }
        Node aux = first;
        int count = 0;
        //me muevo por la lista hasta el ultimo nodo
        while(aux!=null){
            count++;
            aux = aux.next;
        }
        return count;
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
            throw new ListException("Singly Linked List is Empty");
        }
        Node aux = first;
        //me muevo por la lista hasta el ultimo nodo
        while(aux!=null){
            if(util.Utility.equals(aux.data, element)){
                return true;
            }
            aux = aux.next;
        }
        return false; //indica q el elemento no existe en la lista
    }

    @Override
    public void add(Object element) {
        Node newNode = new Node(element);
        if(this.isEmpty()){
            this.first = newNode;
        }
        else{
            Node aux = first;
            //me muevo por la lista hasta el ultimo nodo
            while(aux.next!=null){
                aux = aux.next;
            }
            //se sale cuando estoy en el ult nodo de la lista
            aux.next = newNode;
        }
    }

    @Override
    public void addFirst(Object element) {
        Node newNode = new Node(element);
        if(this.isEmpty()){
            this.first = newNode;
        }
        else{
            newNode.next = this.first;
            this.first = newNode; //para garantizar q first apunte al primer nodo
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
            throw new ListException("Singly Linked List is Empty");
        }
        //Caso 1. El elemento a suprimir es el primero de la lista
        if(util.Utility.equals(first.data, element)){
            this.first = this.first.next;
        }
        //Caso 2. El elemento a suprimir puede estar en cualquir otra parte
        else{
            Node aux = first.next; //apuntador al nodo sgte
            Node aux2 = first; //apuntador al nodo anterior
            while(aux!=null&&!util.Utility.equals(aux.data, element)){
                aux2 = aux; //dejamos un rastro
                aux = aux.next; //lo movemos al sgte nodo
            }
            //se sale del while cuando alcanza nulo o cuando encuentra el elemento
            if(aux!=null&&util.Utility.equals(aux.data, element)){
                //requerimos desenlazar el nodo con el elemento a suprimir
                aux2.next = aux.next;
            }
        }
    }

    @Override
    public Object removeFirst() throws ListException {
        if(this.isEmpty()){
            throw new ListException("Singly Linked List is Empty");
        }
        Object element = this.first.data;
        this.first = this.first.next; //muevo el apuntador al sgte nodo
        return element;
    }

    @Override
    public Object removeLast() throws ListException {
        if(this.isEmpty()){
            throw new ListException("Singly Linked List is Empty");
        }
        Node aux = this.first;
        Node aux2 = first; //va a ser un apuntador al nodo anterior
        while(aux.next!=null){
            aux2 = aux; //dejo un rastro al nodo anterior
            aux = aux.next; //lo movemos al sgte nodo
        }
        //se sale del while cuando aux esta en el ult nodo
        Object element = aux.data;
        aux2.next = null; //elimino el ultimo nodo
        return element;
    }


    @Override
    public void sort() throws ListException {
        if(isEmpty())
            throw new ListException("Singly Linked List is Empty");
        Node prevAux = first; //auxiliar anterior
        Node aux1 = first;
        Node aux2 = first.next;
        while(aux1!=null){
            while(aux2!=null){
                if(util.Utility.greaterT(aux1.data, aux2.data)){
                    //El elemento del primer nodo es el apuntado por inicio
                    if(aux1==first){
                        first = swapNodes(first, aux2);
                        prevAux=aux1=first; //para actualizar
                    }//if
                    else{ //significa que no es el primer nodo de la lista
                        aux1 = swapNodes(aux1, aux2);
                        prevAux.next=aux1; //para mantener todo conectado
                    }//else
                    aux2=aux1; //actualizo enlaces
                }//if
                aux2 = aux2.next;
            }//while aux2
            prevAux = aux1; //dejamos un rastro en el nodo anterior
            aux1 = aux1.next;
            if(aux1==null) break; //rompe el while aux1
            aux2 = aux1.next;
       }//while aux1
    }
    
    /***
     *swapNodes (cambia los enlaces los nodos dados)
     * cambia los enlaces de los nodos
     * 
     */
    private Node swapNodes(Node node1, Node node2){
        //si nodo1 y nodo2 son consecutivos
        if(node1.next==node2){
            node1.next = node2.next;
            node2.next = node1;
        }else{
            Node aux=node1;
            while(aux.next!=node2){
                aux=aux.next;
            }
            aux.next=node2.next;
            node2.next=node1;
        }
        return node2; 
    }
    

    @Override
    public int indexOf(Object element) throws ListException {
        if(this.isEmpty()){
            throw new ListException("Singly Linked List is Empty");
        }
        Node aux = first;
        int index=1; //el primer nodo va a estar en el indice 1
        //me muevo por la lista hasta el ultimo nodo
        while(aux!=null){
            if(util.Utility.equals(aux.data, element)){
                return index;
            }
            index++;
            aux = aux.next;
        }
        return -1; //indica q el elemento no existe
    }

    @Override
    public Object getFirst() throws ListException {
        if(this.isEmpty()){
            throw new ListException("Singly Linked List is Empty");
        }
        return this.first.data;
    }

    @Override
    public Object getLast() throws ListException {
        if(this.isEmpty()){
            throw new ListException("Singly Linked List is Empty");
        }
        Node aux = first;
        while(aux.next !=null){
            aux = aux.next; //lo movemos al sgte nodo
        }
        //cuando se sale del while, estamos en el ultimo nodo
        return aux.data; //retorna el elemento almacenado en el ult nodo
    }

    @Override
    public Object getPrev(Object element) throws ListException {
        if(this.isEmpty()){
            throw new ListException("Singly Linked List is Empty");
        }
        //Caso 1. Si es el inicio, no tiene anterior
        if(util.Utility.equals(first.data, element)){
            return "Es el inicio, no tiene anterior";
        }
        //Caso 2. Todo lo demas
        Node aux = first;
        while(aux.next!=null){
            if(util.Utility.equals(aux.next.data, element)){
                return aux.data;
            }
            aux = aux.next;
        }
        return "El elemento no existe en la lista";
    }

    @Override
    public Object getNext(Object element) throws ListException {
        if(this.isEmpty()){
            throw new ListException("Singly Linked List is Empty");
        }
        Node aux = first;
        while(aux!=null){
            if(util.Utility.equals(aux.data, element)){
                if(aux.next!=null){
                    return aux.next.data;
                }else{
                    return "no tiene";
                }
            }
            aux = aux.next;
        }
        return "El elemento no existe en la lista";
    }

    @Override
    public Node getNode(int index) throws ListException {
        if(this.isEmpty()){
            throw new ListException("Singly Linked List is Empty");
        }
        Node aux = first;
        int i = 1; //posicion del primer nodo
        while(aux!=null){
            if(util.Utility.equals(i, index)){
                return aux; //debera retornar todo el nodo
            }
            i++;
            aux = aux.next;
        }
        return null; //si llega aqui, quiere decir q no encontro el nodo
    }
    
    public String show() {
        String result="Singly Linked List: ";
        Node aux = first;
        while(aux!=null){
            result +="\n"+aux.data;
            aux = aux.next;
        }
        return result;
    }

    @Override
    public String toString() {
        String result="Singly Linked List: ";
        Node aux = first;
        while(aux!=null){
            result +=aux.data+", ";
            aux = aux.next;
        }
        return result;
    }
    
    
}
