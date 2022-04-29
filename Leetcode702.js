// Time Complexity : O(log n) since it's binary search
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No



// Your code here along with comments explaining your approach
Since it's interface approach so used get method to get value of each index and rest as mentioned to solve in 0(log n) approach so used binary approach.


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
    var left = 0;
    var right = 10000;
    while(left<=right)
    {
        var mid = Math.floor((left+right)/2);
        if(reader.get(mid)===target)
        {
            return mid;
        }
        else if(reader.get(mid)<target)
        {
            left = mid+1;
        }
        else if(reader.get(mid)>target)
        {
            right = mid-1;
        }
    }
    return -1;
};
    