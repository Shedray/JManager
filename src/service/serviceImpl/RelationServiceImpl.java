package service.serviceImpl;

import dao.RelationDao;
import pojo.Relation;
import service.RelationService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * 亲属关系service实现类
 * @author dj
 * 2018年10月5日16:29:19
 * */
public class RelationServiceImpl implements RelationService {
    private RelationDao dao;
    public RelationServiceImpl() {
        this.dao=new RelationDao();
    }

    @Override
    public List<Integer> insertRelations(List<Relation> res) throws SQLException {
        List<Integer> ids=new ArrayList<>();
        for (Relation re:res
             ) {
            int temp=dao.insertrRlation(re);
            ids.add(temp);
        }
        return ids;
    }

    @Override
    public Integer deleteRelations(Integer id) throws SQLException{
        return dao.deleteRelationById(id);
    }

    @Override
    public Integer updateRelations(List<Relation> res)throws SQLException {
        return null;
    }

    @Override
    public List<Relation> getDefaultParentsAndMarried(Integer id) throws SQLException{
        return dao.findRelationById(id);
    }

    @Override
    public List<Relation> getKids(Integer id) throws SQLException{
        return dao.getKids(id);
    }

    @Override
    public List<Relation> getGrandkids(Integer id) throws SQLException{
        return dao.getGrandkids(id);
    }

    @Override
    public List<Relation> getGrands(Integer id) throws SQLException{
        return dao.getGrands(id);
    }

    @Override
    public List<Relation> getOutGrands(Integer id) throws SQLException{
        return dao.getOutGrands(id);
    }

    @Override
    public List<Relation> getBrotherAndSisters(Integer id) throws SQLException{
        return dao.getBrotherAndSisters(id);
    }

    @Override
    public Integer getRelationExist(Integer personId, Integer relationid) throws SQLException {
        return dao.getRelationExist(personId,relationid);
    }
    @Override
    public List<Relation> findRelation(Relation re)throws SQLException{
        return dao.findRelation(re);
    }
    @Override
    public Integer insertRelation(Relation res) throws SQLException{
        return dao.insertrRlation(res);
    }
}
