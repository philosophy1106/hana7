package book;
// 어노테이션 정의

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 어노테이션이 런타임까지 살아있어서 리플렉션을 통해 접근할 수 있도록 함
@Target(ElementType.TYPE) // 클래스, 인터페이스, enum 등 타입선언부에만 사용할 수 있음
@interface Book { //커스텀 어노테이션을 정의
	String title();

	String author();
}