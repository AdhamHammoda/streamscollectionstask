import java.util.*;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Employee> list=new ArrayList<Employee>();
        list.add(new Employee("0001","Adham","Software Engineering",200.0));
        list.add(new Employee("0002","Ahmed","Software Engineering",350.0));
        list.add(new Employee("0003","Abdallah","Software Engineering",240.0));
        list.add(new Employee("0004","Hammoda","Software Engineering",210.0));
        list.add(new Employee("0005","Mohammad","Software Engineering",760.0));
        list.add(new Employee("0006","Gamal","Data Analysis",238.0));
        list.add(new Employee("0007","Karim","Data Analysis",310.0));
        list.add(new Employee("0008","Mahmoud","Data Analysis",370.0));
        list.add(new Employee("0009","Hassan","Data Analysis",320.0));
        EmployeeProcessor employeeProcessor= new EmployeeProcessor();
        double sum=employeeProcessor.getSalarySum(list);
        List<String>employeesNames=employeeProcessor.getEmployeesNames(list);
        List<Employee>employeesListByDepartment=employeeProcessor.getEmployeesDepartment(list,"Software Engineering");
        List<Employee>employeesListBySalary=employeeProcessor.getIncrementedEmployeesSalaries(list,20.0);


    }
    
}
class Employee
{
    private String id;
    private String name;
    private String department;
    private double salary;

    public Employee(String id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}

class EmployeeProcessor
{
    List<Employee> getEmployeesDepartment(List<Employee> employees,String department)
    {

        List<Employee> list = employees.stream().
                filter(employee -> employee.getDepartment().equals(department))
                .collect(Collectors.toList());
        return list;
    }
    List<String > getEmployeesNames(List<Employee> employees)
    {
        List<String> list = employees.stream().
                map(Employee::getName)
                .collect(Collectors.toList());
        return list;
    }
    double getSalarySum(List<Employee> employees)
    {
        double salarySum =
                employees.stream().
                        map(Employee::getSalary).mapToDouble(Double::doubleValue).sum();
        return salarySum;
    }
    List<Employee> getIncrementedEmployeesSalaries(List<Employee> employees,double incrementPercentage)
    {
        List<Employee> list = employees.stream().
                peek(employee->employee.
                        setSalary(employee.getSalary()+incrementPercentage/100.0*employee.getSalary()))
                .collect(Collectors.toList());
        return list;
    }

}