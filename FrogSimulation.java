import java.util.*;


public class FrogSimulation {
	
	//Initializes the RNG and the scanner
		public static Random rand = new Random();
		public static Scanner sc = new Scanner(System.in);
	//List of frogs added when simulations are run
		public static ArrayList<Frog> frogList = new ArrayList<Frog>();
	//more integers
		private static int goalDistance;
		private static int maxHops;
		
		public FrogSimulation (int dist, int numHops) {
			
			goalDistance = dist;
			maxHops = numHops;
			
		}
	
	//returns how far the frog hops, number from -50 to 50, excluding 0.
		private static int hopDistance() {
		
			int toReturn = rand.nextInt(100)-50;
			if (toReturn != 0) {
			return rand.nextInt(100)-50;
			} else {
				return hopDistance();
			}
		}
		
	//simulates one frog, returns whether or not the frog completes it's goal
	//frog fails if it goes negative to it starting position or if the goal distance is not met within the max number of hops
		public static boolean simulate() {
			System.out.println();
			int totDist = 0;
			int currentHop = 0;
		//the list of jumps each frog takes
			int[] frog = new int[maxHops];
		//simulates each hop
			for (int i = 1; i <= maxHops; i++)
			{
			//gets distance hopped
				currentHop = hopDistance();
				
			// test code, don't worry about this, can be commented out if neccesary
				System.out.println(currentHop);
			//adds the hop distance to it's total hop distance
				totDist += currentHop;
			//adds to the list	
				frog[i-1] = currentHop;
					if (totDist < 0) {
					//creates a Frog based on these values
						Frog tempFrog = new Frog (frog);
						frogList.add(tempFrog);
						return false;
					} else if (totDist >= goalDistance) {
					//creates a Frog based on these values
						Frog tempFrog = new Frog (frog);
						frogList.add(tempFrog);
						return true;
					}	
			}
		//creates a Frog based on these values
			Frog tempFrog = new Frog (frog);
			frogList.add(tempFrog);
			return false;
			
		}
	//runs a number of simulations
		public static boolean[] runSimulations (int num) {
		//list of which frog was successful
			boolean[] frogs = new boolean[num];
		//clears the frogList of the last run simulations
			for (int i = frogList.size()-1; i >= 0; i--) {
				frogList.remove(i);
			}
		//runs a simulation of each frog
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
						Frog thisFrog = frogList.get(frogNum-1);
						thisFrog.printList();
						System.out.println("Average jumped :" + thisFrog.getAvg());
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
