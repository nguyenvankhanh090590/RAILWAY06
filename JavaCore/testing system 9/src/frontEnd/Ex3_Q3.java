package frontEnd;
import entity.Ex3.OuterClass;
import entity.Ex3.OuterClass.InnerClass;
public class Ex3_Q3 {

	public static void main(String[] args) {
		OuterClass outerCl = new OuterClass();
		outerCl.show();
		
		InnerClass innerCl = outerCl.new InnerClass();
		innerCl.show();
	}

}
