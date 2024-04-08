package Annotation;

public class NotAnnotatedClass {
    public void sayHello() {
        System.out.println("Hello!");
    }

    @AnnotationForMethod(date = "01.04.2024", description = "that is the example of finding annotated methods.")
    public void sayByeBye() {
        System.out.println("bye bye");
    }

    @Override
    public String toString() {
        return "NotAnnotatedClass{}";
    }
}
