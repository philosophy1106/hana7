package oop_ex11;

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
	private String name;

	@Min(value = 5, msg = "5보다는 커야합니다!")
	@Max(value = 10, msg = "10보다 작아야합니다!")
	private String deptId;

	@NotNull
	@Max(15)
	private Double address;
	private Boolean isGuest;

	public static void validate(Object obj) {

	}

	public Reflection(int id, String name) {
		super(id);
		this.name = name;
	}

	public static void main(String[] args) {
		Reflection r = new Reflection();
		System.out.println("r-before = " + r);
		Reflects.makeNotNullFields(r);
		System.out.println("r-after = " + r);
	}
}

@AllArgsConstructor
@NoArgsConstructor
@ToString
class Parent {
	private int id;
}