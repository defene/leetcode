int happySum(int n){
    int sum = 0;
    
    while(n > 0){
        int digit = n % 10;
        sum += digit * digit;
        n /= 10;
    }
    
    return sum;
}

bool isHappy(int n){
    int slow = happySum(n);
    int fast = happySum(slow);
    
    while(fast != slow){
        if(fast == 1) return true;
        
        slow = happySum(slow);
        fast = happySum(fast);
        fast = happySum(fast);
    }
    
    if(fast == 1) return true;
    else return false;
}