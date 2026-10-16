import java.util.*;
import java.io.*;
class Candidate {
    String name;
    int votes;
    Candidate(String name) {
    this.name = name;
    }
}
public class StudentElectionSystemFinal {
    static int readNumber(Scanner s) {
        while (true) {
            try {
                return s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                s.next();
            }
        }
    }
    static void showResults(Candidate[] list) {
        int max = 0;
        String winner = "";
        for (Candidate c : list) {            
            System.out.println(c.name.toUpperCase() + ": " + c.votes);
            if (c.votes > max) {
            max = c.votes;
            winner = c.name;
            }
        }
        if (max > 0) {
            System.out.println("Winner: " + winner.toUpperCase() + "!");
        }
        try (PrintWriter f=new PrintWriter("results.txt")) {
    f.write("--- OFFICIAL STUDENT ELECTION RECORD ---\n");
    f.write("The student body has made its decision.\n");
    f.write("Congratulations to our new representative: " + winner.toUpperCase() + "!\n");
} catch (Exception e) {
    System.out.println("Error writing to file: " + e.getMessage());
}
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Candidate[] list = { new Candidate("John"), new Candidate("Mon"), new Candidate("Con") };
        System.out.print("Enter the number of students voting: ");
        int n = readNumber(s);
        System.out.print("Enter 1 for John, 2 for Mon and 3 for Con: ");
        for (int count = 0; count < n; ) {
            int choice = readNumber(s);
            if (choice >= 1 && choice <= 3) {
            list[choice - 1].votes++;
            count++;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        showResults(list);
    }
}