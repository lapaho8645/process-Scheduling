import java.util.Scanner;

import javax.swing.JFrame;

import com.func.*;
import com.pro.Process;
public class main extends JFrame{

	public static void main(String[] args) {
		int arrTime, burTime;
	      Scanner in = new Scanner(System.in);
	      int n = in.nextInt();
	      
//	      CORONA crn = new CORONA(n);
//	      for(int i = 0; i < 5;i++) {
//	         arrTime = in.nextInt();
//	         burTime = in.nextInt();
//	          crn.insertPcs(arrTime, burTime);
//	      }
//	      //sr.doScheduling();
//	      crn.doScheduling();
	      
	      
	      //FCFS crn = new FCFS(n);
	     CORONA crn = new CORONA(n);
	      for(int i = 0; i < 5;i++) {
	         arrTime = in.nextInt();
	         burTime = in.nextInt();
	          crn.insertPcs(arrTime, burTime);
	      }
	      //sr.doScheduling();
	      crn.doScheduling();
//		Temp f = new (1);
//		f.insertPcs(0, 3);
//		f.insertPcs(1, 10);
//		f.insertPcs(0, 1);
//		f.insertPcs(1, 4);
//		f.insertPcs(2, 3);
//		f.insertPcs(6, 3);
//		Process[] tt =f.doScheduling();
//		System.out.println(" RMx");
//
//		for(int i=0;i<6;i++) {
//			System.out.println(tt[i].toString()+" "+i);
//		}
//		SRTN f = new SRTN(1);
//		f.insertPcs(0, 3);
//		f.insertPcs(1, 1);
//		f.insertPcs(1, 4);
//		f.insertPcs(2, 3);
//		f.insertPcs(6, 2);
//		Process[] tt =f.doScheduling();
//		for(int i=0;i<5;i++) {
//			System.out.println(tt[i].toString());
//		}
////		
//		SPN f = new SPN(1);
//		f.insertPcs(0, 3);
//		f.insertPcs(1, 10);
//		f.insertPcs(0, 1);
//		f.insertPcs(1, 4);
//		f.insertPcs(2, 3);
//		f.insertPcs(6, 3);
//		Process[] tt =f.doScheduling();
//		System.out.println(" RMx");
//		for(int i=0;i<6;i++) {
//			System.out.println(tt[i].toString()+" 11");
//		}
	}
}