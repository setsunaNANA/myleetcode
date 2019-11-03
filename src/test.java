import jdk.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.Scanner;
//合并分支
public class test {
    public static void main(String[] args) {
        int[] b = new int[10];
        b[0] = 1;
        System.out.println(b.length);
        Scanner input = new Scanner(System.in);
        int len = input.nextInt();
        int[] v = new int[len];
        for (int i = 0; i < len; i++) {
            v[i] = input.nextInt();
        }
        ArrayList<Integer> a = new ArrayList();
        input.close();
        int count = 0;
        int temp = v[0];
        for (int i = 0, j = len - 1; i < j; i++) {
            if (count == 0) {
                temp = v[i];
                count++;
                continue;
            }
            if (v[i] == temp) {
                count++;
            } else {
                count--;
            }
        }
        System.out.println(temp);
    }
}
