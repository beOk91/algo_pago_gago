import sys
class DeQueue:
    """
    push_front X: 정수 X를 덱의 앞에 넣는다.    
    push_back X: 정수 X를 덱의 뒤에 넣는다.
    pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 덱에 들어있는 정수의 개수를 출력한다.
    empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
    front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    """
    
    def __init__(self):
        self.queue = []

    def push_front(self, x):
        self.queue.insert(0,x)
    
    def push_back(self, x):
        self.queue.append(x)

    def pop_front(self):
        if self.isEmpty():
            return -1
        return self.queue.pop(0)
    
    def pop_back(self):
        if self.isEmpty():
            return -1
        return self.queue.pop()

    def size(self):
        return len(self.queue)

    def isEmpty(self):
        if len(self.queue) == 0 :
            return 1
        return 0
    
    def front(self):
        if self.isEmpty():
            return -1
        return self.queue[0]

    def back(self):
        if self.isEmpty():
            return -1
        return self.queue[-1]

if __name__ == "__main__":
    num_of_query = int(sys.stdin.readline())

    q = DeQueue()

    for _ in range(num_of_query):
        query = sys.stdin.readline().split()
        
        if query[0] == "push_front":
            q.push_front(int(query[1]))
        elif query[0] == "push_back":
            q.push_back(int(query[1]))
        elif query[0] == "pop_front":
            print(q.pop_front())
        elif query[0] == "pop_back":
            print(q.pop_back())
        elif query[0] == "size":
            print(q.size())
        elif query[0] == "empty":
            print(q.isEmpty())
        elif query[0] == "front":
            print(q.front())
        elif query[0] == "back":
            print(q.back())