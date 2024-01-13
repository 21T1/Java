using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace WebService
{
    /// <summary>
    /// Summary description for topicaservice
    /// </summary>
    [WebService(Namespace = "http://topica.edu.vn/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class topicaservice : System.Web.Services.WebService
    {

        [WebMethod]
        public string HelloWorld()
        {
            return "Hello World";
        }

        [WebMethod]
        public List<string> GetList()
        {
            List<string> lst = new List<string>();
            lst.Add("Topica");
            lst.Add("Edumall");
            lst.Add("Native");
            return lst;
        }

        [WebMethod]
        public string SolveSimpleEquation(int a, int b)
        {
            if (a == 0 && b == 0)
                return "Vô số nghiệm";
            if (a == 0 && b != 0)
                return "Vô nghiệm";
            return "x = " + (-b * 1.0 / a);
        }
    }
}
