package LeetCode.string.addBinary;

public class AddBinary {

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        s.append(1);
        System.out.println(s);
    }

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int aNum = i < 0 ? 0 : a.charAt(i) - '0';
            int bNum = j < 0 ? 0 : b.charAt(j) - '0';
            res.append((aNum + bNum + carry) % 2);
            carry = (aNum + bNum + carry) / 2;
        }
        return res.reverse().toString();
    }
}
