package sample;
import java.sql.*;
import java.util.*;

public class JDBC {
    private Statement stmt = null;
    private Connection conn =null;
    /*
     * @注册JDBC驱动
     * @return Null
     */
    JDBC(){
        try {
            System.out.println("注册JDBC驱动中....");
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception e){
            System.out.println("JDBC驱动注册错误...");
            System.out.println(e);
        }
    }
    /*
     * @连接数据库
     * @return Null
     */
    public void JDBC_Connect(String URL,String USER,String PASS){
        try {
            this.conn = DriverManager.getConnection(URL, USER, PASS);
            this.stmt = conn.createStatement();
            System.out.println("数据库连接完毕");
        }
        catch (Exception e){
            System.out.println("连接数据库失败...");
            System.out.println(e);
        }
    }
    /*
     * @param
     * @return 以List类型返回数据表所有内容
     * */
    public List<Map> JDBC_Search(){
        String sql="SELECT * FROM info";
        List<Map> list = new ArrayList<Map>();
        ResultSet rs=null;
        try {
            rs = this.stmt.executeQuery(sql);
            list = resultSetToList(rs);
            rs.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    /*
     * @param  ColumnName为列名
     * @param  SearchID为列内容
     * @return 由select * from info where ColumnName = SearchID;语句查询出的结果并由list类型返回
     * */
    public List<Map> JDBC_SearchByID(String ColumnName,String SearchID)
    {
        String sql ="select * from info where "+ColumnName+" = '"+SearchID+"';";
        System.out.println(sql);
        List<Map> list = new ArrayList<Map>();
        try {
            ResultSet rs = this.stmt.executeQuery(sql);
            list = resultSetToList(rs);
            rs.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return list;
    }

    //    public void JDBC_Insert(int id,String Name, String Url){
//        try{
//            String sql=String.format("INSERT INTO websites (id, name,url) VALUES ('%d','%s','%s');",id,Name,Url);
//            this.stmt.executeUpdate(sql);
//        }
//        catch (Exception e)
//        {
//            System.out.println(e);
//        }
//    }
//    public void JDBC_Command(String sql){
//        try{
//            this.stmt.executeUpdate(sql);
//            System.out.println("命令执行完毕！");
//        }
//        catch (Exception e)
//        {
//            System.out.println(e);
//        }
//    }
    public void JDBC_Close(){
        try {
            this.stmt.close();
            this.conn.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    /*
     * @param  工具类函数，将ResultSet集合转换成list类型
     * @return list
     * */
    private static List<Map> resultSetToList(ResultSet rs) throws java.sql.SQLException {
        if (rs == null) {
            return Collections.EMPTY_LIST;
        }
        ResultSetMetaData md = rs.getMetaData(); //得到结果集(rs)的结构信息，比如字段数、字段名等
        int columnCount = md.getColumnCount(); //返回此 ResultSet 对象中的列数
        List<Map> list = new ArrayList<Map>();
        Map rowData = new HashMap();
        while (rs.next()) {
            rowData = new HashMap(columnCount);
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(md.getColumnName(i), rs.getObject(i));
            }
            list.add(rowData);
        }
        return list;
    }
}
