package leetCode.string.validPalindrome;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = ".,";
        new ValidPalindrome().isPalindrome(s);
    }

    public boolean isPalindrome(String s) {
        if (s.equals("")) return true;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if(i > j) {return true;}
            if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
                return false;
            }
        }
        return true;
    }
}
