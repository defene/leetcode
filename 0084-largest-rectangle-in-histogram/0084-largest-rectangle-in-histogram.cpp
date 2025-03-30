class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        stack<int> st;
        st.push(-1);
        int result = 0;
        for (int i = 0; i < heights.size(); i++) {
            while (st.top() != -1 && heights[st.top()] >= heights[i]) {
                int curr_height = heights[st.top()];
                st.pop();
                int curr_width = i - st.top() - 1;
                result = max(curr_width * curr_height, result);
            }
            st.push(i);
        }
        while (st.top() != -1) {
            int curr_height = heights[st.top()];
            st.pop();
            int curr_width = heights.size() - st.top() - 1;
            result = max(curr_width * curr_height, result);          
        }

        return result;
    }
};