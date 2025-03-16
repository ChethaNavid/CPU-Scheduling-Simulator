import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CPU_Scheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Process> processes = new ArrayList<>();
        
        while (true) {
            System.out.println("\nCPU Scheduling Menu:");
            System.out.println("1. First-Come, First-Served (FCFS)");
            System.out.println("2. Shortest-Job-First (SJF)");
            System.out.println("3. Shortest-Remaining-Time (SRT)");
            System.out.println("4. Round Robin (RR)");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            if (choice == 5) break;
            
            System.out.print("Enter number of processes: ");
            int numProcesses = scanner.nextInt();
            
            processes.clear();
            for (int i = 0; i < numProcesses; i++) {
                System.out.print("Enter Process ID: ");
                String processID = scanner.next();
                
                // Input validation for arrival time and burst time
                int arrivalTime = -1;
                while (arrivalTime < 0) {
                    System.out.print("Enter Arrival Time (non-negative): ");
                    arrivalTime = scanner.nextInt();
                    if (arrivalTime < 0) {
                        System.out.println("Arrival time cannot be negative. Please enter again.");
                    }
                }
                
                int burstTime = -1;
                while (burstTime <= 0) {
                    System.out.print("Enter Burst Time (positive): ");
                    burstTime = scanner.nextInt();
                    if (burstTime <= 0) {
                        System.out.println("Burst time must be positive. Please enter again.");
                    }
                }

                processes.add(new Process(processID, arrivalTime, burstTime));
            }
            
            switch (choice) {
                case 1:
                    new FCFS(processes).scheduleProcesses();
                    new FCFS(processes).displayResults();  // Display results after scheduling
                    break;
                case 2:
                    new SJF(processes).scheduleProcesses();
                    new SJF(processes).displayResults();  // Display results after scheduling
                    break;
                case 3:
                    new SRT(processes).scheduleProcesses();
                    new SRT(processes).displayResults();  // Display results after scheduling
                    break;
                case 4:
                    System.out.print("Enter Time Quantum: ");
                    int quantum = scanner.nextInt();
                    new RR(processes, quantum).scheduleProcesses();
                    new RR(processes, quantum).displayResults();  // Display results after scheduling
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
            
        }
        scanner.close();
    }
}
