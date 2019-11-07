package leetCode.string;

/**
 * @Author Lunaticf
 * @Date 2019/11/1
 */
public class GoatLatin {
    public String toGoatLatin(String S) {
        // 如果一个单词是元音开头 单词末尾追加ma
        // 如果单词不以元音开头，把第一个字符调到最后，再追加ma
        // 第一个单词追加a 第二个单词追加aa
        String[] words = S.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            StringBuilder s = new StringBuilder();
            char c = Character.toLowerCase(words[i].charAt(0));
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                s.append(words[i].substring(1));
                s.append(words[i], 0, 1);
            } else {
                s.append(words[i]);
            }

            s.append("ma");

            for (int j = 0; j < i + 1; j++) {
                s.append("a");
            }

            words[i] = s.toString();
        }
        return String.join(" ", words);
    }
}
