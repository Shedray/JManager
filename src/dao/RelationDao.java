package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Relation;
import pojo.User;

import java.sql.SQLException;
import java.util.List;
/**
 *
 * 关系表dao
 * */
public class RelationDao {
    /**
     * 表名称
     */
    static String table="tb_relation";
    /**
     * Relation
     * @param person_id
     * @return
     * @throws SQLException
     */
    public Relation findRelatioBypersonId(Integer person_id) throws SQLException {
        String sql="select * from "+table+" where personId=?";
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
        return (Relation) qr.query(sql, new BeanHandler(User.class), new Object[]{person_id});
    }
    /**
     * 根据用户ID删除关联关系
     * @param id
     * @return
     * @throws SQLException
     */
    public  int deleteRelationById(Long id) throws SQLException {
        String sql = "DELETE FROM "+table+" WHERE id=?";
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
        int i = qr.update(sql, new Object[]{id});
        return i;
    }

    /**
     * 查询所有关系
     * @return
     * @throws SQLException
     */
    public List<Relation> findRelation() throws SQLException {
        //String sql  = "SELECT * FROM "+table+" ";
        String sql  ="SELECT *,\n" +
                "                (SELECT `Name` from person1 p1 where p1.id=person_id)as person_name,\n" +
                "        (SELECT `Name` from person1 p1 where p1.id=relation_id)as relation_name,\n" +
                "        (SELECT `personId` from person1 p1 where p1.id=relation_id)as relation_persionId from "+table+" ";
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
        List<Relation> list = (List<Relation>) qr.query(sql, new BeanListHandler(Relation.class));
        return list;
    }
    /**
     * 查询指定村民的亲属关系
     * @return
     * @throws SQLException
     */
    public List<Relation> findRelationById(Integer ID) throws SQLException {
        //String sql  = "SELECT * FROM "+table+" ";
        String sql  ="SELECT *,\n" +
                "                (SELECT `Name` from person1 p1 where p1.id=person_id)as person_name,\n" +
                "        (SELECT `Name` from person1 p1 where p1.id=relation_id)as relation_name,\n" +
                "        (SELECT `personId` from person1 p1 where p1.id=relation_id)as relation_persionId from "+table+" where person_id="+ID;
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
        List<Relation> list = (List<Relation>) qr.query(sql, new BeanListHandler(Relation.class));
        return list;
    }

    /**
     * 插入亲属关系
     * @param relation
     * @return
     * @throws SQLException
     */
    public int insertUser(Relation relation) throws SQLException {
        String sql = "insert into "+table+"(person_id,relation_id,relationship,optime) values(?,?,?,now())";
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        int i = qr.update(sql, new Object[]{relation.getPerson_id(), relation.getRelation_id(),relation.getRelationship()});
        System.out.println(i);
        return i;
        /**/
    }
}
