package estructuras2017gr4;

/**
 * Created by ivanc on 16/08/2017.
 */

import java.util.*;

public class CircularWithHeader<T> implements LinearList<T>{
    protected ChainNode<T> headerNode;
    protected int size;

    public CircularWithHeader(){
        headerNode = new ChainNode<T>();
        headerNode.next = headerNode;
        size = 0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    void checkIndex(int i){
        if(i<0 || i>=size)
            throw new IndexOutOfBoundsException("index = " + i + " size = " + size);
    }

    public T get(int i){
        checkIndex(i);
        ChainNode<T> currentNode = headerNode.next;
        for(int j=0; j<i; j++)
            currentNode = currentNode.next;
        return currentNode.element;
    }

    public int indexOf(T x) {
        headerNode.element = x;
        ChainNode<T> currentNode = headerNode.next;
        int index = 0;
        while(!currentNode.element.equals(x)){
            currentNode = currentNode.next;
            index++;
        }
        if(currentNode == headerNode)
            return -1;
        else
            return index;
    }

    public T remove(int index){
        checkIndex(index);
        T removedElement;
        ChainNode<T> q = headerNode;
        for(int i = 0; i<index ;i++)
            q= q.next;
        removedElement = q.next.element;
        q.next = q.next.next;

        size--;
        return removedElement;
    }

    public void add(int i, T theElement){
        if(i<0 || i>size)
            throw new IndexOutOfBoundsException("index = " + i + " size = " + size);

        ChainNode<T> p = headerNode;
        for(int j =0 ; j < i; j++)
            p = p.next;
        p.next = new ChainNode<T>(theElement, p.next);
        size++;
    }

    public String toString(){
        StringBuilder s = new StringBuilder("[");
        ChainNode<T> currentNode = headerNode.next;
        while(currentNode != headerNode) {
            s.append(Objects.toString(currentNode.element) + ", ");
            currentNode = currentNode.next;
        }
        if(size > 0)
            s.setLength(s.length() - 2);
        s.append("]");
        return new String(s);
    }

    public static void main(String[] args){
        CircularWithHeader<Integer> x = new CircularWithHeader<>();
        System.out.println("Initial size is " + x.size());
        if(x.isEmpty())
            System.out.println("The list is empty");
        else System.out.println("The list is not empty");
        x.add(0, new Integer(2));
        x.add(1, new Integer(6));
        x.add(0, new Integer(1));
        x.add(2, new Integer(4));
        System.out.println("List size is " + x.size());
        System.out.println("The list is " + x);
        int index = x.indexOf(new Integer(4));
        if(index < 0)
            System.out.println("4 not found");
        else System.out.println("The index of 4 is " + index);
        index = x.indexOf(new Integer(3));
        if(index < 0)
            System.out.println("3 not found");
        else System.out.println("The index of 3 is " + index);
        System.out.println("Element at 0 is " + x.get(0));
        System.out.println("Element at 3 is " + x.get(3));
        System.out.println(x.remove(1) + " removed");
        System.out.println("The list is " + x);
        System.out.println(x.remove(2) + " removed");
        System.out.println("The list is " + x);
        if(x.isEmpty())
            System.out.println("The list is empty");
        else System.out.println("The list is not empty");
        System.out.println("List size is " + x.size());
    }

}
