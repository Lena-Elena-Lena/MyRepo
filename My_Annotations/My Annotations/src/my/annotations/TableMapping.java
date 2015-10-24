package my.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.TYPE)
@Inherited
@Retention(value=RetentionPolicy.RUNTIME)
public @interface TableMapping {
	String tableName();
}
