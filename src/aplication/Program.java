package aplication;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.print("enter department`s name: ");
        String departmentName = sc.nextLine();
        System.out.println("enter whorker data: ");
        System.out.println("name: ");
        String whorkerName = sc.nextLine();
        System.out.println("Level: ");
        String whorkerLevel = sc.nextLine();
        System.out.println("salary: ");
        double baseSalary = sc.nextDouble();
        Worker worker = new Worker(whorkerName, WorkerLevel.valueOf(whorkerLevel), baseSalary, new Department(departmentName));
        System.out.println("how many contracts to this worker? ");
        int n = sc.nextInt();
        for (int i = 0;i<n;i++){
            System.out.println("enter contract #"+ i+1 +" data: ");
            System.out.print("DD/MM/YYYY: ");
            Date contractDate = sdf.parse(sc.next());
            System.out.println("value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.println("duration(hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }
        System.out.println("enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("name: "+ worker.getName());
        System.out.println("department: "+ worker.getDepartment().getName());
        System.out.println("income for "+ monthAndYear + ": "+ worker.income(year, month));
        sc.close();
    }
}
