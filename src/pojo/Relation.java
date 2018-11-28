package pojo;

import Util.RealtionshipEmue;

import java.util.Calendar;
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
    private String person_sexy;//当前查询村民性别
     private int person_age;//当前查询村民年龄
     private String person_birth;//当前查询村民年龄


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

    public String getPerson_sexy() {
        return person_sexy;
    }

    public void setPerson_sexy(String person_sexy) {
        this.person_sexy = person_sexy;
    }

    public int getPerson_age() {
        return person_age;
    }

    public void setPerson_age(int person_age) {
        this.person_age = person_age;
    }

    public String getPerson_birth() {
        return person_birth;
    }

    public void setPerson_birth(String person_birth) {
        if(person_birth==null||person_birth.length()<4)
            return;
        this.person_birth = person_birth;
        int year=Integer.parseInt(person_birth.substring(0,4));
        int age=Calendar.getInstance().get(Calendar.YEAR)-year;
        this.setPerson_age(age);
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
                ", person_sexy='" + person_sexy + '\'' +
                ", person_age=" + person_age +
                ", person_birth='" + person_birth + '\'' +
                ", relation_description='" + relation_description + '\'' +
                ", relation_persionId='" + relation_persionId + '\'' +
                '}';
    }

    public void clear(){
        this.id=null;
        this.person_id=null;
        this.relation_id=null;
        this.relationship=null;
        this.optime=null;
        this.person_name=null;
        this.relation_name=null;
        this.relation_description=null;
        this.relation_persionId=null;

    }
}
