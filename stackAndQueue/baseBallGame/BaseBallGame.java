package leetCode.stackAndQueue.baseBallGame;

import java.util.Stack;

public class BaseBallGame {
    public static void main(String[] args) {
        int a = new BaseBallGame().calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
        System.out.println(a);
    }
    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> valids = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            if ((ops[i].charAt(0) <= '9' && ops[i].charAt(0) >= '0') || ops[i].charAt(0) == '-') {
                int points = Integer.parseInt(ops[i]);
                sum += points;
                valids.push(points);
            } else {
                if (ops[i].equals("C")) {
                    sum -= valids.get(valids.size() - 1);
                    valids.pop();
                } else if (ops[i].equals("D")) {
                    int points = valids.get(valids.size() - 1) * 2;
                    sum += points;
                    valids.push(points);
                } else if (ops[i].equals("+")) {
                    int points = valids.get(valids.size() - 1) + valids.get(valids.size() - 2);
                    sum += points;
                    valids.push(points);
                }
            }
        }
        return sum;
    }
}
