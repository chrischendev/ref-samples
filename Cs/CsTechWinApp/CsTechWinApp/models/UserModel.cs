using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsTechWinApp.models
{
    class UserModel
    { 
        private string name;
        private int age;
        private string address;

        public UserModel()
        {
        }

        public UserModel(string name, int age, string address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
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
    }
}
