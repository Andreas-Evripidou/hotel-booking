package main;
import java.util.ArrayList;
import java.util.List;

import Facilities.*;

public class testing {
	
	public static void main (String [] args) {
		DatabaseCommunication db = new DatabaseCommunication();
		Validation v = new Validation();
		Person m = new Person("a", "a", "a", "a", 12343, 1, 1, "a");
		Address a = new Address("1", "s", "a", "23");
		
		
		ArrayList<Bathroom> baths = new ArrayList<>();
		baths.add(new Bathroom(true, true, true, true));
		
		ArrayList<Bedroom> bedding = new ArrayList<>();
		bedding.add(new Bedroom(Bed.stringToBed("Single Bed")));
		
		Sleeping sleeping = new Sleeping(bedding, true, true);
		Bathing bathing = new Bathing(baths, true, true, true);
		Kitchen k = new Kitchen(true, true, true, true, true, true, true, true);
		Living l = new Living(true, true, true, true, true, true);
		Outdoor o = new Outdoor(true, true, true, true, true);
		Utility u = new Utility(true, true, true, true, true, true);
		
		ArrayList<ChargeBand> cb = new ArrayList<>();
		cb.add(new ChargeBand("1-1-2021","1-1-2222", 122.0, 112.0, 111.0));
				
		Property property = new Property(cb, a, "Property1", "pellares", true, bathing, k, l, o, sleeping, u);
		
		v.validateProperty(m, property);
	}

}



