package com.wole;

import java.util.Iterator;

public class SinglyLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private int length = 0;

    public synchronized void InsertAtBeginning(E data){
        Node<E> toInsert = new Node<>(data);

        if (head != null){
            toInsert.setNext(head);
        }
        head = toInsert;
        length++;
    }

    public synchronized void InsertAtEnd(E data){
        Node<E> toInsert = new Node<>(data);

        if (head == null){
            InsertAtBeginning(data);
            return;
        }
        else{
            /* Node<E> p;
            Node<E> q;

            for(p = head; (q=p.getNext())!=null; p = q){
                p.setNext(toInsert);
            } */

            Node<E> p = head;

            while(p.getNext() != null){
                p = p.getNext();
            }
            p.setNext(toInsert);
        }
        length++;
    }

    public synchronized void Insert(int pos, E data){
        Node<E> toInsert = new Node<>(data);

        if (pos < 0){
            pos = 0;
        }
        else if (pos > length){
            pos = length;
        }

        if (head == null || pos == 0){
            InsertAtBeginning(data);
            return;
        }
        else if (pos == length){
            InsertAtEnd(data);
            return;
        }
        else{
            Node<E> temp = head;

            for(int i = 1; i < pos; i++){
                temp = temp.getNext();
            }
            toInsert.setNext(temp.getNext());
            temp.setNext(toInsert);
        }
        length++;
    }

    public synchronized E DeleteFromBeginning(){
        Node<E> toDelete;
        if (head != null) {
            toDelete = head;
            head = head.getNext();
            length--;
            return toDelete.getData();
        }
        return null;
    }

    /**
       Deletes from the end of a node
     */
    public synchronized E DeleteFromEnd(){
        Node<E> toDelete;
        Node<E> before;
        if (head != null) {
            before = head;
            int count = 1;
            while(count != length-1){
                before = before.getNext();
                count++;
            }
            toDelete = before.getNext();
            before.setNext(null);
            length--;
            return toDelete.getData();
        }
        return null;
    }

    public synchronized E Delete(int pos){
        if (pos < 0 || pos >= length){
            return null;
        }

        if (head != null) {
            if (pos == 0){
                return DeleteFromBeginning();
            }
            else if (pos == length - 1){
                return DeleteFromEnd();
            }
            else{
                Node<E> toDelete;
                Node<E> before;

                before = head;
                int count = 1;
                while(count != pos){
                    before = before.getNext();
                    count++;
                }
                toDelete = before.getNext();
                before.setNext(toDelete.getNext());
                length--;
                return toDelete.getData();
            }
        }
        return null;
    }

    public synchronized E DeleteNode(Node<E> toDelete){
        if (head != null) {
            Node<E> current = head;
            Node<E> before = head;
            while(current != null){
                if (current.equals(toDelete)){
                    toDelete = current;
                    before.setNext(current.getNext());
                    length--;
                    return toDelete.getData();
                }
                before = current;
                current = current.getNext();
            }
        }
        return null;
    }

    public int GetLength(){
        return length;
    }

    public Node<E> GetHead(){
        return head;
    }

    public Node<E> GetTail(){
        Node<E> currentNode;
        if (head != null) {
            currentNode = head;
            int count = 1;
            while(count != length){
                currentNode = currentNode.getNext();
                count++;
            }
            return currentNode;
        }
        return null;
    }

    public Node<E> GetNode(int pos){
        Node<E> currentNode;
        if (head != null) {
            if (pos >= 0 && pos < length){
                currentNode = head;
                int count = 0;
                while(count != pos){
                    currentNode = currentNode.getNext();
                    count++;
                }
                return currentNode;
            }
        }
        return null;
    }

    public int GetPos(E data){
        if (head != null){
            Node<E> currentNode = head;
            int pos = 0;
            while (currentNode != null){
                if (currentNode.getData().equals(data)){
                    return pos;
                }
                currentNode = currentNode.getNext();
                pos++;
            }
        }
        return -1;
    }

    public void ClearList(){
        head = null;
        length = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E>{
        Node<E> currentNode = head;
        int count = 0;

        @Override
        public boolean hasNext() {
            if (count == length - 1){
                return true;
            }
            else if (count >= length){
                return false;
            }
            return currentNode.getNext() != null;
        }

        @Override
        public E next() {
            E data = null;
            if (currentNode != null){
                data = currentNode.getData();
                currentNode = currentNode.getNext();
                count++;
            }
            return data;
        }

        @Override
        public void remove() {
            DeleteNode(currentNode);
        }
    }
}
