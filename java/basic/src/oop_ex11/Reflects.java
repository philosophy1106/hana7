package oop_ex11;

import java.lang.reflect.Field;

public class Reflects {
	public static void makeNotNullFields(Object obj) {
		for (Field f : obj.getClass().getDeclaredFields()) {
			try {
				f.setAccessible(true);
				if (f.get(obj) != null)
					continue;

				switch (f.getType().getSimpleName()) {
					case "String" -> f.set(obj, "");
					case "Boolean" -> f.set(obj, false);
					case "Long" -> f.set(obj, 0L);
					case "Double" -> f.set(obj, 0.0);
					default -> f.set(obj, 0);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace(System.out);
			}
		}
	}
}