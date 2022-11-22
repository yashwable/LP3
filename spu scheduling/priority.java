import java.util.*;

public class priority {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of processes");
        int n = sc.nextInt();
        int[] pid = new int[n]; // process id
        int[] at = new int[n]; // srrival time
        int[] bt = new int[n]; // burst time
        int[] priority = new int[n];
        int[] wt = new int[n]; // waiting time
        int[] tat = new int[n]; // turn around time
        int[] ct = new int[n]; // complete time

        for (int i = 0; i < n; i++) { // tazking input of arrival,priority and burst time
            System.out.println("enter arrival time of process" + (i + 1));
            at[i] = sc.nextInt();
            System.out.println("enter burst time of process" + (i + 1));
            bt[i] = sc.nextInt();
            System.out.println("enter priority of process" + (i + 1));
            priority[i] = sc.nextInt();
            pid[i] = i + 1;
        }
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (at[j] > at[j + 1]) {
                    temp = at[j]; // arrival time swapping
                    at[j] = at[j + 1];
                    at[j + 1] = temp;

                    temp = bt[j]; // burst time swapping
                    bt[j] = bt[j + 1];
                    bt[j + 1] = temp;

                    temp = priority[j]; // priority time swapping
                    priority[j] = priority[j + 1];
                    priority[j + 1] = temp;

                    temp = pid[j]; // pid swapping
                    pid[j] = pid[j + 1];
                    pid[j + 1] = temp;
                }
                if (at[j] == at[j + 1]) {
                    if (priority[j] > priority[j + 1]) {
                        temp = at[j];
                        at[j] = at[j + 1];
                        at[j + 1] = temp;

                        temp = bt[j];
                        bt[j] = bt[j + 1];
                        bt[j + 1] = temp;

                        temp = priority[j];
                        priority[j] = priority[j + 1];
                        priority[j + 1] = temp;

                        temp = pid[j];
                        pid[j] = pid[j + 1];
                        pid[j + 1] = temp;
                    }
                }
            }
        }

        ct[0] = at[0] + bt[0];
        tat[0] = ct[0] - at[0];
        wt[0] = tat[0] - bt[0];

        for (int i = 1; i < n; i++) {
            ct[i] = ct[i - 1] + bt[i];
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
        }

        float sumwt = 0, sumtat = 0;

        for (int i = 0; i < n; i++) {
            sumwt += wt[i];
            sumtat += tat[i];
        }

        float avgwt = sumwt / n;
        float avgtat = sumtat / n;

        System.out.println("Priority Scheduling algorithm");
        System.out.format("%20s%20s%20s%20s%20s%20s%20s\n", "pid", "arrivalTime", "burstTime", "priority",
                "waitingTime", "TurnAroundTime", "completionTime");

        for (int i = 0; i < n; i++) {
            System.out.format("%20d%20d%20d%20d%20d%20d%20d\n", pid[i], at[i], bt[i], priority[i], wt[i], tat[i],
                    ct[i]);
        }
        System.out.format("%80s%20f%20f", "average", avgwt, avgtat);
        sc.close();
    }
}
