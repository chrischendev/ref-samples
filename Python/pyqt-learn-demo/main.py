# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'main.py'
#
# Created by: PyQt5 UI code generator 5.11.3
#
# WARNING! All changes made in this file will be lost!


import sys

from PyQt5.QtWidgets import QApplication, QMainWindow

from windows.main_window import Ui_MainWindow


class MainWin(QMainWindow, Ui_MainWindow):
    def __init__(self, parent=None):
        super(MainWin, self).__init__(parent)
        self.setupUi(self)


if __name__ == '__main__':
    app = QApplication(sys.argv)
    main_win = MainWin()
    main_win.show()
    sys.exit(app.exec_())
