import java.util.Arrays;

public class _204计数质数 {
    public int countPrimes(int n) {
        boolean []isPrime=new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i*i<n  ; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <n ; j=i+j) {
                    isPrime[j]=false;
                }
            }
        }
        int count=0;
        for (int i = 2; i <n ; i++) {
            if (isPrime[i]) {
                count ++;
            }
        }
        return count;
    }
}
