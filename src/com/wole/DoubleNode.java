package com.wole;

public class DoubleNode<E> {
    private E data;
    private DoubleNode<E> prev;
    private DoubleNode<E> next;

    public DoubleNode(E dt){
        data = dt;
    }

    public void SetData(E dt){
        data = dt;
    }

    public E GetData(){
        return data;
    }

    public void SetPrev(DoubleNode<E> pv){
        prev = pv;
    }

    public DoubleNode<E> GetPrev(){
        return prev;
    }

    public void SetNext(DoubleNode<E> nt){
        next = nt;
    }

    public DoubleNode<E> GetNext(){
        return next;
    }
}
