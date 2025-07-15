package oop_ex11;

import java.lang.reflect.Field;

public class ReflectionPractice {
	public static void makeNotNullFields(Object object) throws IllegalAccessException {
		for (Field field : object.getClass().getDeclaredFields()) {
			Class<?> type = field.getType();
			field.setAccessible(true);
			if (field.get(object) != null) {
				continue;
			}
			if (type.equals(String.class)) {
				field.set(object, "");
			} else if (type.equals(Integer.class)) {
				field.set(object, 0);
			}
			switch (field.getType().getSimpleName()) {
				case "String":
					field.set(object, "");
				case "Boolean":
					field.set(object, false);
				case "Double":
					field.set(object, 0.0);
				case "Long":
					field.set(object, 0L);
			}
		}

	}

	public static void main(String[] args) {
		Reflection reflection = new Reflection();
		System.out.println(reflection);
		try {
			makeNotNullFields(reflection);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		System.out.println(reflection);
	}
}