class Process {
    String processID;
    int arrivalTime, burstTime, waitingTime, turnaroundTime, completionTime, remainingTime;

    public Process(String processID, int arrivalTime, int burstTime) {
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime; // For preemptive scheduling
    }
}