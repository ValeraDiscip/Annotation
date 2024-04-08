package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Ex1 {
    //Рефлексия - это механизм исследования данных о программе во время ее выполнения
    //позволяет получать всю возможную мета информацию о классе
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        //есть 3 способа создания экземпляра класса Class. Я создаю его в данном примере с помощью статического метода "forName".
        Class<?> employeeClass = Class.forName("Reflection.Employee"); //выбрасывает ClassNotFoundException
        //Рассмотрим пример получения данных об одном поле и о всех полях
        Field someField = employeeClass.getField("name");
        System.out.println("The type of the field \"" + someField.getName() + "\" is: " + someField.getType());
        System.out.println("---------------------------------------------------------");
        Field[] allLocalFields = employeeClass.getDeclaredFields();
        for (Field field : allLocalFields) {
            System.out.println("The name of the field: " + field.getName());
            System.out.println("The type of the field: " + field.getType());
            int modifier = field.getModifiers();
            System.out.println("Access modifier of the field: " + Modifier.toString(modifier));
            System.out.println("---------------------------------------------------------");
            //Также можно получить значение поля, но только статического: field.get(field);
        }

        //Теперь рассмотрим пример получения методанных о методах класса (и об одном методе):
        Method someMethod = employeeClass.getMethod("setSalary", int.class);
        System.out.println("Return type of the method: " + someMethod.getReturnType()); // и тд
        Method[] allLocalMethods = employeeClass.getDeclaredMethods();
        for (Method method : allLocalMethods) {
            System.out.println("The name of the method: " + method.getName());
            System.out.println("Return type of the method: " + method.getReturnType());
            int modifier = method.getModifiers();
            System.out.println("Access modifier of the method: " + Modifier.toString(modifier));
            System.out.println("Parameter types of the method: ");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType.getName());
            }
            Class<?>[] thrownExceptions = method.getExceptionTypes();
            System.out.println("Exceptions thrown by method: ");
            for (Class<?> exception : thrownExceptions) {
                System.out.println(exception.getName() + " ");
            }
            System.out.println("---------------------------------------------------------");
        }

        //Также мы можем получить информацию только о публичных/приватных методах по желанию:
        for (Method method : allLocalMethods) {
            if (Modifier.isPublic(method.getModifiers())) { //Таким вот образом
                System.out.println("The name of the method: " + method.getName());
                System.out.println("Return type of the method: " + method.getReturnType());
                int modifier = method.getModifiers();
                System.out.println("Parameter types of the method: ");
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (Class<?> parameterType : parameterTypes) {
                    System.out.println(parameterType.getName());
                }
                System.out.println("---------------------------------------------------------");
            }
        }

        // Также мы можем получить информацию о конструкторе. Сначала покажу пример получения конкретного конструктора.
        Constructor<?> constructor1 = employeeClass.getConstructor();
        System.out.println("Constructor has " + constructor1.getParameterCount() + " parameters, their types are: " + Arrays.toString(constructor1.getParameterTypes()));
        System.out.println("---------------------------------------------------------");
        Constructor<?> constructor2 = employeeClass.getConstructor(String.class, String.class, String.class);
        System.out.println("Constructor has " + constructor2.getParameterCount() + " parameters, their types are: " + Arrays.toString(constructor2.getParameterTypes()));
        System.out.println("---------------------------------------------------------");
        //Теперь получим инфо обо всех конструкторах
        Constructor<?>[] allLocalConstructors = employeeClass.getDeclaredConstructors();
        for (Constructor<?> constructor : allLocalConstructors) {
            System.out.println("The name of the constructor: " + constructor.getName());
            System.out.println(constructor.getName() + " has " + constructor.getParameterCount() + " parameters");
            int modifier = constructor.getModifiers();
            System.out.println("Access modifiers: " + Modifier.toString(modifier));
            System.out.println("Parameter types: " + Arrays.toString(constructor.getParameterTypes()));
            System.out.println("---------------------------------------------------------");
        }
    }
}