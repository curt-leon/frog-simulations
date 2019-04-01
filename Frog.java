
public class Frog {

	
	
	
	
	public  int[] jumpList;
	public Frog (int[] jumps) {
		
		jumpList = jumps;
		
	}
	
	public  int[] getJumpList() {
		return jumpList;
	}
	
	public  int getAvg() {
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
	public void printList() {
		for (int i = 0; i < jumpList.length; i++) {
			if (jumpList[i] == 0) {
				i = jumpList.length;
			} else {
			System.out.println("Jump " + (i+1) + ": " + jumpList[i]);
			}
		}
	}
	
	public boolean getSuccess () {
	
		int test = 0;
		
		for (int i = 0; i < jumpList.length; i++) {
			
			test += jumpList[i];
				if (test < 0) {
					return false;
				} else if (test >= FrogSimulation.getGoalDist()) {
					return true;
				}
			
		}
		
		return false;
		
	}
	
}
