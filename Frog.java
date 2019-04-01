import java.util.*;
public class Frog {

	
	
	public static ArrayList<Frog> frogList = new ArrayList<Frog>();
	
	public static int[] jumpList;
	public Frog (int[] jumps) {
		
		jumpList = jumps;
		
	}
	
	public static int[] getJumpList() {
		return jumpList;
	}
	
	public static int getAvg() {
		int tot = 0, avg = 0, totNum = 0;
		for (int i = 0; i < jumpList.length; i++) {
			if (jumpList[i] == 0) {
				i = jumpList.length;
			} else {
			tot+= jumpList[i];
			totNum++;
		}
			
	}
		avg = tot/totNum;
		return avg;
	}
	public static void printList() {
		for (int i = 0; i < jumpList.length; i++) {
			if (jumpList[i] == 0) {
				i = jumpList.length;
			} else {
			System.out.println("Jump " + (i+1) + ": " + jumpList[i]);
			}
		}
	}
	
	
}
