

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* sortedSquares(int* nums, int numsSize, int* returnSize){
    int *first, *last;
    int *square = (int *)malloc(sizeof(int) * numsSize);
    first = nums;
    last = nums + numsSize - 1;
    
    for(int i = numsSize - 1; i >= 0; i--) {
        int s1 = (*first) * (*first),
            s2 = (*last) * (*last);
        if(s1 < s2){
            square[i] = s2;
            last--;
        } else {
            square[i] = s1;
            first++;
        }
    }
    
    *returnSize = numsSize;
    
    return square;
}