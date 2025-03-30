class MinStack {
private:
    stack<int> st;
    stack<int> minst;

public:
    MinStack() { }
    
    void push(int val) {
        if (minst.empty() || minst.top() >= val) {
            minst.push(val);
        } 
        st.push(val);
    }
    
    void pop() {
        int val = st.top();
        st.pop();
        if (val == minst.top()) {
            minst.pop();
        }
    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return minst.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */