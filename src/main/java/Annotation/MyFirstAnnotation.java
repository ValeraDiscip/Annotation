package Annotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyFirstAnnotation {
    String author() default "Valera";

    String date();
}
