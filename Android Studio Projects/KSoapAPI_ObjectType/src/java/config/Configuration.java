package example.com.vn.config;

public class Configuration {
    private static final String IP_ADDRESS = "127.0.0.1";
    public static String SERVER_URL = "http://" + IP_ADDRESS + "/WebService/example.asmx";
    public static String NAME_SPACE = "http://example.edu.vn/";
    public static String METHOD_GET_DETAIL = "GetDetail";
    public static String PARAM_DETAIL_ID = "id";
    public static String SOAP_ACTION_GET_DETAIL = NAME_SPACE + METHOD_GET_DETAIL;
}
