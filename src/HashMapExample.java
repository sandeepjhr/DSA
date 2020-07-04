import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args){
        HashMap<String, Integer> phoneBook = new HashMap<>();
        phoneBook.put("Kevin",123);
        phoneBook.put("Jil",456);
        phoneBook.put("Brenda",789);
        phoneBook.put(null,000);
        if(phoneBook.containsKey(null)){
            phoneBook.remove(null);
        }

        System.out.println(phoneBook);
        phoneBook.clear();
        System.out.println(phoneBook);
    }
}
