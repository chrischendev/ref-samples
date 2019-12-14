# -*- coding:UTF-8 -*-
import numpy as np
import pandas as pd


# https://www.jianshu.com/p/d12af2b287b6

# 生成模拟数据
def create_rnd_datas():
    data_arr = np.random.randint(1, 100, [6, 5])
    for i in range(len(data_arr)):
        for j in range(len(data_arr[i])):
            print(data_arr[i][j], end="\t")
        print(end='\n')

    alist = np.arange(1, 7, 1)
    print(alist)
    blist = np.arange(1, 6, 1)
    print(blist)
    print(end='\n')
    df=pd.DataFrame(data_arr,index=alist,columns=blist)
    # df = pd.DataFrame(data_arr)

    print(end='\n')
    print(df.head(6))
    print(end='\n')
    print(df.tail(6))
    print(end='\n')

    # 行列转置
    print(df.T)
    print(end='\n')

    # 排序
    print(df.sort_values(by=2,ascending=True))
    print(end='\n')
    #
    # for i in range(len(df)):
    #     print(df[i], end='\n')


# 写入电子表格
def write():
    csv_path1 = 'D:\\temp\\python_pandas_test_01.csv'
    dict_lists = []
    dict_data1 = {'number': 1, 'name': u'Tom', 'grade': 80}
    dict_data2 = {'number': 2, 'name': u'Alice', 'grade': 90}
    dict_data3 = {'number': 3, 'name': u'Jone', 'grade': 96}
    dict_data4 = {'number': 4, 'name': u'Mark', 'grade': 76}
    dict_lists.append(dict_data1)
    dict_lists.append(dict_data2)
    dict_lists.append(dict_data3)
    dict_lists.append(dict_data4)
    df = pd.DataFrame(dict_lists, columns=['number', 'name', 'grade'])
    df.to_csv(csv_path1, index=False)


# 读取电子表格
def read():
    csv_path = 'D:\\temp\\python_pandas_test_01.csv'
    datas = pd.read_csv(csv_path)
    show(datas)


# 显示数据集
def show(datas):
    for index in range(len(datas)):
        num = datas.loc[index][0]
        name = datas.loc[index][1]
        grade = datas.loc[index][2]
        print("num:", num, "name:", name, "grade:", grade)


# 数据排序
def analysis():
    csv_path = 'D:\\temp\\python_pandas_test_01.csv'
    datas = pd.read_csv(csv_path)
    datas.sort_values(axis=0, by=['grade'], ascending=False, inplace=True)
    show(datas)


# 主程序
if __name__ == '__main__':
    create_rnd_datas()
