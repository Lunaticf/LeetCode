package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Lunaticf
 * @Date 2019/10/30
 */
public class Main {
    public static void main(String[] args) {
        Map map = new HashMap();
        for (int i = 0; i < 128; i++) {
            map.put(i, new byte[1024*1024]);
        }
    }
}
