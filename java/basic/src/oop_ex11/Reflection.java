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
	private String name;

	public Reflection(int id, String name) {
		super(id);
		this.name = name;
	}

	public static void main(String[] args) {

	}
}

@AllArgsConstructor
@NoArgsConstructor
@ToString
class Parent {
	private int id;
}