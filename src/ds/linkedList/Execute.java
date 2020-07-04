package ds.linkedList;

public class Execute {
    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
        mll.add("Oracle");
        mll.add("Microsoft");
        mll.add("Yahoo");
        mll.add("Google");
        //mll.add("IBM",3);

        mll.displayLinkedList();

       // mll.remove("Yahoo");
       // mll.displayLinkedList();
    }
}
