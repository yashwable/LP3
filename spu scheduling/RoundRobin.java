public class RoundRobin {
    public static void main(String[] args) {
        int processes[] = { 1, 2, 3 };
        int bt[] = { 10, 5, 8 }; // burst time
        int quantum = 2; // quantum time for each process
        int n = processes.length;
        int wt[] = new int[n]; // waiting time
        int tat[] = new int[n]; // turn around time
        int total_wt = 0;
        int total_tat = 0;

        int rem_bt[] = new int[n]; // remaining burst time of each process

        // making copy of burst time to remaining bust time as initially they are same
        for (int i = 0; i < n; i++) {
            rem_bt[i] = bt[i];
        }

        int t = 0; // system time

        while (true) {
            boolean done = true;

            // traversing through each process to find out any process is remaining or not.
            for (int i = 0; i < n; i++) {
                if (rem_bt[i] > 0) {

                    done = false;

                    // if remaining time of process is more than quantum time.
                    if (rem_bt[i] > quantum) {
                        t += quantum; // increase time by quantum
                        rem_bt[i] -= quantum; // reduce remaining burst time by quantum

                    } else { // else if process burst time is less than or equal to quantum time.
                        t += rem_bt[i]; // increase time by remaining time
                        wt[i] = t - bt[i]; // waiting time = system time - burst time ,
                        rem_bt[i] = 0; // remaining time is 0.
                    }
                }
            }

            // if all processes are done break the while loop.
            if (done == true) {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i]; // turnAround time = waiting time + burst time of task.
        }

        // table
        System.out.format("%15s%15s%15s%15s\n", "process", "burst", "waiting", "turnAround");

        for (int i = 0; i < n; i++) {
            total_wt += wt[i]; // adding waiting time of each task to total waiting time
            total_tat += tat[i]; // adding turnAround time of each task to total turnAround time
            System.out.format("%15d%15d%15d%15d\n", processes[i], bt[i], wt[i], tat[i]);

        }

        System.out.println("average waiting time = " + (float) (total_wt) / (float) (n)); // printing average waiting
                                                                                          // time
        System.out.println("average turnAround time = " + (float) (total_tat) / (float) (n)); // printing average
                                                                                              // turnAround time
    }
}
