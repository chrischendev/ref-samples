# -*- coding:UTF-8 -*-
import pandas as pd


# https://www.jianshu.com/p/d12af2b287b6

# 写入电子表格
def createCsvFile():
    csv_path1 = 'D:\\temp\\python_pandas_test_01.csv'
    df = pd.DataFrame(createDatas(), columns=['number', 'name', 'grade'])
    writeToCsv(df, csv_path1)


# 创建数据
def createDatas():
    dict_lists = []
    dict_data1 = {'number': 1, 'name': u'Tom', 'grade': 80}
    dict_data2 = {'number': 3, 'name': u'Alice', 'grade': 90}
    dict_data3 = {'number': 2, 'name': u'Jone', 'grade': 96}
    dict_data4 = {'number': 4, 'name': u'Mark', 'grade': 76}
    dict_lists.append(dict_data1)
    dict_lists.append(dict_data2)
    dict_lists.append(dict_data3)
    dict_lists.append(dict_data4)
    return dict_lists


# 写入cvs电子表格
def writeToCsv(df, cvsFilePath):
    df.to_csv(cvsFilePath, index=False)


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


# 分析
def analysis(csv_path_in, sort_field):
    datas = pd.read_csv(csv_path_in)
    print(datas)
    print(end='\n')
    datas1 = datas.sort_values(by=[sort_field], ascending=True,inplace=False)
    print(datas1)

    return datas1


# 数据排序
def analysis_cvs():
    csv_path1 = 'D:\\temp\\python_pandas_test_01.csv'
    csv_path2 = 'D:\\temp\\python_pandas_test_02.csv'
    datas = analysis(csv_path1, 'grade')
    print('排序后的数据框:\n')
    show(datas)
    writeToCsv(datas, csv_path2)

    print('重新读取的内容:\n')
    datas1 = pd.read_csv(csv_path2)
    show(datas1)


# 主程序
if __name__ == '__main__':
    # createCsvFile()
    # read()
    analysis_cvs()
