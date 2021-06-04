import java.util.Scanner;

public class SalariedPlusCommission extends Salaried {
	
	private int _sales;				// sales during the past week
	private double _comRate;		// commission rate
	private static Scanner _sn = new Scanner(System.in);
	
	public void load(String name,String  ssn,int  birthdayMonth,int  birthdayWeek) {
		super.load(name, ssn, birthdayMonth, birthdayWeek);
		System.out.print("Sales for this past week ==> ");
		_sales = _sn.nextInt();
		System.out.print("Sales commission rate (fraction paid to employee) ==> ");
		_comRate = _sn.nextDouble();
		System.out.print("\n");
	}
	
	@Override
	public double getEarnings() {
		double payment = super.getEarnings();
		payment += (Double)(_sales * _comRate);
		return payment > 1000 ? 1000 : payment ;
	}

}
