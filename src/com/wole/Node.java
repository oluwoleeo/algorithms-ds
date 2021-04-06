package com.wole;

public class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E dt){
        data = dt;
    }

    public void setData(E newData){
        data = newData;
    }

    public E getData(){
        return data;
    }

    public void setNext(Node<E> nextNode){
        next = nextNode;
    }

    public Node<E> getNext(){
        return next;
    }
}
