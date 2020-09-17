package com.java.binaryserach.leetcode;

public class _702_SearchinaSortedArrayofUnknownSize {

	public int search(ArrayReader reader, int target) {

		int beginIndex = 0;
		int endIndex = 1;
		int mid = beginIndex + (endIndex - beginIndex)/2; 

		while(reader.get(endIndex) < target){
			beginIndex = endIndex;
			endIndex = endIndex*2;
		}

		while(beginIndex <= endIndex){

			mid = beginIndex + (endIndex - beginIndex)/2; 

			if(reader.get(mid) == target){
				return mid;
			}
			else if(reader.get(mid) < target){
				beginIndex = mid + 1;
			}
			else{
				endIndex = mid - 1; 
			} 
		}    
		return -1;
	}

}
