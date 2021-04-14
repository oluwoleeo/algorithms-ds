package com.wole;

public class CircularList<E> {
    private int length;
    private Node<E> tail;

    public synchronized void insertAtBeginning(E data){
        Node<E> toInsert = new Node<>(data);
        if (tail != null){
            toInsert.setNext(tail.getNext());
        }
        else{
            tail = toInsert;
        }
        tail.setNext(toInsert);
        length++;
    }

    public synchronized void insertAtEnd(E data){
        Node<E> toInsert = new Node<>(data);

        if (tail == null){
            insertAtBeginning(data);
            return;
        }
        else{
            toInsert.setNext(tail.getNext());
            tail.setNext(toInsert);
            tail = toInsert;
        }
        length++;
    }

    public synchronized void insert(int pos, E data){
        Node<E> toInsert = new Node<>(data);

        if (pos < 0){
            pos = 0;
        }
        if (pos > length){
            pos = length;
        }

        if (tail == null || pos == 0){
            insertAtBeginning(data);
            return;
        }
        else if (pos == length){
            insertAtEnd(data);
            return;
        }
        else{
            Node<E> temp = tail.getNext();

            for(int i = 1; i < pos; i++){
                temp = temp.getNext();
            }
            toInsert.setNext(temp.getNext());
            temp.setNext(toInsert);
        }
        length++;
    }

    public synchronized E deleteFromBeginning(){
        if (tail != null){
            Node<E> toDelete = tail.getNext();
            if (length == 1){
                tail = null;
            }
            else{
                tail.setNext(toDelete.getNext());
            }
            length--;
            return toDelete.getData();
        }
        return null;
    }

    public synchronized E deleteFromEnd(){
        if (tail != null){
            Node<E> toDelete = tail;
            if (length == 1){
                tail = null;
            }
            else{
                Node<E> currentNode = tail.getNext();
                int count = 1;

                while(count < length-1){
                    currentNode = currentNode.getNext();
                    count++;
                }
                currentNode.setNext(tail.getNext());
                tail = currentNode;
            }
            length--;
            return toDelete.getData();
        }
        return null;
    }

    public synchronized E delete(int pos){
        if (pos < 0 || pos >= length){
            return null;
        }

        if (tail != null){
            Node<E> toDelete;
            if (pos == 0){
                return deleteFromBeginning();
            }
            else if(pos == length - 1){
                return deleteFromEnd();
            }
            else{
                Node<E> currentNode = tail.getNext();
                int count = 1;

                while(count < pos){
                    currentNode = currentNode.getNext();
                    count++;
                }
                toDelete = currentNode.getNext();
                currentNode.setNext(toDelete.getNext());
            }
            length--;
            return toDelete.getData();
        }
        return null;
    }

    public int getLength(){
        return length;
    }

    public Node<E> getHead(){
        if (tail != null){
            return tail.getNext();
        }
        else{
            return null;
        }
    }
    public Node<E> getTail(){
        if (tail != null){
            return tail;
        }
        else{
            return null;
        }
    }

    public Node<E> getNode(int pos){
        Node<E> currentNode;
        if (tail != null) {
            if (pos >= 0 && pos < length){
                currentNode = tail;
                int count = 0;
                while(count <= pos){
                    currentNode = currentNode.getNext();
                    count++;
                }
                return currentNode;
            }
        }
        return null;
    }

    public int getPos(E data){
        if (tail != null){
            Node<E> currentNode = tail.getNext();
            int pos = 0;
            while (pos < length){
                if (currentNode.getData().equals(data)){
                    return pos;
                }
                currentNode = currentNode.getNext();
                pos++;
            }
        }
        return -1;
    }

    public void clearList(){
        tail = null;
        length = 0;
    }
}
