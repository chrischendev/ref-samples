import sys

from PyQt5.QtWidgets import QApplication, QWidget


def show():
    app = QApplication(sys.argv)

    w = QWidget()
    w.setWindowTitle("测试窗口")
    w.resize(400, 300)
    w.show()

    sys.exit(app.exec_())


if __name__ == '__main__':
    show()
