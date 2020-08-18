import java.util.*;

// Time Complexity : O(log N), N represents the number of elements in the array
// Space Complexity : O(N) , N repesents the number of elements in the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Some Compile errors


// Your code here along with comments explaining your approach
	/* This approach can be done by using ArrayList as they can have stream of data coming in. First We will check if the middle element is the target, we will check if the element at the start if lesser than mid element, if it is lesser, we will restrict our seach to left side 
    and check if the target is greater than start element and lesser than mid element. If the element is within this range, we will move the end pointer before the mid element,
     if the element is not within this range, we will move our st index to the right side of the mid element
     Similarly we do check for the right side of array.
     this is a modification of Binary search*/

public class Search_Rotated_Stream{
	
		public int search( ArrayList<Integer> al, int target) {
			
			int st = 0;
			int end = al.size()-1;
			
			while(st<=end) {
				int mid = st+(end-st)/2;
				
				if(target == al.get(mid)) {
					return mid;
				}
				else if(al.get(mid)>=al.get(st)) {
					if(target>=al.get(st) && target<al.get(mid))
						end = mid - 1;
					else st = mid+1;
				}
				else {
					if(target>al.get(mid) && target<=al.get(end))
						st = mid+1;
					else 
						end = mid-1;
				}
			}
			return -1;
		}
		public static void main(String [] args) {
			Search_Rotated_Stream sr = new Search_Rotated_Stream();
			ArrayList<Integer> al = new ArrayList<Integer>();
			al.add(20);
			al.add(30);
			al.add(0);
			al.add(40);
			al.add(90);
			al.add(50);
			al.add(60);
			int target = 50;
			System.out.println("Element found at index: "+sr.search(al, target));
		}

}
