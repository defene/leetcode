

int arraySign(int* nums, int numsSize){
    int signNeg = 0;
    
    for(int i = 0; i < numsSize; i++){
        if(nums[i] == 0) return 0;
        else if(nums[i] < 0) signNeg++;
    }
    
    if(signNeg % 2) return -1;
    else return 1;
}