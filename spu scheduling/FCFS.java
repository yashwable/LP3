class FCFS {
    public static void main(String args[]) {
        int[] processes = { 1, 2, 3 };
        int n = processes.length;

        int burst_time = { 10, 5, 8 };

        findAvgTime(processes, n, burst_time);

    }
}