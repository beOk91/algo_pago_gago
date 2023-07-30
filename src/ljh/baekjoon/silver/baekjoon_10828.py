#  baekjoon 알고리즘 10828
# 2023.07.29 이주현
import sys
class Stack:
    """
    push X: 정수 X를 스택에 넣는 연산이다.
    pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 스택에 들어있는 정수의 개수를 출력한다.
    empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
    top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    """
    def __init__(self):
        self.stack = []

    def push(self, x):
        self.stack.append(x)

    def pop(self):
        if self.isEmpty():
            return -1
        return self.stack.pop()

    def size(self):
        return len(self.stack)

    def isEmpty(self):
        if len(self.stack) == 0 :
            return 1
        return 0
    
    def top(self):
        if self.isEmpty():
            return -1
        return self.stack[-1]

if __name__ == "__main__":
    num_of_query = int(sys.stdin.readline())

    s = Stack()

    for _ in range(num_of_query):
        query = sys.stdin.readline().split()
        
        if query[0] == "push":
            s.push(int(query[1]))
        elif query[0] == "top":
            print(s.top())
        elif query[0] == "pop":
            print(s.pop())
        elif query[0] == "size":
            print(s.size())
        elif query[0] == "empty":
            print(s.isEmpty())
