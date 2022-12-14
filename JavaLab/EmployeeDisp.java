/* ----------------------------------------------------------------------------------
                        EmployeeDisp.java
The addBonustoEmpList() method from JavaLab.Work.Employee class is called here to add
a bonus of 5% to a list of employees.

@author Adelicia Sequeira
@date 11/11/22
 ----------------------------------------------------------------------------------*/
package JavaLab;

import java.util.Scanner;
import JavaLab.WorkTest.Employee;

public class EmployeeDisp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number of employees ");
        int num = scan.nextInt();

        Employee[] arr = new Employee[num];

        for (int i = 0; i < num; i++) {
            System.out.println("Enter details of employee "+(i+1));
            System.out.println("Enter name");
            scan.nextLine();
            String name = scan.nextLine();

            System.out.println("Enter id ");
            String id = scan.nextLine();

            System.out.println("Enter current salary ");
            double salary = scan.nextInt();

            arr[i] = new Employee(name, id, salary);
        }

        arr = Employee.addBonus(arr);

        Employee.display(arr);

        scan.close();

    }
}
