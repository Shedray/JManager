package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * User表的增删改查
 */
public class UserDao {
    /**
     * 表名称
     */
    static String table="tb_user";
    /**
     * 根据name查User
     * @param username
     * @return
     * @throws SQLException
     */
    public User findUserByUserName(String username) throws SQLException {
        String sql="select * from "+table+" where username=?";
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
        return (User) qr.query(sql, new BeanHandler(User.class), new Object[]{username});
    }
    /**
     * 根据用户ID删除用户
     * @param id
     * @return
     * @throws SQLException
     */
    public  int deleteUserById(Long id) throws SQLException {
        String sql = "DELETE FROM "+table+" WHERE id=?";
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
        int i = qr.update(sql, new Object[]{id});
        return i;
    }

    /**
     * 查询所有用户
     * @return
     * @throws SQLException
     */
    public  List<User> findUser() throws SQLException {
        String sql  = "SELECT * FROM "+table+" ";
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
        List<User> list = (List<User>) qr.query(sql, new BeanListHandler(User.class));
        return list;
    }

    /**
     * 插入用户
     * @param user
     * @return
     * @throws SQLException
     */
    public int insertUser(User user) throws SQLException {
        String sql = "insert into "+table+"(username,password,phone,email) values(?,?,?,?)";
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        int i = qr.update(sql, new Object[]{user.getUsername().trim(), user.getPassword().trim(), user.getPhone().trim(), user.getEmail().trim()});
        System.out.println(i);
        return i;
        /**/
    }
}
