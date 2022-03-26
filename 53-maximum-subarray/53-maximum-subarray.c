int max(int a, int b){
    if(a > b) return a;
    else return b;
}

int maxSubArray(int* nums, int numsSize){
    int pre = 0, cur = nums[0];
    for(int i = 0; i < numsSize; i++){
        pre = max(nums[i] + pre, nums[i]);
        cur = max(pre, cur);
    }
    return cur;
}