# CPU Scheduling Simulator

## Project Description

This project simulates four CPU scheduling algorithms: **First-Come, First-Served (FCFS)**, **Shortest-Job-First (SJF)**, **Shortest-Remaining-Time (SRT)**, and **Round Robin (RR)**. The program provides a menu-driven interface allowing users to select one of the scheduling algorithms, input process details, and view the results. The output includes a Gantt chart, waiting times, turnaround times, and average waiting and turnaround times for each algorithm.

### Algorithms Implemented:
1. **First-Come, First-Served (FCFS)**: Processes are executed in the order of their arrival without preemption.
2. **Shortest-Job-First (SJF)**: Processes are executed based on their burst times, with the shortest burst time first.
3. **Shortest-Remaining-Time (SRT)**: A preemptive version of SJF, where the process with the shortest remaining time is executed first.
4. **Round Robin (RR)**: Processes are executed in a circular order, each receiving a fixed time slice (quantum). If a process doesn't finish within its quantum, it is preempted and moved to the end of the queue.

## Features

- Menu-driven interface for algorithm selection.
- Input for process ID, arrival time, and burst time.
- For Round Robin, a time quantum is also requested.
- Displays the following outputs for each algorithm:
  - Gantt Chart.
  - Waiting time for each process.
  - Turnaround time for each process.
  - Average waiting time.
  - Average turnaround time.
  
## Requirements

- Java 8 or higher (or any programming language with similar features).
- Any IDE (e.g., IntelliJ IDEA, Eclipse) or text editor to run the program.

## Instructions

1. **Clone the repository**:
   Clone this repository to your local machine using the following command:
    https://github.com/ChethaNavid/CPU-Scheduling-Simulator.git

2. **Navigate to the project directory**:
    After cloning the repository, change to the project directory:
    cd CPU-Scheduling-Simulator

3. **Compile the program**:
    Open a terminal or command prompt in the project directory and compile the program using the following command:
    javac CPU_Scheduler.java

4. **Run the program**:
    After successful compilation, you can run the program using the following command:
    java CPU_Scheduler