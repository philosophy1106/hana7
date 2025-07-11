package OOP_Ex8;

public class ArrayedGeneralBook implements GeneralBook {
	private String[] name;
	private String[] records;

	ArrayedGeneralBook(String[] name, String[] records) {
		this.name = name;
		this.records = records;
	}

	@Override
	public int size(String[] names) {
		for (String s : names) {
			System.out.println(s);
		}
		return this.name.length;
	}

	@Override
	public String names() {
		StringBuilder sb = new StringBuilder();
		for (String name : this.name) {
			sb.append(" ");
			sb.append(name);
		}
		return sb.toString();
	}

	@Override
	public String records() {
		StringBuilder sb = new StringBuilder();
		for (String record : this.records) {
			sb.append(record);
			sb.append(" ");
		}
		return sb.toString();
	}

	@Override
	public boolean nameExists(String name) {
		for (String n : this.name) {
			return n.equals(name);
		}
		return false;
	}

	@Override
	public void add(String name, String record) {
		//주어진 이름이 존재하는 경우
		if (this.nameExists(name)) {
			System.out.printf("%s 이름이 이미 존재합니다", name);
			return;
		}
		//배열이 꽉 차 있는 경우 새 배열 생성 -> 복사
		if (this.name[this.name.length - 1] != null) {
			int newNameCapacity = this.name.length + this.name.length / 2;
			int newRecordCapacity = this.records.length + this.records.length / 2;
			String[] newNames = new String[newNameCapacity];
			String[] newRecords = new String[newRecordCapacity];

			for (int i = 0; i < this.name.length; i++) {
				newNames[i] = this.name[i];
				newRecords[i] = this.records[i];
			}
			newNames[this.name.length] = name;
			newRecords[this.name.length] = record;
			this.name = newNames;
			this.records = newRecords;

		} else {
			for (int i = 0; i < this.name.length; i++) {
				//빈자리에 이름 넣어주기~
				if (this.name[i] == null) {
					this.name[i] = name;
					this.records[i] = record;
				}
			}
		}
	}

	@SuppressWarnings("checkstyle:WhitespaceAround")
	@Override
	public void remove(String name, String record) {
		if (name == null) {
			System.out.println("삭제 불가");
			return;
		}
		for (int i = 0; i < this.name.length; i++) {
			if (this.name[i] == null) {
				break;
			}
			if (this.name[i].equals(name)) {
				if (i == this.name.length - 1) {
					this.name[i] = null; //맨 뒤니까 그냥 null 처리
					this.records[i] = null;
					break;
				}
				for (int j = i; j < this.name.length; j++) {
					if (this.name[j] == null || j + 1 >= this.name.length) {
						break;
					}
					this.name[j] = this.name[j + 1]; //뒤에 있는 것 땡겨오기...
					this.records[j] = this.records[j + 1];
				}
			}
		}

	}

	@Override
	public String get(String name) {
		for (int i = 0; i < this.name.length; i++) {
			if (this.name[i].equals(name)) {
				return this.records[i];
			}
		}
		System.out.println("이름이 존재하지 않습니다");
		return null;
	}

	@Override
	public void sort() {
		//버블 정렬로 구현
		for (int i = 0; i < this.name.length; i++) {
			for (int j = i + 1; j < this.name.length; j++) {
				if (name[i] == null || name[j] == null) {
					continue;
				}
				if (this.name[i].compareTo(this.name[j]) > 0) {
					String tmp1 = this.name[i];
					this.name[i] = this.name[j];
					this.name[j] = tmp1;

					String tmp2 = this.records[j];
					this.records[j] = this.records[i];
					this.records[i] = tmp2;
				}
			}
		}
	}

	@Override
	public void print() {
		sort(); //오름차순하기
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.name.length; i++) {
			if (this.name[i] == null) {
				break;
			}
			sb.append(name[i]);
			sb.append(records[i]);
			sb.append("\\n");
		}
		System.out.println(sb);
	}
}