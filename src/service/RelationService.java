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
     * Relation 需要的属性
     *           person_id
     *            relation_id
     *            relationship
     * */
    public List<Integer> insertRelations(List<Relation> res) throws SQLException;
    /**
     * 增加亲属关系
     * @param res 亲属列表
     * Relation 需要的属性
     *           person_id
     *            relation_id
     *            relationship
     * */
    public Integer insertRelation(Relation res) throws SQLException;
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
     * 获取外祖父母亲属关系
     * @param id 要查询人的id
     * @return  List<Relation>
     * */
    public List<Relation> getOutGrandparents(Integer id)throws SQLException;
    /**
     * 获取详细亲属关系
     * @param id 要查询人的id
     * @return  List<Relation>
     * */
    public List<Relation> getMoreRelationship(Integer id)throws SQLException;
    /**
     * 获取祖父母亲属关系
     * @param id 要查询人的id
     * @return  List<Relation>
     * */
    public List<Relation> getGrandparents(Integer id)throws SQLException;

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
     * 获取兄弟姐妹亲属关系
     * @param id 要查询人的id
     * @return  List<Relation>
     * */
    public List<Relation> getBrotherAndSisters(Integer id)throws SQLException;
    /**
     * 查询指定人之间是否有亲属关系
     * @param personId 要查询人的persionid
     * @param relationid 要查询人的亲属persionid
     * @return  List<Relation>
     * */
    public Integer getRelationExist(Integer personId,Integer relationid)throws SQLException;
    /**
     * 查询
     * @param re 要查询人的信息
     * @return  List<Relation>
     * */
    public List<Relation> findRelation(Relation re)throws SQLException;

}
