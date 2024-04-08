package Reflection;

import Annotation.MyFirstAnnotation;

@MyFirstAnnotation(date = "01.04.2024")
public class Employee {

    public String name;
    public String family;
    public String department;
    private int salary;

    public Employee() {
        super();
    }

    public Employee(String name, String family, String department) {
        this.name = name;
        this.family = family;
        this.department = department;
    }

    public Employee(String name, String family, String department, int salary) {
        this.name = name;
        this.family = family;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(int newSalary) throws Exception {
        this.salary = newSalary;
    }

    public int getSalary() {
        return salary;
    }

    public void increaseSalary() {
        salary *= 2;
    }

    public void changeDepartment(String newDepartment) {
        this.department = newDepartment;
        System.out.println("New department is: " + department);
    }

    private void imPrivateMethod() {
        System.out.println("I'm private");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
