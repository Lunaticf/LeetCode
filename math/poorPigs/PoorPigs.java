package leetCode.math.poorPigs;

public class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int onePigTest = minutesToTest/minutesToDie + 1;
        return (int)Math.ceil(Math.log(buckets)/Math.log(onePigTest));
    }
}
