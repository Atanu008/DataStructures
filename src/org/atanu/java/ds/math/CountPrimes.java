package org.atanu.java.ds.math;

//Finding Prime numbers - Sieve of Eratosthenes
//https://leetcode.com/problems/count-primes/
//LeetCode 204
//Video : https://www.youtube.com/watch?v=eKp56OLhoQs&list=PL2_aWCzGMAwLL-mEB4ef20f3iqWMGWa25&index=5
public class CountPrimes {
    //This solution is till Nth
    // while counting we will count less tahn N thats it
    // Otherwiese we could have tamen arr ay size N only for strict less
    public int countPrimes(int n) {
        if(n <= 1){
            return 0;
        }

        boolean[] numbers = new boolean[n+1];
        for(int i = 2; i <=(int)Math.sqrt(n); i++){
            if(numbers[i] == false){
                for(int j = 2; i*j <= n; j++){
                    numbers[i*j] = true;
                }
            }
        }

        int numberOfPrimes = 0;
        for(int i = 2; i < n; i++){
            if(numbers[i] == false){
                numberOfPrimes++;
            }
        }

        return numberOfPrimes;
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        int N = 10;
        System.out.println("Prime Numbers less than "+N +" is "+countPrimes.countPrimes(N));
    }
}
