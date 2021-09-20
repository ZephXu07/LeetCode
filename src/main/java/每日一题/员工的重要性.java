package 每日一题;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: 员工的重要性
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-01
 */
public class 员工的重要性 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return getImp(map, id);
    }

    private int getImp(Map<Integer, Employee> map, int id) {
        Employee e = map.get(id);
        int imp = e.importance;
        for (int i : e.subordinates) {
            imp += getImp(map, i);
        }
        return imp;
    }

}
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
