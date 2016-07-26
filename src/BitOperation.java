/**
 * Created by Sanjeev on 7/21/2016.
 */
public class BitOperation {

    public static void main(String args[]){
//       int[]  a = {1,2,1,2,3,4,3};
//        System.out.println(findElement(a));

//        int a =4, b =-3;
//        System.out.println(oppositeSign(a,b));

//        int a = 7;
//        System.out.println(countAllSetsUntill(a));

//        int a =-4, b=5;
//        System.out.println(addNums(a, b));

//          int a =-4, b=5;
//          System.out.println(min(a, b));

//            int a =5;
//        System.out.println(addOne(a));

//        int a =5;
//        System.out.println(multiply3andhalf(a));

//        int a = 1;
//        System.out.println(powerof4(a));

//        int b=-4;
//        System.out.println(getAbsolute(b));

//        int[]  a = {1,2,1,2,3,4,3,5};
//        repeatedElement(a);

//        int p =5;
//        System.out.println("numbsr just bigger and 2's power is: " +justBigger2power(p));
//        int n = -9;
//        System.out.println(Integer.toBinaryString(n));
//        System.out.println(Integer.toBinaryString(n>>1));
//        System.out.println(Integer.toBinaryString(n>>2));
//        System.out.println(Integer.toBinaryString(n>>3));
//        System.out.println(Integer.toBinaryString(n>>4));

//        int num =32;
//        System.out.println(multipleOf3(num));

        int n= 33;
        System.out.println(parityFinder(n));


    }

    public static boolean parityFinder(int n){
        boolean parity = false;
        while(n != 0){
            n = n & (n-1);
            parity = !parity;
        }
        return parity;
    }

    public static boolean multipleOf3(int n){
        int counte =0, counto=0;
        while(n != 0){

            if((n & 1) ==1 )
                counto++;
                n = n>>1;

            if((n & 1) ==1 )
                counte++;
                n = n>>1;


        }
        System.out.println("o: "+counto+ "  e: "+ counte);
        if(counte-counto % 3 ==0)
            return true;
        else
            return false;
    }

    public static int  getAbsolute(int n){
        int mask = n>>31;
        return (n+mask)^mask;
    }

    //find non-repeated element
    public static void repeatedElement(int[] arr){
        int xor = 0;
        int x =0, y=0;
        for(int i =0; i<arr.length; i++){
            xor = xor^arr[i];
        }
        int right_most_set = xor & ~(xor-1);
        //now devide the whole array in two sets

        for(int i =0; i<arr.length; i++){
            if((right_most_set & arr[i])==0){
                x = x^ arr[i];
            }else{
                y = y ^ arr[i];
            }
        }
        System.out.println("first: "+x+ " second: "+ y);

    }





    //check if it has one 1 set bit,
    //number of zeros after set bit is even
    public static boolean powerof4(int n){
        int count =0;
        if((n&(n-1))==0){
            while(n != 1){
                n = n>>1;
                count++;
            }
        }
        System.out.println(count);
        return count != 0 && count%2==0 ? true:false;
    }


    public static double multiply3andhalf (int a){
        return (a<<1) + (a )+ (a>>1);
    }


    public static int addOne(int a){
        return -(~a);
    }


    public static int min(int a, int b){
        return b  + ((a-b) & ((a-b )>>31));
    }


    //adding two numbers without using arithmetic operators
    public static int addNums(int a , int b) {
        while(b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return  a;
    }

    public static int countAllSetsUntill(int n){
        int count = 0;
        for(int i =0; i<=n; i++){
            count = count+ countSetbits(i);
        }
        return count;
    }

    public static int countSetbits(int a){
        int count=0;
        while(a != 0){
            a = a&(a-1);
            count++;
        }
        return count;
    }


    //take xor of both numbers, if they both are positive msb for both are same(0),
    //both -ve msbs are again same(1), xor will give 0; if different xor produces 1.
    public static boolean oppositeSign(int a, int b){
        return (a^b)<0;
    }

    public static int justBigger2power(int n){
        if(n==0){
           return n;
        }
         int p =1;
        while(p<n){
            p=p<<1;
        }
        return p;
    }


    public static int findElement(int[] a){
        int element =0;
        for(int i=0; i<a.length; i++){
            element = element^ a[i];
        }
        return element;
    }
}
