class MedianFinder {
private:
    priority_queue<int> maxHeap; 
    priority_queue<int, vector<int>, greater<int>> minHeap;

public:
    MedianFinder() { }
    
    void addNum(int num) {
        if (maxHeap.empty() || num <= maxHeap.top())
            maxHeap.push(num);
        else
            minHeap.push(num);

        balanceHeaps();
    }
    
    double findMedian() {
        if (maxHeap.size() > minHeap.size())
            return (double)maxHeap.top();
        else if (minHeap.size() > maxHeap.size())
            return (double)minHeap.top();
        else
            return (maxHeap.empty() ? 0 : ((double)maxHeap.top() + minHeap.top()) / 2);
    }

private:
    void balanceHeaps() {
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.push(maxHeap.top());
            maxHeap.pop();
        } else if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.push(minHeap.top());
            minHeap.pop();
        }
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */