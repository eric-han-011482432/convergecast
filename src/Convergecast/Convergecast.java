package Convergecast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Convergecast {
	public static Processor root;
	ArrayList<Processor> processors = new ArrayList<Processor>();
	LinkedHashMap<Processor,Integer> values = new LinkedHashMap<Processor,Integer>();

	public static void main(String[] args) {
		System.out.println("Inside Convergecast main method");
		Convergecast cc = new Convergecast();
		cc.init();
	}
	
	public void init() {
		Processor p0 = new Processor(0,23);
		Processor p1 = new Processor(1,25);
		Processor p2 = new Processor(2,99);
		Processor p3 = new Processor(3,85);
		Processor p4 = new Processor(4,33);
		processors.add(p0);
		processors.add(p1);
		processors.add(p2);
		processors.add(p3);
		processors.add(p4);
		p1.right = p4;
		p0.left = p1;
		p1.left = p2;
		p2.left = p3;
		p1.parent = p0;
		p2.parent = p1;
		p3.parent = p2;
		p0.parent = null;
		p4.parent = p1;
		for(Processor p : processors) {
			setLeafNode(p);
			setRoot(p);
		}
		findMax(root);
		String concatenatedIntegers = "";
		for(Entry<Processor,Integer> entry: values.entrySet()) {
			Processor p = entry.getKey();
			int i = entry.getValue();
			System.out.println("Processor#" +p.id +" has max value of " +i);
			concatenatedIntegers +=i;
		}
		root.concatenated = concatenatedIntegers;
		System.out.println("Root has values of all the nodes concatenated: " +root.concatenated);
	}
	
	public int findMax(Processor node) {
		if(node==null) return Integer.MIN_VALUE;
		else {
			int max = Max(node.value, findMax(node.left), findMax(node.right));
			System.out.println("Maximum value found so far at Processor#" + node.id+ " is: " + max);
			values.put(node, max);
			return max;
		}
	}
	
	public int Max(int nodevalue, int leftvalue, int rightvalue) {
		ArrayList<Integer> maxValues = new ArrayList<Integer>();
		maxValues.add(nodevalue);
		maxValues.add(leftvalue);
		maxValues.add(rightvalue);
		int max = Collections.max(maxValues);
		return max;
	}
	
	public void setRoot(Processor p) {
		if(p.parent==null) {
			root = p;
			p.isRoot = true;
		}
	}
	
    public void setLeafNode(Processor p) {
    		if(p.left == null && p.right == null) p.isLeafNode = true;
    }
     
}
