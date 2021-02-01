/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        
        for (Employee employee: employees) {
            map.put(employee.id, employee);
        }
        
        Queue<Employee> q = new LinkedList<>();
        q.add(map.get(id));
        int importanceValue = map.get(id).importance;
        while(!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Employee currentEmployee = q.poll();
                for (Integer subordinatesId: currentEmployee.subordinates) {
                   importanceValue += map.get(subordinatesId).importance;
                   q.add(map.get(subordinatesId));
                }
            }
        }
        return importanceValue;
    }
}
