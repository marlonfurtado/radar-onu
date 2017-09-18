package radar;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Histogram {

	public Integer maxArea(ArrayList<Integer> column) {
		Deque<Integer> stack = new LinkedList<Integer>();
		int maxArea = 0;
		int area = 0;

		for(int i=0; i < column.size();){
			if(stack.isEmpty() || column.get(stack.peekFirst()) <= column.get(i)){
				stack.addFirst(i++);
			}
			else{
				int top = stack.pop();
				
				if(stack.isEmpty()){
					area = column.get(top) * i;
				}			
				else{
					area = column.get(top) * (i - stack.peekFirst() - 1);
				}
				if(area > maxArea){
					maxArea = area;
				}
			}
		}
		
		return maxArea;
	}
}