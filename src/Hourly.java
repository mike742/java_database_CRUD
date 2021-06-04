import java.util.Scanner;

public class Hourly extends Employee {
	
	private double _hourly_pay;		// hourly pay
	private double _hours;			//hours worked during the past week
	private static Scanner _sn = new Scanner(System.in);	
	
	public void load(String name,String ssn, int birthdayMonth,int birthdayWeek) {		
		super.load(name, ssn, birthdayMonth, birthdayWeek);
		System.out.print("Hourly pay ==> ");
		_hourly_pay = _sn.nextInt();
		System.out.print("Hours worked this past week ==> ");
		_hours = _sn.nextInt();
		System.out.print("\n");
	}

	@Override
	public double getEarnings() {
		double payment = _hourly_pay * _hours + getBonus() ;
		return payment > 1000 ? 1000 : payment;
	}
	
}
