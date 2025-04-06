class Solution {
public:
    string stringShift(string s, vector<vector<int>>& shift) {
        int leftShiftTotal = 0;
        int rightShiftTotal = 0;
        for (auto& op : shift) {
            if (op[0]) {
                rightShiftTotal += op[1];
            } else {
                leftShiftTotal += op[1];
            }
        }

        int len = s.length();
        if(len == 0) return s; 
        
        int netShift = (rightShiftTotal - leftShiftTotal) % len;
        if(netShift < 0) netShift += len;
        
        return s.substr(len - netShift) + s.substr(0, len - netShift);
    }
};