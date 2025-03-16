import java.util.Comparator;
import java.util.List;

public class FCFS implements Scheduler{
    private List<Process> processes;
    private int totalWaitingTime = 0;
    private int totalTurnaroundTime = 0;

    public FCFS(List<Process> processes) {
        this.processes = processes;
    }

    @Override
    public void scheduleProcesses() {
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        int currentTime = 0;
        
        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;
            }
            p.waitingTime = currentTime - p.arrivalTime;
            p.turnaroundTime = p.waitingTime + p.burstTime;
            p.completionTime = currentTime + p.burstTime;
            
            totalWaitingTime += p.waitingTime;
            totalTurnaroundTime += p.turnaroundTime;
            
            currentTime += p.burstTime;
        }
    }

    @Override
    public void displayResults() {
        System.out.println("\nFCFS Scheduling Results:");
        System.out.println("Process\tArrival\tBurst\tWaiting\tTurnaround\tCompletion");
        for (Process p : processes) {
            System.out.println(p.processID + "\t" + p.arrivalTime + "\t" + p.burstTime + "\t" + p.waitingTime + "\t" + p.turnaroundTime + "\t\t" + p.completionTime);
        }
        System.out.printf("\nAverage Waiting Time: %.2f\n", (double) totalWaitingTime / processes.size());
        System.out.printf("Average Turnaround Time: %.2f\n", (double) totalTurnaroundTime / processes.size());
    }
}
