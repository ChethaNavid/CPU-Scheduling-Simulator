import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RR implements Scheduler{
    private List<Process> processes;
    private int timeQuantum;

    public RR(List<Process> processes, int timeQuantum) {
        this.processes = processes;
        this.timeQuantum = timeQuantum;
    }

    @Override
    public void scheduleProcesses() {
        Queue<Process> queue = new LinkedList<>(processes);
        int time = 0;
        while (!queue.isEmpty()) {
            Process p = queue.poll();
            if (p.remainingTime > timeQuantum) {
                time += timeQuantum;
                p.remainingTime -= timeQuantum;
                queue.offer(p);
            } else {
                time += p.remainingTime;
                p.remainingTime = 0;
                p.completionTime = time;
                p.turnaroundTime = p.completionTime - p.arrivalTime;
                p.waitingTime = p.turnaroundTime - p.burstTime;
            }
        }
    }

    @Override
    public void displayResults() {
        System.out.println("\nRound Robin (RR) Scheduling Results:");
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
