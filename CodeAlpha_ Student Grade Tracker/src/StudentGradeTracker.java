import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int[] marks;
    private double average;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        calculateAverage();
    }

    private void calculateAverage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        average = sum / 5.0;
    }

    public String getName() {
        return name;
    }

    public double getAverage() {
        return average;
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter student name: ");
            String name = sc.nextLine();

            int[] marks = new int[5];
            System.out.println("Enter marks for 5 subjects:");

            for (int j = 0; j < 5; j++) {
                System.out.print("Subject " + (j + 1) + ": ");
                marks[j] = sc.nextInt();
            }
            sc.nextLine();

            students.add(new Student(name, marks));
        }

        double highestAvg = students.getFirst().getAverage();
        double lowestAvg = students.getFirst().getAverage();

        for (Student s : students) {
            if (s.getAverage() > highestAvg) {
                highestAvg = s.getAverage();
            }
            if (s.getAverage() < lowestAvg) {
                lowestAvg = s.getAverage();
            }
        }

        System.out.println("\n------ Student Average Report ------");
        for (Student s : students) {
            System.out.println("Name: " + s.getName() +
                               " | Average Marks: " + s.getAverage());
        }

        System.out.println("\nHighest Average: " + highestAvg);
        System.out.println("Lowest Average: " + lowestAvg);

        sc.close();
    }
}
