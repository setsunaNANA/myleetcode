public class _65有效数字 {
    public boolean isNumber(String s) {
        int loce=0;
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i) =='e') {

            }
        }
    }
    boolean isPositiveInteger(String s){
        if (s.length() == 0) {
            return false;
        }
        for (int i = 0; i <s.length() ; i++) {
            if (!(s.charAt(i)-'0'>0&&s.charAt(i)-'0'<=9)) {
                return false;
            }
        }
        return true;
    }
    boolean isInteger(String s){
        if (s.charAt(0) == '-'||s.charAt(0) == '+') {
            return isPositiveInteger(s.substring(1));
        }
        else return isPositiveInteger(s);
    }

    boolean isPositiveFloat(String s){
        if (s.length() < 3||!(s.charAt(0)-'0'>0&&s.charAt(0)-'0'<=9)||s.charAt(1)!='.') {
            return false;
        }
        return isInteger(s.substring(2));
    }
    boolean isFloat(String s){
        if (s.charAt(0) == '-'||s.charAt(0) == '+') {
            return isPositiveFloat(s.substring(1));
        }
        else return isPositiveFloat(s);
    }
}
