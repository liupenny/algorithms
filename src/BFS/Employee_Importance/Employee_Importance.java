package BFS.Employee_Importance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PennyLiu on 2018/9/5.
 */

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}

public class Employee_Importance{
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) {
            return 0;
        }

        int score = 0;
        for (Employee employee: employees) {
            if (employee.id == id){
                List<Integer> sub = employee.subordinates;
                if(sub != null) {
                    for (Integer i : sub) {
                        score += getImportance(employees, i);
                    }
                }
                score += employee.importance;
            }
        }
        return score;
    }

    public static void main(String[] args)
    {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.id = 1;
        employee1.importance = 5;
        employee1.subordinates = Arrays.asList(2,3);
        Employee employee2 = new Employee();
        employee2.id = 2;
        employee2.importance = 3;
        employee2.subordinates = null;
        Employee employee3 = new Employee();
        employee3.id = 3;
        employee3.importance = 3;
        employee3.subordinates = null;
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        Employee_Importance a = new Employee_Importance();
        System.out.println(a.getImportance(employees,1));
    }
}