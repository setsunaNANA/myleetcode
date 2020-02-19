public class _165比较版本号 {
    public int compareVersion(String version1, String version2) {
        String []v1=version1.split("\\.");
        String []v2=version2.split("\\.");
        int i=0;
        int j=0;
        while (i<v1.length||j<v2.length){
            int num1=i<v1.length?Integer.parseInt(v1[i]):0;
            int num2=j<v2.length?Integer.parseInt(v2[j]):0;
            if (num1 == num2) {
                i++;
                System.out.println();
                j++;
            }
            else if (num1 > num2) {
                return 1;
            }
            else return -1;
        }
        return 0;
    }
}
