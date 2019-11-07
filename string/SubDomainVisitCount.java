package leetCode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author Lunaticf
 * @Date 2019/10/31
 */
public class SubDomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            int spaceIdx = s.indexOf(' ');
            int count = Integer.valueOf(s.substring(0, spaceIdx));
            String domain = s.substring(spaceIdx + 1);

            String[] domains = domain.split("\\.");
            String temp = domains[domains.length - 1];
            map.put(temp, map.getOrDefault(temp, 0) + count);
            for (int i = domains.length - 2; i >= 0; i--) {
                temp = domains[i] + "." + temp;
                map.put(temp, map.getOrDefault(temp, 0) + count);
            }
        }


        for (String key : map.keySet()) {
            res.add(map.get(key) + " " + key);
        }

        return res;
    }
}
