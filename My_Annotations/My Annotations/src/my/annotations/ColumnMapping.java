package my.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(value=ElementType.FIELD)
@Inherited
@Retention(value=RetentionPolicy.RUNTIME)
public @interface ColumnMapping {
	String columnName();
	EDataType dateType() default EDataType.STRING;
}
