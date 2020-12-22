package frontEnd;
import entity.Ex3.Car;
public class Ex3_Q2 {

	public static void main(String[] args) {
		Car c1 = new Car("Mazda", "8WD");
		Car.Engine engine1 = c1.new Engine("Crysler");
		c1.engine = engine1;
		System.out.println(c1);
	}

}
