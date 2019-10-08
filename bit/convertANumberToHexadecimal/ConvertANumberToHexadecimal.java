package leetCode.bit.convertANumberToHexadecimal;

public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        String binary = Integer.toBinaryString(num);

        if (binary.length() % 4 != 0) {
            binary = addPadding(binary);
        }


        // 转化成Hex
        String res = "";
        for (int i = 0; i < binary.length(); i+=4) {
            int temp = Integer.valueOf(binary.substring(i, i+4), 2);

            if (temp < 10) {
                res += String.valueOf(temp);
            } else {
                res += Character.toString((char)(temp - 10 + 'a'));
            }
        }
        return res;
    }

    private String addPadding(String s) {
        int zeros = 4 - s.length() % 4;
        for (int i = 0; i < zeros; i++) {
            s = "0" + s;
        }
        return s;
    }


    public String toHex1(int num) {
        if (num == 0) return "0";
        // 位操作
        // 每次向右移四位
        StringBuilder s = new StringBuilder();
        while (num != 0) {
            int temp = num & 0xf;
            if (temp < 10) {
                s.append((char)(temp + '0'));
            } else {
                s.append((char)(temp - 10 + 'a'));
            }
            num >>>= 4;
        }
        return s.reverse().toString();
    }
}
