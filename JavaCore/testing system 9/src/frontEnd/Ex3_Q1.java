package frontEnd;
import entity.Ex3.CPU;
public class Ex3_Q1 {

	public static void main(String[] args) {
		CPU cpu1 = new CPU(1499.0f);
		CPU.Processor proce1 = cpu1.new Processor(12, "Intel");
		cpu1.processor = proce1;
		CPU.Ram ram1 = cpu1.new Ram(1024*8, "Kingston");
		cpu1.ram = ram1;
		System.out.println(proce1.getCache());
		System.out.println(ram1.getClockSpeed());
		
	}

}
