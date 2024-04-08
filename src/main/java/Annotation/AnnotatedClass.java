package Annotation;

@MyFirstAnnotation(date = "01.04.2024")
public class AnnotatedClass {
    @AnnotationForMethod(date = "01.03.2024", description = "my brain is burning, but i continue..")
    public void annotatedMethod() {
        System.out.println("I am annotated");
    }

    public void notAnnotatedMethod() {
        System.out.println("I am not annotated");
    }

    @Override
    public String toString() {
        return "AnnotatedClass{}";
    }
}
