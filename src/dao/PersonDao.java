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
     * 根据name查User
     *
     * @param personName
     * @return
     * @throws SQLException
     */
    public Person findPersonByPersonName(String personName) throws SQLException {
        String sql = "select * from " + table + " where Name= ?";
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        return (Person) qr.query(sql, new BeanHandler(Person.class), new Object[]{personName});
    }


    /**
     * 根据Person的ID删除用户
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public int deletePersonById(Long id) throws SQLException {
        String sql = "DELETE FROM " + table + " WHERE id=?";
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        int i = qr.update(sql, new Object[]{id});
        return i;
    }

    /**
     * 查询所有村民
     *
     * @return
     * @throws SQLException
     */
    public List<Person> findPerson() throws SQLException {
        String sql = "SELECT * FROM " + table + "";
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        List<Person> list = (List<Person>) qr.query(sql, new BeanListHandler(Person.class));
        return list;
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
        String sql = "insert into " + table + "(personId,GroupID,Name,Sexy,Birthday,Nation,HomeGroup,groups,Political,PartyTime,TypesOfPoorHouseholds,IsItPermanent,Works,NumberOfPlanted," +
                "EnjoyThePolicy,Assets,Resume,SocialRelations,Address) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int i = qr.update(sql, new Object[]{person.getPersonID(), person.getGroupID(), person.getName(), person.getSexy(),
                person.getBirthday(), person.getNation(), person.getHomeGroup(), person.getGroups(),
                person.getPolitical(), person.getPartyTime(), person.getTypesOfPoorHouseholds(), person.getIsItPermanent(),
                person.getWorks(), person.getNumberOfPlanted(), person.getEnjoyThePolicy(), person.getAssets(),
                person.getResume(), person.getSocialRelations(), person.getAddress()});
        System.out.println(i);
        return i;

    }

    /**
     * 根据身份证查询村民
     * @param personId
     * @return
     * @throws SQLException
     */
    public Person findPersonByPersonId(String personId) throws SQLException {
        String sql = "select * from " + table + " where personId=?";
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        return (Person) qr.query(sql, new BeanHandler(Person.class), new Object[]{personId});
    }

    /**
     * 根据id查村民
     * @param id
     * @return
     * @throws SQLException
     */
    public Person findPersonById(String id) throws SQLException {
        String sql = "select * from " + table + " where id=?";
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        return (Person) qr.query(sql, new BeanHandler(Person.class), new Object[]{id});
    }
    /**
     *
     */
    public List<Person> findPersonByTJ(Person person) throws SQLException {
        StringBuffer sql = new StringBuffer("select * from  " + table + " where 1=1");
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        List<Object> list = new ArrayList<>();
        if (person.getName()!=null&&!person.getName().trim().isEmpty()){
            sql.append(" and name=?");
            list.add(person.getName());
        }
        if (person.getPersonID()!=null&&!person.getPersonID().trim().isEmpty()){
            sql.append(" and personid=?");
            list.add(person.getPersonID());
        }

        return (List<Person>) qr.query(sql.toString(), new BeanListHandler(Person.class), list.toArray());
    }


}
