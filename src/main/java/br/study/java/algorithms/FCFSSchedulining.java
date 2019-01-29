package br.study.java.algorithms;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/program-fcfs-scheduling-set-1/
 * @author fabiana
 *
 * How to compute below times in Round Robin using a program?
 * 
 * Completion Time: Time at which process completes its execution.
 * Turn Around Time: Time Difference between completion time and arrival time. 
 * Turn Around Time = Completion Time – Arrival Time
 * Waiting Time(W.T): Time Difference between turn around time and burst time.
 * Waiting Time = Turn Around Time – Burst Time
 */
public class FCFSSchedulining {


    // Driver code  
    public static void main(String[] args) /*throws ParseException*/ { 
        //process id's  
        int processes[] = {1, 2, 3}; 
        int n = processes.length; 
  
        //Burst time of all processes  
        int burst_time[] = {10, 5, 8}; 
        
        FCFSSchedulining s = new FCFSSchedulining();
  
        s.findavgTime(processes, n, burst_time); 
  
    } 
    
    private void findavgTime(int processes[], int n, int bt[]) {
    	
    	int wt[] = new int[n];
    	int tat[] = new int[n];
    	
    	int totalWT = 0;
    	int totalTAT = 0;
    	
    	findWaitingTime(processes, n, bt, wt); 
    	
    	findTurnAroundTime(processes, n, bt, wt, tat); 
    	
    	// Calculate total waiting time and total turn  
        // around time  
        for (int i = 0; i < n; i++) { 
        	totalWT += wt[i]; 
        	totalTAT += tat[i]; 
            System.out.printf(" %d ", (i + 1)); 
            System.out.printf("     %d ", bt[i]); 
            System.out.printf("     %d", wt[i]); 
            System.out.printf("     %d\n", tat[i]); 
        } 
        
        float s = (float)totalWT /(float) n; 
        int t = totalTAT / n; 
        System.out.printf("Average waiting time = %f", s); 
        System.out.printf("\n"); 
        System.out.printf("Average turn around time = %d ", t); 
    	
    }
    
    private void findWaitingTime(int processes[], int n, int bt[], int wt[]) { 
    	
        // waiting time for first process is 0  
        wt[0] = 0; 
  
        // calculating waiting time  
        for (int i = 1; i < n; i++) { 
            wt[i] = bt[i - 1] + wt[i - 1]; 
        } 
        
        System.out.println("wt: "+ Arrays.toString(wt));
    } 
    
    private void findTurnAroundTime(int processes[], int n, int bt[], int wt[], int tat[]) { 
    	
        // calculating turnaround time by adding  
        // bt[i] + wt[i]  
        for (int i = 0; i < n; i++) { 
            tat[i] = bt[i] + wt[i]; 
        }
        
        System.out.println("tat: "+ Arrays.toString(tat));
    } 
  
}
