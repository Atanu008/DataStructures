package org.atanu.java.ds.math;

//Trial Division Method
//Video :https://www.youtube.com/watch?v=7VPA-HjjUmU&list=PL2_aWCzGMAwLL-mEB4ef20f3iqWMGWa25&index=3
public class PrimeNumber {

    public static boolean isPrime(int n){

        if(n <= 1){
            return false;
        }
        //Loop till sqrt of N. as one factor has to be less than equal to square root of N
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int N = 26;
        for (int i = 0; i < N; i++){
            System.out.println(i+ " is Prime "+ isPrime(i));
        }
    }
}
