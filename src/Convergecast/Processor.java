package Convergecast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tphadke on 8/29/17.
 */
public class Processor {
	boolean isLeafNode = true;
    int id ;
    int value;
    int max;
    List<Processor> children ;
    Processor parent;
    
    public Processor(int id, int value) {
    		this.id = id;
    		this.value = value;
        children = new ArrayList<Processor>();
    }

    public int findMax(List<Processor> children) {
		ArrayList<Processor> children2 = new ArrayList<Processor>();
    		if(children.size() == 0 || children == null) {
    			return value;
    		}
    		for(Processor c : children) {
    			if (c.value> max) {
    				this.max = c.value;
    			}
			returnMax();
    			children2 = (ArrayList<Processor>) c.children;
    			findMax(children2);
    		}
    		return max;
    }
    
    public void returnMax() {
    		parent.max = max;
	}
    
}
