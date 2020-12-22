package entity.Ex3;

public class CPU {
	

	@Override
	public String toString() {
		return "CPU [price=" + price + "]";
	}

	Float price;
	public Processor processor;
	public Ram ram;
	
	
	
	public CPU(Float price) {
		super();
		this.price = price;
	}

	public class Processor{
		@Override
		public String toString() {
			return "Processor [coreAmount=" + coreAmount + ", manufacturer=" + manufacturer + "]";
		}

		int coreAmount;
		String manufacturer;
		
		public float getCache() {
			return 4.3f;
		}

		public Processor(int coreAmount, String manufacturer) {
			super();
			this.coreAmount = coreAmount;
			this.manufacturer = manufacturer;
		}
		
		
	}
	
	public class Ram {
		@Override
		public String toString() {
			return "Ram [memory=" + memory + ", manufacturer=" + manufacturer + "]";
		}

		int memory;
		String manufacturer;
		
		public float getClockSpeed() {
			return 5.5f;
		}

		public Ram(int memory, String manufacturer) {
			super();
			this.memory = memory;
			this.manufacturer = manufacturer;
		}
		
	}
	
	
}
