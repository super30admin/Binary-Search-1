//Ran Successfully on leetCode - solution accepted
//Time: O(logk), where k is an index of target value, Space O(1)
var search = function (reader, target) {
    // if(reader.get(0) == Integer.MAX_VALUE) return -1;
    let low = 0, high = 1;
    while(reader.get(high) < target){
        low = high;
        high = high * 2;
    }
    return find_element(reader,target,low,high);
};

function find_element(reader,target,low,high){
    while(low<=high){
        let mid = low + Math.floor((high-low)/2);
        if(reader.get(mid) == target) {
            return mid;
        }
        else if(target > reader.get(mid)){
            low = mid + 1;
        }else{
            high = mid -1;
        }
    }
    return -1;
}