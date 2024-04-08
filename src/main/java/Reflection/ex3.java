package Reflection;

import java.lang.reflect.Field;

public class ex3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        //Reflection способен обходить принцип инкапсуляции:
        Employee employee = new Employee("Valera", "Kurasov", "IT");
        Class<?> employeeClass = employee.getClass();
        Field field = employeeClass.getDeclaredField("salary");
        field.setAccessible(true);
        int salaryValue = (Integer) field.get(employee);
        System.out.println(employee);
        field.set(employee, 100000);
        System.out.println(employee);
    }
}
