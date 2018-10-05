package test;

import Util.RealtionshipEmue;
import dao.RelationDao;
import pojo.Relation;

import java.sql.SQLException;

public class RelationTest {
    public static void main(String[] a){
        RelationDao relationDao=new RelationDao();
        Relation re=new Relation();
        re.setPerson_id(1);
        re.setRelation_id(5);
        re.setRelationship(RealtionshipEmue.father);
        try {
            relationDao.insertUser(re);
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("error");
        }

    }
}
