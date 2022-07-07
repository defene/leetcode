int hammingWeight(uint32_t n) {
    int number = 0;
    
    for(int i = 0; i < 32; i++){
        if(n & 1) number++;
        n = n >> 1;
    }
    
    return number;
}