# 斐波那契数列

# 循环模式
def mode01():
    n = []
    for i in range(30):
        m = 1
        if i > 1:
            m = n[i - 2] + n[i - 1]
        print(m, end="\t")
        n.append(m)
    print()
    print(n)

# 递归模式 ???
def mode02(m1,m2):
    n=[]
    pass

if __name__ == '__main__':
    mode01()
