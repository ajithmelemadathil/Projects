package Edms;

import java.util.Scanner;

import exception.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeDatabase e = new EmployeeDatabaseImplementation();
		while (true) {
			System.out.println(
					"_________________________________Welcome to Employee DataBase_______________________________________");
			System.out.println("Press 1 :Add Employee");
			System.out.println("Press 2 :Display Employee");
			System.out.println("Press 3 :Display All Employee");
			System.out.println("Press 4 :Remove Employee");
			System.out.println("Press 5 :Update Employee");
			System.out.println("Press 6 :Count NO. Employee");
			System.out.println("Press 7 :GetEmployeeWithHighestSalary");
			System.out.println("Press 8 :GetEmployeeWithLowestSalary");
			System.out.println("Press 9 :RemoveAllEmployee");
			System.out.println("Press 10:Exit");

			System.out.println("Enter Your Choice");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				e.addEmployee();
				break;
			case 2:
				e.displayEmployee();
				break;
			case 3:
				e.displayAllEmployee();
				break;
			case 4:
				e.removeEmployee();
				break;
			case 5:
				e.updateEmployee();
				break;
			case 6:
				e.countNoEmployee();
				break;
			case 7:
				e.getEmployeeWithHighestSalery();
				break;
			case 8:
				e.getEmployeeWithLowestSalery();
				break;
			case 9:
				e.removeAllEmployee();
				break;
			case 10:
				System.out.println("Thank You");
				System.exit(0);

			default:
				try {
					throw new InvalidChoiceException("Invalid Choice");

				} catch (Exception e1) {
					System.err.println(e1.getMessage());
				}
			}

		}
	}
}
