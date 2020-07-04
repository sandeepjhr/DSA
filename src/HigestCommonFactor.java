public class HigestCommonFactor {
    public int generalizedGCD(int[] arr){
        int gcd=arr[0];
       for(int i=1; i< arr.length; i++){
           gcd = calculateGcd(arr[i],gcd);
       }
       return gcd;
    }

    int calculateGcd(int x, int y){
        if(x == 0){
            return y;
        }
        return calculateGcd(y%x, x);
    }

    public static void main(String[] args) {
        HigestCommonFactor obj = new HigestCommonFactor();

        int input1[]=new int[]{2,3,4,5,6};
        int input2[]=new int[]{2,4,6,8,10};
        int input3[]=new int[]{45,15,3};
        System.out.println(obj.generalizedGCD(input1));
        System.out.println(obj.generalizedGCD(input2));
        System.out.println(obj.generalizedGCD(input3));
    }
}
