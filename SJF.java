import java.util.Comparator;
import java.util.List;

public class SJF implements Scheduler{
    private List<Process> processes;

    public SJF(List<Process> processes) {
        this.processes = processes;
    }

    @Override
    public void scheduleProcesses() {
        processes.sort(Comparator.comparingInt(p -> p.burstTime)); // Sort by burst time
        new FCFS(processes).scheduleProcesses();
    }

    @Override
    public void displayResults() {
        System.out.println("\nShortest Job First (SJF) Scheduling Results:");
        System.out.println("Process\tArrival\tBurst\tWaiting\tTurnaround\tCompletion");
        for (Process p : processes) {
            System.out.println(p.processID + "\t" + p.arrivalTime + "\t" + p.burstTime + "\t" + p.waitingTime + "\t" + p.turnaroundTime + "\t" + p.completionTime);
        }
        double totalWaitingTime = 0, totalTurnaroundTime = 0;
        for (Process p : processes) {
            totalWaitingTime += p.waitingTime;
            totalTurnaroundTime += p.turnaroundTime;
        }
        System.out.printf("\nAverage Waiting Time: %.2f\n", totalWaitingTime / processes.size());
        System.out.printf("Average Turnaround Time: %.2f\n", totalTurnaroundTime / processes.size());
    }
}
