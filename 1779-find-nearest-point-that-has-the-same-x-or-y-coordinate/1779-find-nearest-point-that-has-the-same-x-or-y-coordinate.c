

int nearestValidPoint(int x, int y, int** points, int pointsSize, int* pointsColSize){
    int distance = -1;
    int index = -1;
    
    for(int i = 0; i < pointsSize; i++){
        if(points[i][0] == x || points[i][1] == y){
            int temp = (abs(x - points[i][0]) + abs(y - points[i][1]));
            if(distance == -1 || temp < distance){
                distance = temp;
                index = i;
            }
        }
    }
    
    return index;
}