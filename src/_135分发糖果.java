public class _135分发糖果 {
    public int candy(int[] ratings) {
        int len=ratings.length;
        int []cdy=new int[len];
        int count=0;
        for (int i = 0; i <len ; i++) {
            cdy[i]=1;
        }
        for (int i = 1; i <len ; i++) {
            if (ratings[i]> ratings[i-1]) {
                cdy[i]=cdy[i-1]+1;

            }
        }
        for (int i = len-1; i >0 ; i--) {
            if (ratings[i-1]> ratings[i]&&cdy[i-1]<=cdy[i]) {
                cdy[i-1]=cdy[i]+1;
            }
        }
        for (int i = 0; i <len ; i++) { ;
            count+=cdy[i];
            System.out.println(cdy[i]);
        }
        return count;
    }
}
