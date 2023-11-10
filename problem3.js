// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach in three sentences only

const search = function (reader, target) {
    let low = 0; high = 1
    //get the range of the array stream  o(logn)
    while (target > reader.get(high)) {
        low = high
        high = 2 * high
    }
    
    //binarySearch on the bounderies 
    while (low <= high) {
        let m = low + Math.floor((high - low) / 2)
        if (reader.get(m) === target) return m;
        if (reader.get(m) < target) {
            low = m + 1
        }
        else {
            high = m - 1
        }
    }
    return -1
};


class ArrayReader {
    constructor(arr) {
        this.arr = arr || [];
    }

    get(index) {
        return this.arr[index];
    }
}

const array = [-1,0,3,5,9,12];
const reader = new ArrayReader(array);

const target = 12;
const result = search(reader, target);

console.log(`Index of ${target}: ${result}`);


