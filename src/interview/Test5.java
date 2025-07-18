package interview;


import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Test5 {

    public static void main(String[] args) {
        List<Department> departments = List.of(
                new Department(10, "IT"),
                new Department(20, "HR")
        );

        List<Employee6> employees = List.of(
                new Employee6(3, "David",10),
                new Employee6(1, "Peter",10),
                new Employee6(5, "Bob",10),
                new Employee6(7, "Mark",20),
                new Employee6(4, "Frank",20)
        );

      String deptName =   departments.stream().filter(x-> {
                Stream<Employee6> emps = employees.stream().filter(y->y.getEmpID()==7);
            Optional<Employee6> obj =  emps.findFirst();
            return obj.get().getEmpID()==x.getDeptId();
        }).findFirst().get().getDepartmentName();

      System.out.println(deptName);



      //  dept name of emp id 7

       //departments.stream().anyMatch(x-> x.getDepartmentName().equalsIgnoreCase(employees.stream().filter(x->x.getEmpID()==7)));

       Stream<Employee6> emps = employees.stream().filter(x->x.getEmpID()==7);

      Optional<Employee6> obj =  emps.findFirst();

      System.out.println(obj.get().getEmployeeName());

        /*for (Employee6 emp : employees){
            if(emp.getEmpID()==7){
                for (Department d : departments){
                   if (d.getDeptId()==emp.getDepartmentId()){
                       System.out.println(d.getDepartmentName());
                       break;
                    }
                }
            }
        }*/
    }
}

class Department{
    private  int deptId;
    private  String departmentName;

    public Department(int deptId, String departmentName) {
        this.deptId = deptId;
        this.departmentName = departmentName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}


class Employee6{

    public Employee6(){

    }

    private  int  empID;
    private  String   employeeName;
    private int  departmentId;

    public Employee6(int empID, String employeeName, int departmentId) {
        this.empID = empID;
        this.employeeName = employeeName;
        this.departmentId = departmentId;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
