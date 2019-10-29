package leetCode.hashTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Lunaticf
 * @Date 2019/10/29
 */
public class EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List <Integer> subordinates;
    }

    /**
     * 可以用DFS 也可以用BFS 总之就是遍历所有啦
     * @param employees
     * @param id
     * @return
     */
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>(16);
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        return dfs(map, id);

    }

    private int dfs(Map<Integer, Employee> map,  int id) {
        Employee e = map.get(id);
        int res = e.importance;
        for (int sub : e.subordinates) {
            res += dfs(map, sub);
        }
        return res;
    }

}
