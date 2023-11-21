/*Search in Infinite sorted array:

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the 
number in the array. Accessing an element out of bounds throws exception. If the 
number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.*/

/* accepted in LeetCode - this is a premium subscription question, I don't have access but i 
followed the lecture and logic to respond to this question*/
// tc is O(log n)and sc is O(1) 

var search = function(reader, target){
    let left =0;
    let right = 1;

    while(reader.get(right)< target){

        left = right;
        right = right*2;

    }

    while (left<=right){
        let mid = Math.floor(left+(right-left)/2);

        if(reader.get(mid) == target) return mid;

        if(reader.get(left)<= target && target< reader.get(mid)){
            right = mid-1;
        }else{
            left = mid+1
        }
    }
    return -1;
}