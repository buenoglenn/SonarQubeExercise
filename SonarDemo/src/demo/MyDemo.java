package demo;

public class MyDemo {

	public static void main(String[] args) {
		Phone phone = new MyDemo().new Phone("Glenn", 911111);
		phone.setOwner("Glenn Bueno");
		phone.check();
	}
	
	class Phone implements IPhone {
		private String owner;
		private int number;
		
		public Phone(String owner, int number) {
			this.owner = owner;
			this.number = number;
		}

		String getOwner() {
			return owner;
		}

		void setOwner(String owner) {
			this.owner = owner;
		}

		int getNumber() {
			return number;
		}

		void setNumber(int number) {
			this.number = number;
		}

		@Override
		public void check() {
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append(this.owner).append(" is using ")
			.append(this.number);
			System.out.println(strBuilder.toString());
		}
	}
	
	@FunctionalInterface
	public interface IPhone {
		public void check();
	}
}
