package Edms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import exception.DataNotFoundException;
import exception.EmployeeNotFoundException;
import exception.InvalidChoiceException;

public class EmployeeDatabaseImplementation implements EmployeeDatabase {
	Scanner sc = new Scanner(System.in);

	@Override
	public void addEmployee() {
		System.out.println("Enter the Employee Slno");
		int slno=sc.nextInt();
		System.out.println("Enter the Employee name");
		String name=sc.next();
		System.out.println("Enter the Employee age");
		int age=sc.nextInt();
		System.out.println("Enter the Employee salary");
		double salary=sc.nextDouble();
		System.out.println("Enter the Employee designation");
		String designation=sc.next();
		Employee employee=new Employee(slno, name, age, salary, designation);
		String id=employee.getId();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedbms","root","root");
		PreparedStatement preparedStatement=connection.prepareStatement("insert into employee values(?,?,?,?,?,?)");
		preparedStatement.setInt(1, slno);
		preparedStatement.setString(2, id);
		preparedStatement.setString(3, name);
		preparedStatement.setInt(4, age);
		preparedStatement.setDouble(5, salary);
		preparedStatement.setString(6, designation);
		preparedStatement.execute();
		System.out.println("Employee Record inserted"+"\n Your id is = "+employee.getId());
		
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		

	}

	@Override
	public void displayEmployee() {
		System.out.println("Enter The Employee ID: ");
		String id = sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedbms", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where id=?");
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("Employee slno  is -> " + resultSet.getInt(1));
				System.out.println("Employee id  is -> " + resultSet.getString(2));
				System.out.println("Employee name is -> " + resultSet.getString(3));
				System.out.println("Employee age  is -> " + resultSet.getInt(4));
				System.out.println("Employee salary is -> " + resultSet.getDouble(5));
				System.out.println("Employee designation is -> " + resultSet.getString(6));
			} else {
				try {
					throw new EmployeeNotFoundException("Employee Data Not Present");
				} catch (Exception e3) {
					System.err.println(e3.getMessage());
				}

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}


		

	}

	@Override
	public void displayAllEmployee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedbms", "root",
					"root");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from employee");
			while (resultSet.next()) {
				System.out.println("Employee slno  is -> " + resultSet.getInt(1));
				System.out.println("Employee id  is -> " + resultSet.getString(2));
				System.out.println("Employee name is -> " + resultSet.getString(3));
				System.out.println("Employee age  is -> " + resultSet.getInt(4));
				System.out.println("Employee salary is -> " + resultSet.getDouble(5));
				System.out.println("Employee designation is -> " + resultSet.getString(6));
				System.out.println("________________________________________________________");
				System.out.println("");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		

	}

	@Override
	public void removeEmployee() {
		System.out.println("Enter The Employee ID: ");
		String id = sc.next();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedbms", "root",
				"root");
		PreparedStatement preparedStatement=connection.prepareStatement("delete from employee where id =?");
		preparedStatement.setString(1, id);
		preparedStatement.execute();
		System.out.println("Employee Deleted successfully");
		
	}
	catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}

	}

	@Override
	public void updateEmployee() {
		System.out.println("Enter The Employee ID: ");
		String id = sc.next();
		System.out.println("Choose your parameter to update \n a:Update Name\n b:Update Age\n c:Update Salary");
		char choice=sc.next().charAt(0);
		switch(choice) {
		case 'a':{
			System.out.println("Enter the new name");
			String name=sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedbms","root","root");
		PreparedStatement preparedStatement=connection.prepareStatement("update employee set name=? where id=?");
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, id);
		preparedStatement.execute();
		System.out.println("Name Updated");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
			
		}
		break;
		case 'b':{
			System.out.println("Enter the new age");
			int age=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedbms","root","root");
		PreparedStatement preparedStatement=connection.prepareStatement("update employee set age=? where id=?");
		preparedStatement.setInt(1, age);
		preparedStatement.setString(2, id);
		preparedStatement.execute();
		System.out.println("Age Updated");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		break;
		case 'c':{
			System.out.println("Enter the new salary");
			Double salary=sc.nextDouble();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedbms","root","root");
		PreparedStatement preparedStatement=connection.prepareStatement("update employee set salary=? where id=?");
		preparedStatement.setDouble(1, salary);
		preparedStatement.setString(2, id);
		preparedStatement.execute();
		System.out.println("Salary Updated");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		break;
		default:
			try {
				throw new InvalidChoiceException("Invalid Choice");
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
			}
			break;
			
			
		
		}
	
		

	}

	@Override
	public void countNoEmployee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedbms", "root",
					"root");
			PreparedStatement preparedStatement=connection.prepareStatement("select count(*) from employee");
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				System.out.println("Total number of employees is = "+resultSet.getInt(1));
			}else {
				try {
					throw new DataNotFoundException("Data not found");
				}catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
			
			
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void getEmployeeWithHighestSalery() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedbms", "root",
					"root");
			PreparedStatement preparedStatement=connection.prepareStatement("SELECT Name FROM employee where Salary = (SELECT Max(Salary) FROM employee)");
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				System.out.println("The person who earn max salary is "+resultSet.getString(1));
			}else {
				try {
					throw new DataNotFoundException("Data not found");
				}catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
			
			
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getEmployeeWithLowestSalery() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedbms", "root",
					"root");
			PreparedStatement preparedStatement=connection.prepareStatement("SELECT Name FROM employee where Salary = (SELECT min(Salary) FROM employee)");
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				System.out.println("The person who earn min salary is "+resultSet.getString(1));
			}else {
				try {
					throw new DataNotFoundException("Data not found");
				}catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
			
			
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void removeAllEmployee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedbms", "root",
					"root");
			PreparedStatement preparedStatement=connection.prepareStatement("truncate table employee");
			
			preparedStatement.execute();
			System.out.println(" Deleted table successfully");
			
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

	}

}
