package service;

import pojo.Relation;

import java.sql.SQLException;
import java.util.List;
/**
 * 亲属关系servicee接口
 * @author dj
 * 2018年10月5日16:29:19
 * */
public interface RelationService {
    /**
     * 增加亲属关系
     * @param res 亲属列表
     * */
    public List<Integer> insertRelations(List<Relation> res) throws SQLException;
    /**
     * 删除亲属关系
     * @param id 亲属关系id
     * */
    public Integer deleteRelations(Integer id) throws SQLException;
    /**
     * 修改亲属关系
     * @param res 亲属列表
     * */
    public Integer updateRelations(List<Relation> res) throws SQLException;
    /**
     * 默认情况下获取的亲属关系（父母和配偶）
     * @param id 要查询人的id
     * @return  List<Relation>
     * */
    public List<Relation> getDefaultParentsAndMarried(Integer id) throws SQLException;
    /**
     * 获取子女亲属关系
     * @param id 要查询人的id
     * @return  List<Relation>
     * */
    public List<Relation> getKids(Integer id) throws SQLException;
    /**
     * 获取孙子女亲属关系
     * @param id 要查询人的id
     * @return  List<Relation>
     * */
    public List<Relation> getGrandkids(Integer id)throws SQLException;
    /**
     * 获取外孙子女亲属关系
     * @param id 要查询人的id
     * @return  List<Relation>
     * */
    public List<Relation> getGrands(Integer id)throws SQLException;
    /**
     * 获取外祖父母亲属关系
     * @param id 要查询人的id
     * @return  List<Relation>
     * */
    public List<Relation> getOutGrands(Integer id)throws SQLException;
    /**
     * 获取兄弟姐妹亲属关系
     * @param id 要查询人的id
     * @return  List<Relation>
     * */
    public List<Relation> getBrotherAndSisters(Integer id)throws SQLException;

}
