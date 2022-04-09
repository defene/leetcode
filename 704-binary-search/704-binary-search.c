

int search(int* nums, int numsSize, int target){
    int high = numsSize - 1, low = 0;
    while(high >= low){
        int mid = (high - low) / 2 + low;
        if(target > nums[mid])
            low = mid + 1;
        else if(target < nums[mid])
            high = mid - 1;
        else 
            return mid;
    }
    
    return -1;
}