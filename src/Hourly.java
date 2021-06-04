import java.util.Scanner;

public class Hourly extends Employee {
	
	private double _hourly_pay;		// hourly pay
	private double _hours;			//hours worked during the past week
	private static Scanner _sn = new Scanner(System.in);	

	public double getHourlyPay() {
		return _hourly_pay;
	}
	
	public double getHours() {
		return _hours;
	}

	public Hourly() {}
	
	public Hourly(String name, String ssn, int birthdayMonth, int birthdayWeek, 
				 double hourly_pay, double hours) {
		super(name, ssn, birthdayMonth, birthdayWeek);
		_hourly_pay = hourly_pay;
		_hours = hours;
	}
	
	@Override
	public double getEarnings() {
		double payment = _hourly_pay * _hours + getBonus() ;
		return payment > 1000 ? 1000 : payment;
	}
	
	public String getQueryValues() {
		return super.getQueryValues() + "," + _hourly_pay + "," + _hours;
	}
}

