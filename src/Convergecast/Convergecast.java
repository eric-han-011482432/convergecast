package Convergecast;

import java.util.ArrayList;

public class Convergecast {
	public static Processor root;
	ArrayList<Processor> processors = new ArrayList<Processor>();
	public int findMax(int[] values) {
		int max = 0;
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Convergecast cc = new Convergecast();
		cc.init();
	}
	
	public void init() {
		Processor p0 = new Processor(0,2);
		Processor p1 = new Processor(1,1);
		Processor p2 = new Processor(2,3);
		processors.add(p0);
		processors.add(p1);
		processors.add(p2);
		p0.children.add(p1);
		p1.children.add(p2);
		for(Processor p : processors) {
			setLeafNode(p);
		}
		for(Processor p : processors) {
			if(p.isLeafNode) {
				p.returnMax(p.max);
			}
		}
	}
	
    public void setLeafNode(Processor p) {
        if(p.children.size() >0) p.isLeafNode = false;
    }
    
    
    
}
