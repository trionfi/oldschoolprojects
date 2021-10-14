/*
Name: Alexandra Paramor
Program name: clusters
Class: Data Mining
Date: March 11th, 2019

to compile: javac -cp .;weka.jar Clusters.java
 */

//import classes
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.lang.*;
import java.util.*;

import weka.core.Attribute;
import weka.core.AttributeStats;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.InstanceComparator;

public class Clusters{
	public static void main(String args[]) throws Exception{
		 // Read all the instances in the file
		 String endClass = args[2].toUpperCase();
		 int atts = 0;
		 if(endClass.compareTo("YES") != 0 && endClass.compareTo("NO") != 0){ //check for class variable indication
			 System.out.println("Please input 'yes' or 'no' at the end to indicate if there is a class or not");
		 }
		 else{
			String fileName = args[0];
			int numCluster = Integer.parseInt(args[1]);
		
			DataSource source = new DataSource(fileName + ".arff");
			Instances instances = source.getDataSet();
			
			// Make the last attribute be the class
			if(endClass.compareTo("YES") == 0){
			instances.setClassIndex(instances.numAttributes() - 1);
				atts = instances.numAttributes() - 1;
			}
			else{
				atts = instances.numAttributes();
			}
			int numeric = 0; //check to see if all attributes are numeric
			for(int i = 0; i < atts; i++){
				if(instances.attribute(i).isNumeric())
					numeric++;
			}
			
			//System.out.println("Numeric: " + numeric + " atts: " + atts);
			if(numeric != atts){ //check if everything is numeric
				System.out.println("Please use a file with all numeric attributes.");
			}
			else{
				int total = instances.numInstances();
				Instance[] center = initialCenterPoints(instances, numCluster, atts); //find initial centers
				for(int i = 0; i < center.length; i++){
					System.out.println("Centroid " + i + ": " + center[i].toString());
				}
				System.out.println();
				
				//System.out.println();
				//System.out.println(instances.numInstances());
				//System.out.println(euclidean(instances.get(0), center[0], atts)); 
				Instances[] clusters = distribute(instances, center, numCluster, atts, total); //distribute Instances based on initial centroids
				for(int i = 0; i < clusters.length; i++){
					System.out.println("Number of instances in cluster " + i + ": " + clusters[i].numInstances()); 
				}
				System.out.println();
				
				normalize(instances, clusters, center, numCluster, atts, 1, args[0], total); //find averages and stuff
				
				
			}
		 }

	}
	
	public static void normalize(Instances insta, Instances[] clusters, Instance[] center, int c, int atts, int pass, String name, int total) throws Exception{
		System.out.println("New Pass");
		System.out.println();
		Instances[] newClusters = new Instances[c]; 
		for (int i = 0; i < c; i++) { //initialize clusters
			newClusters[i] = new Instances(insta, insta.numInstances());
		}
		
		newCenters(clusters, center, atts); //find new centers (fake centers)
		newClusters = distribute(insta, center, c, atts, total); //get new clusters based on centers
		
		for(int i = 0; i < center.length; i++){
				System.out.println("Centroid " + i + ": " + center[i].toString());
			}
		System.out.println();
		for(int i = 0; i < newClusters.length; i++){
				System.out.println("Number of instances in cluster " + i + ": " + newClusters[i].numInstances());
			}
		System.out.println();
		
		if(instancesCompare(clusters, newClusters)){ //see if new clusters are the same as the last set
			System.out.println("done. number of Passes: " + pass);
			for(int i = 0; i < newClusters.length; i++){
				String fileName = name + (i + 1) + ".arff";
				File file = new File(fileName);
				PrintWriter pw = new PrintWriter(file);
				pw.println(newClusters[i].toString());
				pw.close();
			}
		}
		else{
			normalize(insta, newClusters, center, c, atts, pass + 1, name, total); //otherwise do it again
		}
	}
	
	public static boolean instancesCompare(Instances[] instances1, Instances[] instances2){ //comparing clusters
		InstanceComparator compare = new InstanceComparator(); //instance comparator object
		
		for(int i = 0; i < instances1.length; i++){
			for(int j = 0; j < instances1[i].numInstances(); j++){
				if(instances1[i].numInstances() != instances2[i].numInstances()){ //if lengths are not the same between instances, return
					return false;
				}
				else{
					if(compare.compare(instances1[i].instance(j), instances2[i].instance(j)) != 0){ //if any instance is not the same, return
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static void newCenters(Instances[] clusters, Instance[] center, int atts){
		for(int i = 0; i < center.length; i++){
			for(int j = 0; j < atts; j++){
				center[i].setValue(j, attMean(clusters[i], center[i].attribute(j))); //fake centers
			}
		}
	}
	
	public static double attMean(Instances insta, Attribute att){ //averages
		double mean = 0.0;
		for(int i = 0; i < insta.numInstances(); i++){
			mean += insta.instance(i).value(att);
		}
		return mean/insta.numInstances();
	}
	
	public static Instances[] distribute(Instances inst, Instance[] center, int c, int atts, int total){
		Instances[] clusters = new Instances[c]; //initialize cluster instances arrays
		for (int i = 0; i < c; i++) {
			clusters[i] = new Instances(inst, inst.numInstances()); //initialize instances
		}
		double min = 0.0;
		int index = 0;
		
		for(int i = 0; i < inst.numInstances(); i++){ //for each instance, find which centroid is closest
			for(int j = 0; j < c; j++){
				if(normEuclidean(inst.instance(i), center[j], atts, total) == 0)
					index = j;
				else{
					if(min == 0.0){
						min = normEuclidean(inst.instance(i), center[j], atts, total);
						index = j;
					}
					if(normEuclidean(inst.instance(i), center[j], atts, total) <= min){
						min = normEuclidean(inst.instance(i), center[j], atts, total);
						index = j;
					}
				}
			}
			Instance insta = inst.get(i);
			clusters[index].add(insta);
			min = 0.0;
			index = 0;
			
		}
		
		return clusters;
	}
	
	public static Instance[] initialCenterPoints(Instances ints, int c, int atts){
		Instance[] center = new Instance[c]; //nonsense I have to do so that my fake instances don't overwrite real data
		Instances[] centerCopy = new Instances[c];
		Instance[] centerCopy2 = new Instance[c];
		
		for(int i = 0; i < c; i++){
			centerCopy[i] = new Instances(ints, 1);
		}
		int[] index = new int[c];
		for(int i = 0; i < c; i++){
			index[i] = -1;
		}
		int sentinal = 1;
		int rand = -1;
		
		for(int i = 0; i < c; i++){ //find random instance
			do{
				rand = random(0, ints.numInstances() - 1);
				center[i] = ints.instance(rand);
				index[i] = rand;
				for(int j = 0; j < c; j++){
					if(index[j] == rand){
						sentinal = 1;
						if(j == i){
							sentinal = 0;
						}
					}
	
				}
			}while (sentinal == 1); //make sure it doesn't pick the same one twice
			sentinal = 1;
		}
		
		for(int i = 0; i < c; i++){ //copy instances into another Instances so pointers are different from original data
			centerCopy[i].add(center[i]);
			centerCopy2[i] = centerCopy[i].get(0);

		}
		return centerCopy2; //return better pointers
	}
	public static double normEuclidean(Instance a, Instance b, int atts, int total){ //euclidean distances
		double distance = 0.0;
		for(int i = 0; i < atts; i++){
			distance += Math.pow(a.value(i) - b.value(i), 2)/(double) total;
		}
		return Math.sqrt(distance);
	}
	
	public static int random(int max, int min){
		int range = (max - min) + 1;
		return (int)(Math.random() * range) + min;
	}
	
}