public class _223矩形面积 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (A < E) {
            return computeArea(E, F, G, H,A , B, C, D);
        }
        int x1=Math.max(A, E);
        int y1=Math.max(B, F);
        int x2=Math.min(C, G);
        int y2=Math.min(D, H);
        int S3;
        S3=(x2-x1)*(y2-y1);
        if (x1 >= x2||y1>=y2) {
            S3=0;
        }

        int S1=(C-A)*(D-B);
        int S2=(G-E)*(H-F);
        return (S1+S2-S3);
    }
}
