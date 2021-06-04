import java.util.Scanner;

public class Salaried extends Employee {
	
	private double _weekly_salary;
	private static Scanner _sn = new Scanner(System.in);
	
	public void load(String name,String  ssn,int  birthdayMonth,int  birthdayWeek) {
		super.load(name, ssn, birthdayMonth, birthdayWeek);
		System.out.print("Salary ==> ");
		 _weekly_salary = _sn.nextInt();
		 System.out.print("\n");
	}

	@Override
	public double getEarnings() {
		double payment = _weekly_salary + getBonus();
		return payment > 1000 ? 1000 : payment;
	}

}
