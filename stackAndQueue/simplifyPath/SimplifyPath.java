package leetCode.stackAndQueue.simplifyPath;

import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> s = new LinkedList<>();
        HashSet<String> skip = new HashSet<>(Arrays.asList(".", "..", ""));

        for (String dir : path.split("/")) {
            // 如果是.. 返回上层目录
            if (dir.equals("..") && !s.isEmpty()) {
                s.pop();
            } else if (!skip.contains(dir)) s.push(dir);
        }

        String res = "";
        for (String dir : s) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }
}
