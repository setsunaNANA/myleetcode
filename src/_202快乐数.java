public class _202快乐数 {
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        do {
            slow=cpu(slow);
            fast=cpu(fast);
            fast=cpu(fast);
        }while (fast!=slow);

        if (slow == 1) {
            return true;
        }
        else return false;
    }
     int cpu(int n){
        int sum=0;
        while (n!=0){
            int t=n%10;
            sum+=t*t;
            n/=10;
        }
        return sum;
     }
}
