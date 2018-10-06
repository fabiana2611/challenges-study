package br.study.java.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Looking for lerst point
 * 
 * @author fabiana
 *
 */
public class NearstPoint {

	  public List<List<Integer>> solution(List<List<Integer>> allLocations, 
              int numPoints){

		  System.out.println("allLocations: " + allLocations);
		  
		  HashMap<Double,List<Integer>> distancias = addHash(allLocations);
		  
		  List<Double> listOrder = ascOrder(distancias.keySet());
		  
		  System.out.println("listOrder: " + listOrder);
		  
		  List<List<Integer>> result = new ArrayList<List<Integer>>();
		  
		  System.out.println();
		  
		  int count = listOrder.size()-1;
		  for (int i = 1; i<=numPoints;i++) {
			  double dist = listOrder.get(count--);
			  System.out.println("Dist: " + dist);
			  System.out.println("Arr: " + distancias.get(dist));
			  result.add(distancias.get(dist));
		  }
		 
		  System.out.println("Result: " + result);
		  
		  return result;
	}
	  
	  private HashMap addHash(List<List<Integer>> allLocations) {
		  
		  System.out.println();
		  System.out.println("Criate arrays distance: ");
		  
		  double x1 = 0;
		  double y1 = 0;
		  
		  double distancia = 0.0;
		  
		  HashMap<Double,List<Integer>> hash = new HashMap<Double,List<Integer>>();
		  
		  for (List<Integer> l: allLocations) {
			  
			  distancia = (double) Math.sqrt( Math.pow( (x1 - l.get(0)),2 ) +
	                  Math.pow( (y1 - l.get(1)),2 ) );
			  
			  hash.put(distancia, l);
			  
			  System.out.println("Value: " + l + "Distnce: " + distancia);
			  
		  }
		  
		  System.out.println();
		  
		  return hash;
	  }
	  
	  private List<Double> ascOrder(Set<Double> keys) {
		  
		  List<Double> listOrder = new ArrayList<Double>(keys);
		  
		  /* Collections.sort method is sorting the 
	        elements of ArrayList in ascending order. */
		  Collections.sort(listOrder);
		  
		  System.out.println("keys: " + keys);

		  return listOrder;
	  }
	  
	  
}
