int cmp(const void *a, const void *b){
    return *(int *)a - *(int *)b;
}

bool canMakeArithmeticProgression(int* arr, int arrSize){
    qsort(arr, arrSize, sizeof(int), cmp);
    
    int width = arr[0] - arr[1];
    for(int i = 0; i < arrSize - 1; i++){
        if(arr[i] - arr[i + 1] != width) return false;
    }
    
    return true;
}