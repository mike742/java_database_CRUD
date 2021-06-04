import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class driver {
	
	private static String cs = "jdbc:mysql://localhost:3306/payroll";
	private static String un = "root";
	private static String  pw = "1234";
	private static ArrayList<Employee> list;
	
	public static void main(String[] args) {
		
		//Employee emp1 = new Hourly();
		//((Hourly)emp1).load();
		
		//insertHourly((Hourly)emp1);
		
		deleteHourly("1111-1111-1111-1111", "Hourly");
		
		list = getEmployees();
		
		//(list.get(1)).setName("real Lucy");
		//updateHourly((Hourly) list.get(1));
		
		for(var e : list) 
			System.out.println(e);
	}
	
	public static ArrayList<Employee> getEmployees( ) {
		
		ArrayList<Employee> res = new ArrayList<Employee>();
		
		try {
			Connection con = DriverManager.getConnection(cs, un, pw);
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from Hourly;");
			
			while(rs.next()) {
				/*
				System.out.println(
							rs.getString(1) + " " + rs.getString(2) + " " +
							rs.getInt(3) + " " + rs.getInt(4) + " " + 
							rs.getDouble(5) + " " + rs.getDouble(6)
						);
						*/
				Hourly emp = new Hourly(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
						rs.getDouble(5), rs.getDouble(6));
				res.add(emp);
			}
			
			con.close();
		}
		catch(Exception ex) {
			System.err.println(ex);
		}
		
		return res;
	}
	public static void deleteHourly(String ssn, String table) {
		
		try {
			Connection con = DriverManager.getConnection(cs, un, pw);
			Statement st = con.createStatement();
			
			String query = "delete from " + table + " where ssn='" + ssn + "';";
			
			st.executeUpdate(query);
			
			con.close();
		}
		catch(Exception e) {
			System.err.println(e);
		}
	}
	public static void updateHourly(Hourly emp) {
		
		try {
			Connection con = DriverManager.getConnection(cs, un, pw);
			Statement st = con.createStatement();
			
			String query = String.format(
					"update Hourly set name='%s', birthdayMonth=%s, birthdayWeek=%s, hourly_pay=%s, hours=%s where ssn='%s'", 
					emp.getName(), emp.getBirthdayMonth(), emp.getBirthdayWeek(), emp.getHourlyPay(), emp.getHours(), 
					emp.getSSN());
			
			st.executeUpdate(query);
			
			con.close();
		}
		catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public static void insertHourly(Hourly emp) {
		
		try {
			Connection con = DriverManager.getConnection(cs, un, pw);
			Statement st = con.createStatement();
			
			String query = "insert into Hourly values (" + emp.getQueryValues() + ");";
			st.executeUpdate(query);
			
			con.close();
		}
		catch(Exception e) {
			System.err.println(e);
		}
	}
	
}
