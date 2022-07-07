int cmp(const void *a, const void *b){
    return (*(int *)b - *(int *)a);
}

int largestPerimeter(int* nums, int numsSize){
    qsort(nums, numsSize, sizeof(int), cmp);
    
    int i = 0;
    for(; i < numsSize - 2; i++){
        if(nums[i] < nums[i + 1] + nums[i + 2]) break;
    }
    
    if(i >= numsSize - 2)
        return 0;
    else 
        return nums[i] + nums[i + 1] + nums[i + 2];
}