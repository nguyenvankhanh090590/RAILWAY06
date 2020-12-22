package entity.Ex3;

public class Car {
	@Override
	public String toString() {
		return "Car [name=" + name + ", type=" + type +  engine.toString() + "]";
	}



	String name;
	String type;
	public Engine engine;
	
	
	
	public Car(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}



	public class Engine{
		@Override
		public String toString() {
			return " [engineType=" + engineType + "]";
		}

		public String getEngineType() {
			return engineType;
		}

		public void setEngineType(String engineType) {
			this.engineType = engineType;
		}

		private String engineType;

		public Engine(String engineType) {
			super();
			this.engineType = engineType;
		}
		
		
	}
}
