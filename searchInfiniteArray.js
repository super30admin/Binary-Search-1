var binSearch = (arr,low,high,x) => {

    var mid = Math.floor((low+high)/2);
    if(low <= high) {
        if (arr[mid] == x) {
            return mid;
        } else if (x > arr[mid]) {
            return binSearch(arr, mid + 1, high, x);
        } else {
            return binSearch(arr, low, mid - 1, x);
        }
        return -1;
    }

}

var findIndex =(arr,key)=>{
    var low = 0;
    var high = 1;
    var val = arr[high];

    while(val < key){

        low = high;
        //To prevent array out of bounds exception
        if((2*high) < (arr.length-1)) {
            high = 2 * high;
        } else{
            high = arr.length -1;
        }

        val = arr[high];

    }

    return binSearch(arr,low,high,key);

}