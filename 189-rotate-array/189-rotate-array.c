int swap;

void rotate(int* nums, int numsSize, int k){
    k = k % numsSize;
    if(k >= numsSize || k == 0) return;
    for(int i = 0; i < k; i++){
        swap = nums[i];
        nums[i] = nums[numsSize - k + i];
        nums[numsSize - k + i] = swap;
    }
    
    rotate(nums + k, numsSize - k, k);
}