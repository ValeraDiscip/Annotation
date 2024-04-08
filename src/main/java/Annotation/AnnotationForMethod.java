package Annotation;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AnnotationForMethod {
    String author() default "Valera";

    String date();

    String description();

}
