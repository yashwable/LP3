class FCFS {
    static void findWaitingTime(int[] processes, int n, int[] bt, int[] wt) {
        wt[0] = 0;
        for (int i = 1; i < n; n++) {
            wt[i] = wt[i - 1] + bt[i - 1];
        }
    }

    static void findTurnAroundTime(int[] processes, int n, int[] bt, int[] wt, int[] tat) {
        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i];
        }
    }

    static void findAvgTime(int[] processes, int n, int[] bt) {
        int wt[] = new int[n];
        int tat[] = new int[n];
        int total_wt = 0;
        int total_tat = 0;

        findWaitingTime(processes, n, bt, wt);
        findTurnAroundTime(processes, n, bt, wt, tat);

        System.out.println("processes Burst_time Waiting_Time Turn_Around_Time");

        for (int i = 0; i < n; i++) {
            total_wt += wt[i];
            total_tat += tat[i];

            System.out.printf("%d\t", processes[i]);
            System.out.printf("%d\t", bt[i]);
            System.out.printf("%d\t", wt[i]);
            System.out.printf("%d\n", tat[i]);

        }
        float s = (float) total_wt / (float) n;
        int t = total_tat / n;
        System.out.printf("Average waiting time = %f\n", s);
        System.out.printf("Average Turn Around Time = %d", t);

    }

    public static void main(String args[]) {
        int[] processes = { 1, 2, 3 };
        int n = processes.length;

        int[] burst_time = { 10, 5, 8 };

        findAvgTime(processes, n, burst_time);

    }
}