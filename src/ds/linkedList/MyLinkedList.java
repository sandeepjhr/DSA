package ds.linkedList;

public class MyLinkedList {

    private Node head;

    public MyLinkedList() {
        head = new Node("Head Node");
    }

    public void add(String data){
        Node newNode = new Node(data);
        Node current = head;
        while (current.getNext()!=null){
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    public void add(String data, int position){
        Node newNode = new Node(data);
        Node current = head;
        int counter = 0;
        while(current.getNext() != null){
           if(counter == position-1){
               newNode.setNext(current.getNext());
               current.setNext(newNode);
           }
           current =current.getNext();
           counter++;
        }
    }

    public void remove(String data){
        Node current = head;
        while(current.getNext() != null){
            if(current.getNext().getData().equalsIgnoreCase(data)){
                Node nodeToRemove = current.getNext();
                current.setNext(current.getNext().getNext());
                nodeToRemove.setNext(null);
                nodeToRemove = null;
                return;
            }
            current = current.getNext();
        }
    }

    public void displayLinkedList(){
        Node current = head;
        while(current.getNext() != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
        System.out.println(current.getData());
    }
    private class Node{
        private String data;
        private Node next;


        public Node(String data) {
            next=null;
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
