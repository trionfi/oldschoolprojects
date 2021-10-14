/*  *~*~*~*~*~*~*~*
	Name: Alexandra Paramor
	Student #: 151365
	Date: October 20, 2015
	Course: 62:160 Computer Science I
	Instructor: Ashraf Abdelbar
	Program: Asks for 3 runners and their race time in minutes, and then orders them by the order they finished
	*~*~*~*~*~*~*~* */
import javax.swing.JOptionPane; //import dialog box class

public class RunningRace{
	public static void main(String[] args){
		String runnerOne, runnerTwo, runnerThree; //variables for names
		String firstPlace = "N/A", secondPlace = "N/A", thirdPlace = "N/A"; //variables for placings
		int runnerOneTime, runnerTwoTime, runnerThreeTime; //variables for times
		String input; //input variable
		
		runnerOne = JOptionPane.showInputDialog("Input first runner's name:"); //first runner's name
		input = JOptionPane.showInputDialog("Input first runner's race time (in minutes):"); //first runner's time
		runnerOneTime = Integer.parseInt(input); //convert to Int
		runnerTwo = JOptionPane.showInputDialog("Input second runner's name:"); //second runner's name
		input = JOptionPane.showInputDialog("Input second runner's race time (in minutes):"); //second runner's time
		runnerTwoTime = Integer.parseInt(input); //conver to int
		runnerThree = JOptionPane.showInputDialog("Input third runner's name:"); //third runner's name
		input = JOptionPane.showInputDialog("Input third runner's race time (in minutes):"); //third runner's time
		runnerThreeTime = Integer.parseInt(input); //convert to int
		
		if (runnerThreeTime < runnerTwoTime && runnerTwoTime < runnerOneTime){  //if runner three's time is less than runner two's time and runner two's time is less than runner one's time (321)
			firstPlace = runnerThree;
			secondPlace = runnerTwo;
			thirdPlace = runnerOne;
		}
		else if (runnerThreeTime < runnerOneTime && runnerOneTime < runnerTwoTime){ //if runner three's time is less than runner one's time, and runner one's time is less than runner two's time 312
			firstPlace = runnerThree;
			secondPlace = runnerOne;
			thirdPlace = runnerTwo;
		}
		else if ((runnerTwoTime < runnerThreeTime) && (runnerThreeTime < runnerOneTime)){ //if runner two's time is less than runner three's time, and runner three's time is less than runner one's time (231)
			firstPlace = runnerTwo;
			secondPlace = runnerThree;
			thirdPlace = runnerOne;
		}
		else if ((runnerTwoTime < runnerOneTime) && (runnerOneTime < runnerThreeTime)){ //if runner two's time is less than runner one's time, and runner one's time is less than runner three's time (213)
			firstPlace = runnerTwo;
			secondPlace = runnerOne;
			thirdPlace = runnerThree;
		}
		else if ((runnerOneTime < runnerThreeTime) && (runnerThreeTime < runnerTwoTime)){ //if runner one's time is less than runner two's time, and runner two's time is less than runner three's time (132)
			firstPlace = runnerOne;
			secondPlace = runnerThree;
			thirdPlace = runnerTwo;
		}
		else if ((runnerOneTime < runnerTwoTime) && (runnerTwoTime < runnerThreeTime)){ //if runner one's time is less than runner two's time, and runner two's time is less than runner three's (123)
			firstPlace = runnerOne;
			secondPlace = runnerTwo;
			thirdPlace = runnerThree;
		}
		else if (runnerOneTime == runnerTwoTime && !(runnerOneTime == runnerThreeTime)){ //if runner one and two were equal
			if (runnerOneTime < runnerThreeTime){ //if runner three's time was greater than runner one's
				firstPlace = runnerOne + " and " + runnerTwo;
				secondPlace = runnerThree;
			}
			else{
				firstPlace = runnerThree; //if runner three's time was less than runner one's
				secondPlace = runnerOne + " and " + runnerTwo;
			}
		}
		else if (runnerOneTime == runnerThreeTime && !(runnerOneTime == runnerTwoTime)){ //if runner one and three were equal
			if (runnerOneTime < runnerTwoTime){ //if runner two's time was greater than runner one's time
				firstPlace = runnerOne + " and " + runnerThree;
				secondPlace = runnerTwo;
			}
			else{
				firstPlace = runnerTwo; //if runner three's time was less than runner one's
				secondPlace = runnerOne + " and " + runnerThree;
			}
		}
		else if (runnerTwoTime == runnerThreeTime && !(runnerTwoTime == runnerOneTime)){ //if runner two and three are equal
			if(runnerTwoTime < runnerOneTime){ //if runner two was less than runner one
				firstPlace = runnerTwo + " and " + runnerThree;
				secondPlace = runnerOne;
			}
			else{
				firstPlace = runnerOne; //if runner two was greater than runner one
				secondPlace = runnerTwo + " and " + runnerThree;
			}
		}
		else{ // if everything is equal
			firstPlace = runnerOne + ", " + runnerTwo + ", and " + runnerThree;
		}
		
		JOptionPane.showMessageDialog(null, runnerOne + "'s time was " + runnerOneTime + ", " + runnerTwo + "'s time was " + runnerTwoTime + ", and " + runnerThree + "'s time was " + runnerThreeTime + //output data
											"\nFirst Place: " + firstPlace + 
											"\nSecond Place: " + secondPlace + 
											"\nThird Place: " + thirdPlace);
											
		System.exit(0); //exit program
		
	}

}