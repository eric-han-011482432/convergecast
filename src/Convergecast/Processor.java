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
    // here we are setting the processor ID and value, and setting its parent, left, and right processor values to null.
    public Processor(int id, int val) {
    		this.id = id;
    		value = val;
    		parent = null;
    		left = null;
    		right = null;
    }

}
