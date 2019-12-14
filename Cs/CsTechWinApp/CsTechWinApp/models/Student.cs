using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsTechWinApp.models
{
    class Student
    {
        private string name;
        private int age;
        private string address;
        private string info;

        public Student()
        {
        }

        public Student(string name, int age, string address, string info)
        {
            this.name = name;
            this.age = age;
            this.address = address;
            this.info = info;
        }

        public string Name
        {
            get => name;
            set => name = value;
        }

        public int Age
        {
            get => age;
            set => age = value;
        }

        public string Address
        {
            get => address;
            set => address = value;
        }

        public string Info
        {
            get => info;
            set => info = value;
        }
    }
}
