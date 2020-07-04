public class StringPractice {
    public static void main(String[] args) {
        String str = "Singh";
        str =str.concat("abc");
        System.out.println(str);

        StringBuilder name=new StringBuilder("Sandeep ");
        int i=str.length()-1;
        while(i>=0){
            name.append(str.charAt(i));
            i--;
        }
        System.out.println(name);
    }
}
