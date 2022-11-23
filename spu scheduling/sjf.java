import java.util.*;

public class sjf {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of processes ");
        int n = sc.nextInt();
        int[] pid = new int[n];
        int[] at = new int[n];
        int[] ct = new int[n];
        int[] tat = new int[n];
        int[] wt = new int[n];
        int[] bt = new int[n];
        int[] flag = new int[n];
        int st = 0, total = 0;
        float avgwt = 0, avgtat = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("input arrival time of task" + (i + 1));
            at[i] = sc.nextInt();
            System.out.println("input burst time of task" + (i + 1));
            bt[i] = sc.nextInt();
            pid[i] = i + 1;
            flag[i] = 0;

        }

        while (true) {
            if (total == n) {
                break;
            }
            int c = n, min = 999;
            for (int i = 0; i < n; i++) {
                if (at[i] <= st && flag[i] == 0 && bt[i] <= min) {
                    min = bt[i];
                    c = i;
                }
            }
            if (c == n) {
                st++;
            } else {
                st += bt[c];
                ct[c] = st;
                tat[c] = ct[c] - at[c];
                wt[c] = tat[c] - bt[c];
                flag[c] = 1;
                total++;
            }
        }

        System.out.println("pid arrival burst waiting turnAround Completion");
        for (int i = 0; i < n; i++) {
            avgwt += wt[i];
            avgtat += tat[i];
            System.out.println(pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + wt[i] + "\t" + tat[i] + "\t" + ct[i]);
        }
        System.out.println("average waiting time = " + (float) (avgwt / n));
        System.out.println("average tat = " + (float) (avgtat / n));
        sc.close();

    }
}
