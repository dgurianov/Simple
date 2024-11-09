package gud.example.datastructures.core.linkedlist;


class MyLinkedList<E>{
    private int size = 0;
    private Node head;
    private Node tail;

    class Node{
        private E value;
        private Node next;

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void add(E e){
        //If empty list
        Node newNode = new Node();
        newNode.setValue(e);
        if( isNotEmpty() ) {
            //If not empty list
            //New node is next for tail
            this.tail.next = newNode;
            //New node is a  new tail now
            this.tail = newNode;
            size++;
            //And we are done in this method
            return;
        }
        //We consider this to be a new list , regardless if it became dirty and we came here
        this.head = newNode;
        this.tail = head;
        size = 1;
    }

    private Node getNode(int index){
        if(! isNotEmpty() || index + 1 > size ){
            throw new IndexOutOfBoundsException("List is empty or index is too big");
        }
        int counter = 0 ;
        Node resultNode = head ;
        while(counter < index ){
            resultNode = resultNode.next;
            counter++;
        }
        return resultNode;

    }

    public E get(int index){
        return getNode(index).getValue();
    }

    public void deleteByIndex(int index){
        if(! isNotEmpty() || index + 1 > size ){
            throw new IndexOutOfBoundsException("List is empty or index " + index +" is too big! ");
        }
        if (size == 1 ){
            //Removal of the last node
            this.head = null;
            this.tail = null;
        }
        connectLeftToRight(
                getNode(index-1),  //Node from the left of removed , prev node
                getNode(index).getNext() //Node from the right of removed , next node
        );
        size--;
    }

    private void connectLeftToRight(Node left, Node right){
        if(left == null){
            //We just deleted the head node , set new head as right node
            this.head = right;
        } else if (right == null) {
            //We just deleted tail node
            this.tail = left;
        }else{
            //We have deleted node from the middle , we need to connect left and right
            left.setNext(right);
        }

    }

    private boolean isNotEmpty(){ return size != 0 && head != null ; }

}