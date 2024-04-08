package Annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AnnotationProcessor {
    public static final Map<String, Object> map = new HashMap<>();

    public AnnotationProcessor() {
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        inspectMyFirstAnnotation(AnnotatedClass.class);
//        inspectMyFirstAnnotation(NotAnnotatedClass.class);
//        inspectMyFirstAnnotation(String.class);
//
//        getAnnotatedMethods(AnnotatedClass.class);
//        getAnnotatedMethods(NotAnnotatedClass.class);

        loadAnnotated("Reflection.Employee");
        loadAnnotated("Annotation.AnnotatedClass");
        loadAnnotated("Annotation.NotAnnotatedClass");
        System.out.println(map);


    }

    static void inspectMyFirstAnnotation(Class<?> someClass) {
        if (someClass.isAnnotationPresent(MyFirstAnnotation.class)) {
            MyFirstAnnotation ann = someClass.getAnnotation(MyFirstAnnotation.class);
            System.out.println("Class \"" + someClass.getName() + "\" is annotated: " + ann.author() + " " + ann.date());
        } else {
            System.out.println("Class \"" + someClass.getName() + "\" is not annotated");
        }
    }

    public static void getAnnotatedMethods(Class<?> someClass) {
        Method[] methods = someClass.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(AnnotationForMethod.class)) {
                System.out.println("This annotation is found in this method: " + methods[i].getName());
            } else {
                System.out.println("This annotation is not found in this method: " + methods[i].getName());
            }
        }
    }

    public static void loadAnnotated(String className) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(className);
        if (clazz.isAnnotationPresent(MyFirstAnnotation.class)) {
            Object o = clazz.getConstructor().newInstance();
            map.put("MyFirstAnnotation " + o.getClass(), o);
        }
    }
}

