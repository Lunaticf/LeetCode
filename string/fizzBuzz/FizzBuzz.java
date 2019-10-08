package leetCode.string.fizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        // 3的倍数Fizz
        // 5的倍数Buzz
        // both FizzBuzz
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            }
            else if (i % 3 == 0) {
                res.add("Fizz");
            }
            else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

    // string concat
    public List<String> fizzBuzz1(int n) {
        // 3的倍数Fizz
        // 5的倍数Buzz
        // both FizzBuzz
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String s = "";

            if (i % 3 == 0) {
                s += "Fizz";
            }
            if (i % 5 == 0) {
                s += "Buzz";
            }

            if ("".equals(s)) {
                s += Integer.toString(i);
            }

            res.add(s);

        }
        return res;
    }

    // best
    // not use %
    public List<String> fizzBuzz2(int n) {
        List<String> ret = new ArrayList<String>(n);
        for(int i=1,fizz=0,buzz=0;i<=n ;i++){
            fizz++;
            buzz++;
            if(fizz==3 && buzz==5){
                ret.add("FizzBuzz");
                fizz=0;
                buzz=0;
            }else if(fizz==3){
                ret.add("Fizz");
                fizz=0;
            }else if(buzz==5){
                ret.add("Buzz");
                buzz=0;
            }else{
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }
}
