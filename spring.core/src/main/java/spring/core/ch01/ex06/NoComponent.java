package spring.core.ch01.ex06;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //annotation location
@Retention(RetentionPolicy.RUNTIME) // annotation scope
public @interface NoComponent {

}
