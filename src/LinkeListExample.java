import java.util.LinkedList;

public class LinkeListExample {
    public static void main(String[] args){
        LinkedList<String> myLIst = new LinkedList();
        myLIst.add("A");
        myLIst.add("B");
        myLIst.add(2,"C");
        System.out.println(myLIst);
    }
}
