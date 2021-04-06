package com.wole;

public class DoublyLinkedList<E> {
    private DoubleNode<E> head;
    private int length = 0;

    public synchronized void InsertAtBeginning(E data){
        DoubleNode<E> toInsert = new DoubleNode<>(data);

        if (head != null){
            toInsert.SetNext(head);
            head.SetPrev(toInsert);
        }
        head = toInsert;

        length++;
    }

    public synchronized void InsertAtEnd(E data){
        DoubleNode<E> toInsert = new DoubleNode<>(data);

        if (head != null){
            DoubleNode<E> currentNode = head;

            while(currentNode.GetNext() != null){
                currentNode = currentNode.GetNext();
            }
            toInsert.SetPrev(currentNode);
            currentNode.SetNext(toInsert);
        }
        else{
            head = toInsert;
        }

        length++;
    }

    public synchronized void Insert(int pos, E data) {
        DoubleNode<E> toInsert = new DoubleNode<>(data);

        if (pos < 0){
            pos = 0;
        }
        if (pos > length){
            pos = length;
        }

        if(head == null || pos == 0){
            InsertAtBeginning(data);
            return;
        }
        else if (pos == length ){
            InsertAtEnd(data);
            return;
        }
        else{
            DoubleNode<E> currentNode= head;
            int count = 1;

            while (count < pos){
                currentNode = currentNode.GetNext();
                count++;
            }
            toInsert.SetNext(currentNode.GetNext());
            toInsert.SetPrev(currentNode);
            currentNode.GetNext().SetPrev(toInsert);
            currentNode.SetNext(toInsert);
        }
        length++;
    }

    public synchronized E DeleteFromBeginning(){
        if (head != null){
            DoubleNode<E> toDelete = head;

            head = head.GetNext();
            if (head != null){
                head.SetPrev(null);
            }
            length--;
            return toDelete.GetData();
        }
        return null;
    }

    public synchronized E DeleteFromEnd(){
        if (head != null){
            DoubleNode<E> toDelete = head;

            while(toDelete.GetNext() != null){
                toDelete = toDelete.GetNext();
            }
            if (toDelete.GetPrev() != null){
                toDelete.GetPrev().SetNext(null);
            }
            else{
                head = null;
            }

            length--;
            return toDelete.GetData();
        }
        return null;
    }

    public synchronized E Delete(int pos){
        if (pos < 0 || pos >= length){
            return null;
        }

        if(head != null ){
            if (pos == 0){
                return DeleteFromBeginning();
            }
            else if (pos == length - 1){
                return DeleteFromEnd();
            }
            DoubleNode<E> currentNode= head;
            DoubleNode<E> toDelete;
            int count = 1;

            while (count < pos){
                currentNode = currentNode.GetNext();
                count++;
            }
            toDelete = currentNode.GetNext();
            currentNode.SetNext(toDelete.GetNext());
            currentNode.GetNext().SetPrev(currentNode);
            length--;

            return toDelete.GetData();
        }
        return null;
    }

    public int GetLength(){
        return length;
    }

    public DoubleNode<E> GetHead(){
        return head;
    }

    public DoubleNode<E> GetTail(){
        if (head != null){
            DoubleNode<E> currentNode = head;

            while(currentNode.GetNext() != null){
                currentNode = currentNode.GetNext();
            }
            return currentNode;
        }
        return null;
    }

    public DoubleNode<E> GetData(int pos){
        if(head != null){
            if (pos >= 0 && pos < length){
                DoubleNode<E> currentNode = head;
                if (pos == 0){
                    return head;
                }
                int count = 1;
                while (count <= pos){
                    currentNode = currentNode.GetNext();
                    count++;
                }
                return currentNode;
            }
        }
        return null;
    }

    public int GetPos(E data){
        if(length == 0){
            return -1;
        }
        int count = 0;
        DoubleNode<E> currentNode = head;

        while(count < length){
            if (currentNode.GetData().equals(data)){
                return count;
            }
            currentNode = currentNode.GetNext();
            count++;
        }
        return -1;
    }

    public void ClearList(){
        head = null;
        length = 0;
    }
}
