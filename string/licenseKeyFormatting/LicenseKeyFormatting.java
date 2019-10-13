package leetCode.string.licenseKeyFormatting;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        int count = 0;
        StringBuilder res = new StringBuilder();
        S = S.replace("-", "");
        for (int i = S.length() - 1; i >= 0; i--) {

            res.append(S.charAt(i));
            count++;
            if (count % K == 0 && i != 0) {
                res.append("-");
            }
        }
        return res.reverse().toString().toUpperCase();
    }
}

