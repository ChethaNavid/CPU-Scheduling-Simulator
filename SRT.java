import java.util.List;

public class SRT implements Scheduler {
   private List<Process> processes;
   private int totalWaitingTime = 0;
    private int totalTurnaroundTime = 0;

    public SRT(List<Process> processes) {
        this.processes = processes;
    }

    @Override
    public void scheduleProcesses() {
        int time = 0, completed = 0;
        while (completed < processes.size()) {
            Process shortest = null;
            for (Process p : processes) {
                if (p.arrivalTime <= time && p.remainingTime > 0) {
                    if (shortest == null || p.remainingTime < shortest.remainingTime) {
                        shortest = p;
                    }
                }
            }
            if (shortest == null) {
                time++;
                continue;
            }
            shortest.remainingTime--;
            time++;
            if (shortest.remainingTime == 0) {
                completed++;
                shortest.completionTime = time;
                shortest.turnaroundTime = shortest.completionTime - shortest.arrivalTime;
                shortest.waitingTime = shortest.turnaroundTime - shortest.burstTime;
            }
        } 
    }
    
    @Override
    public void displayResults() {
        System.out.println("\nSRT Scheduling Results:");
        System.out.println("Process\tArrival\tBurst\tRemaining\tWaiting\tTurnaround\tCompletion");
        for (Process p : processes) {
            System.out.println(p.processID + "\t" + p.arrivalTime + "\t" + p.burstTime + "\t" + p.remainingTime + "\t" + p.waitingTime + "\t" + p.turnaroundTime + "\t" + p.completionTime);
        }
        System.out.printf("\nAverage Waiting Time: %.2f\n", (double) totalWaitingTime / processes.size());
        System.out.printf("Average Turnaround Time: %.2f\n", (double) totalTurnaroundTime / processes.size());
    }
    
}
