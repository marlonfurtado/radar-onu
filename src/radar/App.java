package radar;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class App {

	public static void main(String[] args) {
		System.out.println("Loading file...");
		Map<String, Object> dataCamp = ReaderFile.read("src/data/caso001");
		System.out.println("OK!\n");

		Integer heightCamp = (Integer)dataCamp.get("height");
		Integer weightCamp = (Integer)dataCamp.get("weight");
		Integer totalMines = (Integer)dataCamp.get("totalMines");
		Map<Integer, Integer> mines = (TreeMap<Integer, Integer>) dataCamp.get("mines");
		
		ArrayList<Integer> column = new ArrayList<>();
        Histogram histogram = new Histogram();

        int maxArea = 0;
        int area = 0;

        for(int x=1; x<=weightCamp; x++) {

        	if(mines.containsKey(x)) {
        		column.add(mines.get(x) - 1);
        	} else {
        		column.add(heightCamp);
        	}

        	area = histogram.maxArea(column);
        	if(area > maxArea){
        		maxArea = area;
        	}

        }

		System.out.println("ÁREA: " + maxArea);
		System.out.println("FIM!");
	}	
}