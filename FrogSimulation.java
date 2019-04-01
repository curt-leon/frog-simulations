import java.util.*;


public class FrogSimulation {
	

		public static Random rand = new Random();
		public static Scanner sc = new Scanner(System.in);
		
		private static int goalDistance;
		private static int maxHops;
			
		public FrogSimulation (int dist, int numHops) {
			
			goalDistance = dist;
			maxHops = numHops;
			
		}
		
		private static int hopDistance() {
		
			int toReturn = rand.nextInt(100)-50;
			if (toReturn != 0) {
			return rand.nextInt(100)-50;
			} else {
				return hopDistance();
			}
		}
		
		public static boolean simulate() {
			System.out.println();
			int totDist = 0;
			int currentHop = 0;
			int[] frog = new int[maxHops];
			for (int i = 1; i <= maxHops; i++)
			{
				currentHop = hopDistance();
				System.out.println(currentHop);
				totDist += currentHop;
				frog[i-1] = currentHop;
					if (totDist < 0) {
						Frog tempFrog = new Frog (frog);
						Frog.frogList.add(tempFrog);
						return false;
					} else if (totDist >= goalDistance) {
						Frog tempFrog = new Frog (frog);
						Frog.frogList.add(tempFrog);
						return true;
					}	
			}
			Frog tempFrog = new Frog (frog);
			Frog.frogList.add(tempFrog);
			return false;
			
		}
		
		public static boolean[] runSimulations (int num) {
			boolean[] frogs = new boolean[num];
			for (int i = Frog.frogList.size()-1; i >= 0; i--) {
				Frog.frogList.remove(i);
			}
			for (int i = 0; i < num; i++) {
				frogs[i] = simulate();
				
			}
			
			return frogs;
			
		}
		
		
		public static void main(String[] args) {
			boolean frogs[] = null;
			
			while (true) {
				printMenu();
				int choice = sc.nextInt();
			switch (choice) {
			case 0:
			System.exit(0);
			break;
			case 1:
			System.out.println("What is your goal distance?");
			int dist = sc.nextInt();
			System.out.println("What is the maximum number of hops?");
			int hops = sc.nextInt();
			FrogSimulation frogSim = new FrogSimulation(dist, hops);
			break;
			case 2:
			System.out.println("How many times would you like to run a simulation?");
			int numTimes = sc.nextInt();
			frogs = runSimulations(numTimes);
			break;
			case 3:
			int tot = 0;
			double avg = 0;
			for (int i= 0; i<frogs.length; i++) {
			System.out.println("Frog " + (i+1) + ": " + frogs[i]);
			if (frogs[i]) {
			tot++;
			}
			}
			System.out.println("Total success: " + tot);
			avg = tot * 1.0;
			avg = avg / frogs.length;
			System.out.println("Success rate: " + avg);
			break;
			case 4:
			System.out.println("What frog would you like to learn more about?");
			int frogNum = sc.nextInt();
			Frog thisFrog = Frog.frogList.get(frogNum-1);
			Frog.printList();
			System.out.println("Average jumped :" + Frog.getAvg());
			break;
			}
			}
	}
		public static void printMenu() {
			System.out.println("------------FROG MENU------------\r\n" + 
					"[0]Quit\r\n" + 
					"[1]Create new parameters !!!!DO THIS FIRST!!!!\r\n" + 
					"[2]Run simulations\r\n" + 
					"[3]Print results\r\n" + 
					"[4]Learn more about one frog\r\n" +
					"");
		}
	}
