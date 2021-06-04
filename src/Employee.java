import java.util.Calendar;
import java.util.Scanner;

public abstract class Employee {

	private String _name;
	private String _ssn;			
	private int _birthdayMonth;
	private int _birthdayWeek;
	private static Scanner _sn = new Scanner(System.in);

	public abstract  double getEarnings();
	
	public void setName(String value) {
		_name = value;
	} 
	
	public String getName() {
		return _name;
	}
	
	public String getSSN() {
		return _ssn;
	}
	
	public int getBirthdayMonth() {
		return _birthdayMonth;
	}

	public int getBirthdayWeek() {
		return _birthdayWeek;
	}
	
	public Employee() {}
	
	public Employee(String name, String ssn, int birthdayMonth, int birthdayWeek) {
		_name = name;
		_ssn = ssn;
		_birthdayMonth = birthdayMonth;
		_birthdayWeek = birthdayWeek;
	}
	
	public void load() {
		System.out.print("Name ==> ");
		String name = _sn.next();
		System.out.print("Social security number ==> ");
		String ssn = _sn.next();
		System.out.print("Birthday month (1-12) ==> ");
		int birthdayMonth = _sn.nextInt();
		System.out.print("Birthday bonus week (1-4) ==> ");
		int birthdayWeek = _sn.nextInt();
		
		load(name, ssn, birthdayMonth, birthdayWeek);
	}
	
	public void load(String name, String ssn, int birthdayMonth, int birthdayWeek) {		
		_name = name;
		_ssn = ssn;
		_birthdayMonth = birthdayMonth;
		_birthdayWeek = birthdayWeek;
	}
	
	public String toString() {
		return String.format("employee: %s", _name + "\n") +
				String.format("social security number: %s", _ssn + "\n") +
				String.format("paycheck: $%.2f", getEarnings());
	}
	
	public double getBonus() {
		
		//Calendar c = Calendar.getInstance();		
		int month = 10;	 // c.get(Calendar.MONTH + 1)
		int week = 2;	 // c.get(Calendar.WEEK_OF_MONTH)
		
		if(_birthdayMonth == month && _birthdayWeek == week) {
			return 100;
		}		
		return 0;
	}
	public String getQueryValues() {
		return "'" + _name + "', '" + _ssn + "'," + _birthdayMonth + "," + _birthdayWeek;
	}

}
