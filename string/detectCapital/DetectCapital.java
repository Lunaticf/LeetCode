package leetCode.string.detectCapital;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {

        if (word.toUpperCase().equals(word)) {
            return true;
        }

        return word.substring(1).toLowerCase().equals(word.substring(1));
    }
}
