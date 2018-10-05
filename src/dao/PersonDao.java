package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Person;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 村民Dao
 */
public class PersonDao {
    /**
     * 表名称
     */
    static String table = "person1";

    /**
     * 根据相应的Key查询相应的Person
     *
     * @param personName
     * @return
     * @throws SQLException
     */
    public Person findPersonByAnway(String Key,String personName)  {
        String sql = "select * from " + table + " where " +Key+"= ?";
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            return (Person) qr.query(sql, new BeanHandler(Person.class), new Object[]{personName});
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 根据Person的ID删除用户
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public int deletePersonById(String id){
        String sql = "DELETE FROM " + table + " WHERE id=?";
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try{
            int i = qr.update(sql, new Object[]{id});
            return i;
        }catch (Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 查询所有村民
     *
     * @return
     * @throws SQLException
     */
    public List<Person> findPerson() {
        String sql = "SELECT * FROM " + table + "";
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try{
            List<Person> list = (List<Person>) qr.query(sql, new BeanListHandler(Person.class));
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 插入村民
     *
     * @param person
     * @return
     * @throws SQLException
     */
    public int insertUser(Person person) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "insert into " + table + "(personId,GroupID,Name,Sexy,Birthday,Nation,HomeGroup,`groups`,Political,PartyTime,TypesOfPoorHouseholds,IsItPermanent,Works,NumberOfPlanted," +
                "EnjoyThePolicy,Assets,Resume,SocialRelations,Address) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int i = qr.update(sql, new Object[]{person.getPersonID(), person.getGroupID(), person.getName(), person.getSexy(),
                person.getBirthday(), person.getNation(), person.getHomeGroup(), person.getGroups(),
                person.getPolitical(), person.getPartyTime(), person.getTypesOfPoorHouseholds(), person.getIsItPermanent(),
                person.getWorks(), person.getNumberOfPlanted(), person.getEnjoyThePolicy(), person.getAssets(),
                person.getResume(), person.getSocialRelations(), person.getAddress()});
        return i;

    }
    /**
     * 更新村民
     *
     * @param person
     * @return
     * @throws SQLException
     */
    public int updatetUser(Person person) throws SQLException {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "update into " + table + "(id,personId,GroupID,Name,Sexy,Birthday,Nation,HomeGroup,`groups`,Political,PartyTime,TypesOfPoorHouseholds,IsItPermanent,Works,NumberOfPlanted," +
                "EnjoyThePolicy,Assets,Resume,SocialRelations,Address) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int i = qr.update(sql, new Object[]{person.getID(),person.getPersonID(), person.getGroupID(), person.getName(), person.getSexy(),
                person.getBirthday(), person.getNation(), person.getHomeGroup(), person.getGroups(),
                person.getPolitical(), person.getPartyTime(), person.getTypesOfPoorHouseholds(), person.getIsItPermanent(),
                person.getWorks(), person.getNumberOfPlanted(), person.getEnjoyThePolicy(), person.getAssets(),
                person.getResume(), person.getSocialRelations(), person.getAddress()});

        return i;

    }



}
