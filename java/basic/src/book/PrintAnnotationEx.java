package book;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrintAnnotationEx {
	public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
		Method[] declaredMethods = Service.class.getDeclaredMethods();
		for (Method m : declaredMethods) {
			PrintAnnotation printAnnotation = m.getAnnotation(PrintAnnotation.class);
			printLine(printAnnotation);
			m.invoke(new Service());
			printLine(printAnnotation);
		}
	}

	private static void printLine(PrintAnnotation pa) {
		System.out.println(pa.value().repeat(pa.number()));
	}
}