package JavaLab.WorkTest;

public class Employee {
    String name = null;
    String id = null;
    double salary = 0.0;

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public static Employee[] addBonus(Employee[] arr) {
        for (Employee emp : arr) {
            //emp.salary = emp.salary + (0.5*emp.salary);
            emp.salary += 0.5*(emp.salary);
        }
        return arr;
    }

    public static void display(Employee[] arr) {
        for(Employee emp : arr) {
            System.out.println("The employee "+emp.name+ " with id "+emp.id+" is now earning "+emp.salary+" after a hike of 5%");
        }
    }

}
