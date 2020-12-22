package backEnd;

import java.util.ArrayList;
import java.util.List;

import entity.Ex3.Employee;

public class Q5_Ex3<T> {
	public List<Employee<T>> listEmpls = new ArrayList<Employee<T>>();

	public void khoiTao() {
		Integer[] Empl1Salaries = { 1200, 1200, 1200, 5000 };
		Employee<Integer> emp1 = new Employee<Integer>(1, "Bắc", Empl1Salaries);
		listEmpls.add((Employee<T>) emp1);

		Float[] Empl2Salaries = { 2400.5f, 2010.9f, 2899.3f, 8000.0f };
		Employee<Float> emp2 = new Employee<Float>(2, "Trung", Empl2Salaries);
		listEmpls.add((Employee<T>) emp2);

		Double[] Empl3Salaries = { 4400d, 5000d, 4800d, 12000.0d };
		Employee<Double> emp3 = new Employee<Double>(3, "Trung", Empl3Salaries);
		listEmpls.add((Employee<T>) emp3);
	}

	public void showAllEmpl() {
		System.out.println("Thông tin các nhân viên:");
		for (Employee<T> employee : listEmpls) {
			System.out.println(employee.toString());
		}
	}

	public <T> void showLastSalary(Employee<T> o) {
		System.out.println(o.getSalaries()[o.getSalaries().length - 1]);
	}
	

}
