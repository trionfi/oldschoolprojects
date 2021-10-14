import java.io.*; //import io class
import java.util.*;
import javax.swing.JOptionPane; //import message dialogs  //standard imports I copy into everything
import weka.core.*;

public class ID3{
	public static void main(String args[]) throws IOException{
		 BufferedReader reader = new BufferedReader(new FileReader("weather.nominal.arff"));
		ArffReader arff = new ArffReader(reader, 1000);
		Instances data = arff.getStructure();
		data.setClassIndex(data.numAttributes() - 1);
		Instance inst;
		while ((inst = arff.readInstance(data)) != null) {
			data.add(inst);
		}
		
		for (int i = 0; i <= data.numInstances - 1; i++) {
    Instance instance = data.getInstance(i);
    System.out.println(instance.stringValue(0)); //get Attribute 0 as String
}
	}
}