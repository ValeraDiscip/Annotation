package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ex2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> employeeClass = Class.forName("Reflection.Employee");

        Constructor<?> constructor1 = employeeClass.getConstructor();
        Employee obj1 = (Employee) constructor1.newInstance();

        Constructor<?> constructor2 = employeeClass.getConstructor(String.class, String.class, String.class);
        Object obj2 = constructor2.newInstance("Valera", "Kurasov", "IT");
        System.out.println(obj2);

        Method method = employeeClass.getMethod("setSalary", int.class);
        method.invoke(obj2, 150000);
        System.out.println(obj2);
    }
}
