public class Factorial {
    public static void main(String[] args) {
        int n = 4;
       // System.out.println("factorial of " + n + " is " + calcFactorialNormal(n));
       System.out.println("factorial of " + n + " is " + calcFactRecursive(n));
    }

    public static int calcFactorialNormal(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = i * fact;
        }
        return fact;
    }

    public static int calcFactRecursive(int n){
        if(n==0) return 1;
          return  n*calcFactRecursive(n-1);

    }
}
