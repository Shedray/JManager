package dao;

import Util.Log;
import Util.Tables;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Relation;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * 关系表dao
 * @author dj
 * 2018年10月5日16:28:30
 * */
public class RelationDao {
    /**
     * 表名称
     */
    static String table= Tables.tb_relation;
    QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
    /**
     * 插入亲属关系
     * @param relation
     * @return
     * @throws SQLException
     */
    public int insertrRlation(Relation relation) throws SQLException {
        String sql = "insert into "+table+"(person_id,relation_id,relationship,optime) values(?,?,?,now())";
        Log.d("sql",sql);
        int i = qr.update(sql, new Object[]{relation.getPerson_id(), relation.getRelation_id(),relation.getRelationship()});
        System.out.println(i);
        return i;
        /**/
    }
    /**
     * 根据ID删除关联关系
     * @param id
     * @return
     * @throws SQLException
     */
    public  int deleteRelationById(Integer id) throws SQLException {
        String sql = "DELETE FROM "+table+" WHERE id=?";
        Log.d("sql",sql);
        int i = qr.update(sql, new Object[]{id});
        return i;
    }
    /**
     * 查询指定村民的亲属关系
     * @return
     * @throws SQLException
     */
    public List<Relation> findRelationById(Integer ID) throws SQLException {
        //String sql  = "SELECT * FROM "+table+" ";
        String sql  ="SELECT *,\n" +
                "                (SELECT `Name` from "+Tables.tb_persion_test+" p1 where p1.id=person_id)as person_name,\n" +
                "        (SELECT `Name` from "+Tables.tb_persion_test+" p1 where p1.id=relation_id)as relation_name,\n" +
                "        (SELECT `personId` from "+Tables.tb_persion_test+" p1 where p1.id=relation_id)as relation_persionId from "+table+" where person_id="+ID;
        List<Relation> list = (List<Relation>) qr.query(sql, new BeanListHandler(Relation.class));
        return list;
    }

    public List<Relation> getKids(Integer id) throws SQLException{
        return null;
    }


    public List<Relation> getGrandkids(Integer id) throws SQLException{
        return null;
    }


    public List<Relation> getGrands(Integer id) throws SQLException{
        return null;
    }


    public List<Relation> getOutGrands(Integer id) throws SQLException{
        return null;
    }


    public List<Relation> getBrotherAndSisters(Integer id) throws SQLException{
        return null;
    }
    /**
     * 获取兄弟姐妹亲属关系
     * @param personId 要查询人的persionid
     * @param relationid 要查询人的亲属persionid
     * @return  List<Relation>
     * */
    public Integer getRelationExist(Integer personId,Integer relationid)throws SQLException{
        String sql="SELECT count(*)  from tb_relation WHERE person_id ="+personId+" and relation_id="+relationid;
        Log.d("sql",sql);
        Integer count = (Integer) qr.query(sql, new BeanHandler(Integer.class));
        return count;
    }
    /**
     * 查询
     * @param re 要查询人的信息
     * @return  List<Relation>
     * */
    public List<Relation> findRelation(Relation re)throws SQLException{
        String sql="SELECT *,\n" +
                "(SELECT `Name` from "+Tables.tb_persion_test+" p1 where p1.id=person_id)as person_name,\n" +
                "(SELECT `Sexy` from "+Tables.tb_persion_test+" p1 where p1.id=person_id)as person_sexy,\n" +
                "(SELECT `Birthday` from "+Tables.tb_persion_test+" p1 where p1.id=person_id)as person_birth,\n" +
                "(SELECT `Name` from "+Tables.tb_persion_test+" p1 where p1.id=relation_id)as relation_name,\n" +
                "(SELECT `personId` from "+Tables.tb_persion_test+" p1 where p1.id=relation_id)as relation_persionId  from tb_relation WHERE ";
        if(re.getId()!=null){
            sql+=" id="+re.getId()+" and";
        }
        if(re.getPerson_id()!=null){
            sql+=" person_id ="+re.getPerson_id()+" and";
        }
        if(re.getRelation_id()!=null){
            sql+=" relation_id="+re.getRelation_id()+" and";
        }
        if(re.getRelationship()!=null){
            sql+=" relationship="+re.getRelationship()+" and";
        }

        sql=sql.substring(0,sql.lastIndexOf("and"));
        Log.d("sql",sql);
        List<Relation> list = (List<Relation>) qr.query(sql, new BeanListHandler(Relation.class));
        return list;
    }
}
