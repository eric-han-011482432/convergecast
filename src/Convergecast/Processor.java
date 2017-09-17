package Convergecast;

public class Processor {
	boolean isLeafNode = true;
    int id ;
    int value;
    String concatenated;
    boolean isRoot = false;
    Processor left;
    Processor right;
    Processor parent;
    
    public Processor(int id, int val) {
    		this.id = id;
    		value = val;
    		parent = null;
    		left = null;
    		right = null;
    }

}
