# 排序算法

# 冒泡排序 使用中间变量交换值
def fun01():
    arr = [34, 20, 76, 84, 46, 11, 98, 39, 5, 10]
    l = len(arr)
    for i in range(l - 1):
        for j in range(l - i - 1):
            if arr[j + 1] < arr[j]:
                tmp = arr[j + 1]
                arr[j + 1] = arr[j]
                arr[j] = tmp
        print(arr)


# 快速排序 使用异或运算交换值
def fun02():
    arr = [34, 20, 76, 84, 46, 11, 98, 39, 5, 10]
    l = len(arr)
    print(l)
    print(arr[l-1])
    for i in range(l - 1):
        for j in range(i + 1, l):
            if arr[i] > arr[j]:
                arr[i] ^= arr[j]
                arr[j] ^= arr[i]
                arr[i] ^= arr[j]
        print(arr)


if __name__ == '__main__':
    fun02()

