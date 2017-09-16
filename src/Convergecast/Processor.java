package Convergecast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tphadke on 8/29/17.
 */
public class Processor {
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

    public void addToChildren(Processor p) {
    		if(!children.contains(p)) {
    			children.add(p);
    		}
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
    			children2 = (ArrayList<Processor>) c.children;
    			findMax(children2);
    		}
    		findMax(children);
    		returnMax(max);
    		return max;
    }
    
    private void returnMax(int maximum) {
    		parent.max = maximum;
	}

	public int getId() {
    		return this.id;
    }
    
    public int getValue() {
    		return this.value;
    }
    
    public int getMax() {
    		return this.max;
    }
    
}
