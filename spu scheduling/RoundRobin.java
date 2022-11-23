public class RoundRobin {
    public static void main(String[] args) {
        int processes[] = { 1, 2, 3 };
        int bt[] = { 10, 5, 8 };
        int quantum = 2;
        int n = processes.length;
        int wt[] = new int[n];
        int tat[] = new int[n];
        int total_wt = 0;
        int total_tat = 0;

        int rem_bt[] = new int[n];

        for (int i = 0; i < n; i++) {
            rem_bt[i] = bt[i];
        }

        int t = 0;

        while (true) {
            boolean done = true;

            for (int i = 0; i < n; i++) {
                if (rem_bt[i] > 0) {
                    done = false;
                    if (rem_bt[i] > quantum) {
                        t += quantum;
                        rem_bt[i] -= quantum;

                    } else {
                        t += rem_bt[i];
                        wt[i] = t - bt[i];
                        rem_bt[i] = 0;
                    }
                }
            }
            if (done == true) {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i];
        }

        System.out.format("%15s%15s%15s%15s\n", "process", "burst", "waiting", "turnAround");

        for (int i = 0; i < n; i++) {
            total_wt += wt[i];
            total_tat += tat[i];
            System.out.format("%15d%15d%15d%15d\n", processes[i], bt[i], wt[i], tat[i]);

        }

        System.out.println("average waiting time = " + (float) (total_wt) / (float) (n));
        System.out.println("average turnAround time = " + (float) (total_tat) / (float) (n));
    }
}
