package leetCode.string.addStrings;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        // 就是模拟啦
        StringBuilder s = new StringBuilder();

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();


        int carry = 0;
        int i = 0;
        for (; i < num1.length() && i < num2.length(); i++) {
            int res = (num1.charAt(i) - '0') + (num2.charAt(i) - '0') + carry;
            carry = helper(s, res);
        }

        // 处理较长的字符串
        while (i < num1.length()) {
            int res = (num1.charAt(i) - '0') + carry;
            carry = helper(s, res);
            i++;
        }

        while (i < num2.length()) {
            int res = (num2.charAt(i) - '0') + carry;
            carry = helper(s, res);
            i++;
        }

        if (carry == 1) {
            s.append('1');
        }
        return s.reverse().toString();

    }


    private int helper(StringBuilder s, int num) {
        if (num >= 10) {
            s.append(num - 10);
            return 1;
        }
        s.append(num);
        return 0;
    }


    public String addStrings1(String num1, String num2) {
        StringBuilder s = new StringBuilder();
        int carry = 0;
        // 从后往前
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int b1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            carry = (b1 + b2 + carry) / 10;
            s.append((b1 + b2 + carry) % 10);
        }

        return s.reverse().toString();
    }
}
