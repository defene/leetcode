

int arraySign(int* nums, int numsSize){
    int signNeg = 0;
    int signZero = 0;
    
    for(int i = 0; i < numsSize; i++){
        if(nums[i] == 0) signZero++;
        else if(nums[i] < 0) signNeg++;
    }
    
    if(signZero) return 0;
    else if(signNeg % 2) return -1;
    else return 1;
}