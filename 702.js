// Time Complexity : O(Log n) where n is length of the reader [1, 10^4]
// Space Complexity : O(1) constant space solution
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not a good solution. Can be optimised.

/**
Algorithm :

1. Brute force

We simply iterate through the reader and compare with the target
TC : O(n) for n is the length of the reader.

2. Binary search

Since the reader is sorted, we can apply Binary Search to reduce TC to O(LogN)
The length of the underlying array as mentioned in question is required for Binary Search.

This can be improved by not defining the lower and upper limits and instead defining them.
**/

/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * function ArrayReader() {
 *
 *     @param {number} index
 *     @return {number}
 *     this.get = function(index) {
 *         ...
 *     };
 * };
 */

/**
 * @param {ArrayReader} reader
 * @param {number} target
 * @return {number}
 */
var search = function (reader, target) {
    let low = -9999;
    let hi = 10000;
    let mid = 0;
    let f = 2147483647;
    
    while(low<hi){
        
        mid = Math.floor(low + (hi - low)/2);
        
        if(reader.get(mid) === f || reader.get(mid) > target){
            
            hi = mid;
        }
        else 
            
            low = mid + 1;
        
    }
    
    return reader.get(low-1) === target ? low-1 : -1;
};