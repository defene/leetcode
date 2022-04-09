// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

int firstBadVersion(int n) {
    int high = n, low = 1;
    while(high >= low){
        int mid = (high - low) / 2 + low;
        if(isBadVersion(mid))
            high = mid - 1;           
        else
            low = mid + 1;
    }
    
    return low;
}