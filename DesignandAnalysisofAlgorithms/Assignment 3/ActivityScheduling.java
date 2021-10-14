import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything

public class ActivityScheduling{
	public static void main(String args[]) throws IOException{
		List<Long> input = new ArrayList<Long>();
		List<Long> start = new ArrayList<Long>();
		List<Long> end = new ArrayList<Long>();
		
		if(args.length > 0) {
			File file = new File(args[0]);
			try{
				Scanner scanner = new Scanner(file);
			
				while(scanner.hasNextLine()){
					String line = scanner.nextLine();
					String[] x = line.split("	");
						for(String y : x){
							Long add = Long.parseLong(y);
							input.add(add);
						}
				}
				/*for(int i = 0; i < input.size(); i++)
					System.out.println(input.get(i));*/
				int repeat = input.get(0).intValue(); //# repeats
				int pointer = 1;
				long value;
				String output;
				FileWriter writer = new FileWriter(args[1]);
				BufferedWriter wr = new BufferedWriter(writer);
				for(int i = 0; i < repeat; i++){
					int arr = input.get(pointer).intValue() * 2;
					for(int j = pointer + 1; j <= pointer + arr; j+=2){
							start.add(input.get(j));
							end.add(input.get(j + 1));
					}
					
					int counter = schedule(start, end);
					output = "" + counter;
					wr.write(output);
					wr.newLine();
					pointer = pointer + arr + 1;
					start.clear();
					end.clear();
				}
				
				wr.flush();
				wr.close();
				
			}
			catch (FileNotFoundException e){
				System.out.println("File Not Found");
			}
			
		}
		//for(int init: input)
		//	System.out.println(init);
	}
	public static int schedule(List<Long> start, List<Long> end){
		for(int i = (start.size() - 1); i >= 0; i--){ //sort by finish time
			for(int j = 1; j <= i; j++){
				if(end.get(j-1) > end.get(j)){
					long temp1 = end.get(j-1);
					long temp2 = start.get(j-1);
					end.set(j-1, end.get(j));
					start.set(j-1, start.get(j));
					end.set(j, temp1);
					start.set(j, temp2);
				}
			}
		}
		int counter = 1;
		int i = 0;
		for(int j = 1; j < start.size(); j++){
			if(start.get(j) >= end.get(i)){
				counter++;
				i = j;
			}
		}
		return counter;
	}

}