using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsTechWptApp.model
{
    class PersonalInfo
{
    private string _name;
    private int _workYears;
    private string _workPhoneNumber;
    private string _email;
    public string Email//get和set分别为只读和只写，这是绑定的正常写法，Email为我们要进行绑定的一个属性
    {
        get { return _email; }
        set { _email = value; }
    }
    public string WorkPhoneNumber
    {
        get { return _workPhoneNumber; }
        set { _workPhoneNumber = value; }
    }
    public int WorkYears
    {
        get { return _workYears; }
        set { _workYears = value; }
        }
        public string Name
    {
        get { return _name; }
        set { _name = value; }
    }
    public PersonalInfo(string name, int workYears, string workPhoneNumber, string email)//构造函数
    {
        _name = name;
        _workYears = workYears;
        _workPhoneNumber = workPhoneNumber;
        _email = email;
    }

}
}
