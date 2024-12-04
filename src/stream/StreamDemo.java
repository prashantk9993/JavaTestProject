package stream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {

        System.out.println();
        Project project = new Project();
        project.setId(101);
        project.setName("Test Project");

        Project project2 = new Project();
        project2.setId(102);
        project2.setName("Test Project 2");

        List listOfProject = new ArrayList<>();
        listOfProject.add(project);
        listOfProject.add(project2);

        Employee4 employee = new Employee4();
        employee.setId(101);
        employee.setName("Prashant");
        employee.setProjects(listOfProject);

        List<Employee4> emp = new ArrayList<>();
        emp.add(employee);
        System.out.println(emp.stream().filter(em -> em.getId() == 101).map(e -> e.getProjects()).collect(Collectors.toList()));


        //      System.out.println(emp.stream().filter(em-> em.getId()==101).map(e-> e.getProjects()));

        //    List<List<Project>> lst = emp.stream().filter(em-> em.getId()==101).map(e-> e.getProjects()).toList();


        emp.stream().filter(em -> em.getId() == 101)
                .collect(Collectors.toList())
                .get(0).getProjects().stream().map(m->m.getName()).forEach(System.out::println);


    }
}

class Employee4 {
    private int id;
    private String name;
    private int salary;
    private List<Project> projects;

    
    public Employee4() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}

class Project {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}