import java.io.*;
import java.util.*;

public class OnlineExamSystem 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String username = "Sneha";
        String password = "1234";

        System.out.println("===== Login Page =====");
        System.out.print("Username: ");
        String name = sc.nextLine();
        System.out.print("Password: ");
        String upass = sc.nextLine();

        if (!(name.equals(username) && upass.equals(password))) 
        {
            System.out.println("Invalid login. Exiting...");
            sc.close();
            return;
        }

        while (true) 
        {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1. Update Profile");
            System.out.println("2. Start Exam");
            System.out.println("3. Logout");
            System.out.print("Choose option: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter new name: ");
                    name = sc.nextLine();
                    System.out.print("Enter new password: ");
                    password = sc.nextLine();
                    System.out.println("Profile updated successfully!");
                    break;

                case 2:
                    System.out.println("\nExam started. You have 1 hour.");

                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() 
                    {
                        public void run() {
                            System.out.println("\nTime's up! Auto-submitting...");
                            System.exit(0);
                        }
                    }, 3600000);

                    int score = 0;
                    try 
                    {
                        BufferedReader reader = new BufferedReader(new FileReader("questions.txt"));
                        String question;

                        while ((question = readNonEmptyLine(reader)) != null) 
                        {
                            String optA = readNonEmptyLine(reader);
                            String optB = readNonEmptyLine(reader);
                            String optC = readNonEmptyLine(reader);
                            String optD = readNonEmptyLine(reader);
                            String correct = readNonEmptyLine(reader);

                            if (optA == null || optB == null || optC == null || optD == null || correct == null) 
                            {
                                System.out.println("Error: Incomplete question block. Skipping.");
                                break;
                            }

                            System.out.println("\n" + question);
                            System.out.println(optA);
                            System.out.println(optB);
                            System.out.println(optC);
                            System.out.println(optD);

                            String answer;
                            while (true)
                            {
                                System.out.print("Your answer (A/B/C/D): ");
                                answer = sc.nextLine().trim().toUpperCase();
                                if (answer.matches("[ABCD]")) break;
                                System.out.println("Invalid input. Please enter A, B, C, or D.");
                            }

                            if (answer.equalsIgnoreCase(correct.trim())) {
                                score++;
                            }
                        }

                        reader.close();
                    } catch (IOException e) 
                    {
                        System.out.println("Error loading questions.txt file.");
                    }

                    timer.cancel();
                    System.out.println("\nExam submitted.");
                    System.out.println("Score: " + score);
                    break;

                case 3:
                    System.out.println("Logged out.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }

    
    private static String readNonEmptyLine(BufferedReader reader) throws IOException 
    {
        String line;
        do {
            line = reader.readLine();
            if (line == null) return null;
            line = line.trim();
        } while (line.isEmpty());
        return line;
    }
}