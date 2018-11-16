package pojo;

import Util.RealtionshipEmue;

import java.util.Date;
/**
 * 亲属关系数据库实体类
 * @author dj
 * 2018年10月5日16:29:19
 * */
public class Relation {
    private Integer id;
    private Integer person_id;//当前查询村民ID
    private Integer relation_id;//亲属id
    private Integer relationship;//与亲属关系
    private Date optime;
    private String person_name;//当前查询村民姓名
    private String relation_name;//当前亲属姓名
    private String relation_description;//两人亲属关系
    private String relation_persionId;//亲属身份证号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public Integer getRelation_id() {
        return relation_id;
    }

    public void setRelation_id(Integer relation_id) {
        this.relation_id = relation_id;
    }

    public Integer getRelationship() {
        return relationship;
    }

    public void setRelationship(Integer relationship) {
        this.relationship = relationship;
        switch (relationship){
            case RealtionshipEmue.father:
                this.setRelation_description("父亲");
                break;
            case RealtionshipEmue.mother:
                this.setRelation_description("母亲");
                break;
            case RealtionshipEmue.married:
                this.setRelation_description("配偶");
                break;
        }

    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getRelation_name() {
        return relation_name;
    }

    public void setRelation_name(String relation_name) {
        this.relation_name = relation_name;
    }

    public String getRelation_description() {
        return relation_description;
    }

    public void setRelation_description(String relation_description) {
        this.relation_description = relation_description;
    }

    public String getRelation_persionId() {
        return relation_persionId;
    }

    public void setRelation_persionId(String relation_persionId) {
        this.relation_persionId = relation_persionId;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "id=" + id +
                ", person_id=" + person_id +
                ", relation_id=" + relation_id +
                ", relationship=" + relationship +
                ", optime=" + optime +
                ", person_name='" + person_name + '\'' +
                ", relation_name='" + relation_name + '\'' +
                ", relation_description='" + relation_description + '\'' +
                ", relation_persionId='" + relation_persionId + '\'' +
                '}';
    }
}
