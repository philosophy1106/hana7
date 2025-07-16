package oop_ex11;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Reflection extends Parent {
	@Min(value = 3, msg = "3글자 이상 입력하세요!")
	@In({"Hong", "Kim", "Lee", "Choi"})
	private String name;

	@NotNull()
	@Min(value = 5, msg = "5보다는 커야합니다!")
	@Max(value = 10, msg = "10보다 작아야합니다!")
	private Integer deptId;

	@NotNull("필수 값이에요")
	@Min(3)
	@Max(15)
	private Double address;
	private Boolean isGuest;

	public static List<String> validate(Object obj) throws IllegalAccessException {
		List<String> msg = new ArrayList<>();
		Class<?> clazz = obj.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			Object value = field.get(obj);
			String name = field.getName();

			if (field.isAnnotationPresent(NotNull.class)) {
				if (value == null) {
					msg.add(name + "::" + field.getAnnotation(NotNull.class).value());
				}
			}
			//Min/Max 동시에 처리할 순 없을까 -> 함수 분리
			double num = asNumber(value);

			if (field.isAnnotationPresent(Min.class)) {
				Min min = field.getAnnotation(Min.class);
				if (num < min.value()) {
					msg.add(name + "::" + getMessage(min.msg(), "At least " + min.value()));
				}
			}

			if (field.isAnnotationPresent(Max.class)) {
				Max max = field.getAnnotation(Max.class);
				if (num > max.value()) {
					msg.add(name + "::" + getMessage(max.msg(), "Not over " + max.value()));
				}
			}

			if (field.isAnnotationPresent(In.class)) {
				In in = field.getAnnotation(In.class);
				String[] strings = in.value();

				if (value instanceof String) {
					if (!Arrays.asList(strings).contains((String)value)) {
						msg.add(
							name + "::" + in.msg() + Arrays.toString(field.getAnnotation(In.class).value()));
					}
				}

			}

		}

		return msg;
	}

	//MAX/,MIN 문자열이면 길이로, 숫자는 그대로
	private static double asNumber(Object value) {
		switch (value) {
			case null -> {
				return 0;
			}
			case String s -> {
				return s.length();
			}
			case Number i -> {
				return ((Number)value).doubleValue();
			}
			default -> {
				return -1;
			}
		}
	}

	private static String getMessage(String defaultMessage, String message) {
		return defaultMessage.isBlank() ? message : defaultMessage;
	}

	public Reflection(int id, String name) {
		super(id);
		this.name = name;
	}

	public Reflection(int id, String name, Integer deptId, Double address, Boolean isGuest) {
		super(id);
		this.name = name;
		this.deptId = deptId;
		this.address = address;
	}

	public static void main(String[] args) throws IllegalAccessException {
		Reflection ref = new Reflection(123, "Ho", 2, 34.0, true);
		List<String> messages = Reflection.validate(ref);
		System.out.println(messages);
	}
}

@AllArgsConstructor
@NoArgsConstructor
@ToString
class Parent {
	private int id;
}