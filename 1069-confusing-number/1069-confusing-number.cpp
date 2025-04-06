class Solution {
public:
    bool confusingNumber(int n) {
        unordered_map<int, int> validMap;
        validMap[0] = 0;
        validMap[1] = 1;
        validMap[6] = 9;
        validMap[8] = 8;
        validMap[9] = 6;
        
        int rotateNum = 0;
        int nCopy = n;
        while (n != 0) {
            int curNum = n % 10;
            n = n / 10;

            if (validMap.find(curNum) != validMap.end()) {
                rotateNum = rotateNum * 10 + validMap[curNum];
            } else {
                return false;
            }
        }
        
        return rotateNum != nCopy;
    }
};