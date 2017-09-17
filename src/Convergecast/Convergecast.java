package Convergecast;

import java.util.ArrayList;
import java.util.Collections;

public class Convergecast {
	public static Processor root;
	ArrayList<Processor> processors = new ArrayList<Processor>();

	public static void main(String[] args) {
		System.out.println("Inside Convergecast main method");
		Convergecast cc = new Convergecast();
		cc.init();
	}
	
	public void init() {
		Processor p0 = new Processor(0,101111111);
		Processor p1 = new Processor(1,100000000);
		Processor p2 = new Processor(2,99);
		Processor p3 = new Processor(3,999999);
		processors.add(p0);
		processors.add(p1);
		processors.add(p2);
		processors.add(p3);
		p0.left = p1;
		p1.left = p2;
		p2.left = p3;
		p1.parent = p0;
		p2.parent = p1;
		p3.parent = p2;
		p0.parent = null;
		for(Processor p : processors) {
			setLeafNode(p);
			setRoot(p);
		}
		findMax(root);
	}
	
	public int findMax(Processor node) {
		if(node==null) return Integer.MIN_VALUE;
		else return Max(node.value, findMax(node.left), findMax(node.right));
	}
	
	public int Max(int nodevalue, int leftvalue, int rightvalue) {
		ArrayList<Integer> maxValues = new ArrayList<Integer>();
		maxValues.add(nodevalue);
		maxValues.add(leftvalue);
		maxValues.add(rightvalue);
		int max = Collections.max(maxValues);
		System.out.println("Maximum value found is: " + max);
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
