#  baekjoon 알고리즘 10845
# 2023.07.30 이주현


import sys
class Queue:
    """
    push X: 정수 X를 큐에 넣는 연산이다.
    pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 큐에 들어있는 정수의 개수를 출력한다.
    empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
    front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    """
    
    def __init__(self):
        self.queue = []

    def push(self, x):
        self.queue.append(x)

    def pop(self):
        if self.isEmpty():
            return -1
        return self.queue.pop(0)

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

    q = Queue()

    for _ in range(num_of_query):
        query = sys.stdin.readline().split()
        
        if query[0] == "push":
            q.push(int(query[1]))
        elif query[0] == "pop":
            print(q.pop())
        elif query[0] == "size":
            print(q.size())
        elif query[0] == "empty":
            print(q.isEmpty())
        elif query[0] == "front":
            print(q.front())
        elif query[0] == "back":
            print(q.back())
"""
15
push 1
push 2
front
back
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
front

1
2
2
0
1
2
-1
0
1
-1
0
3
"""