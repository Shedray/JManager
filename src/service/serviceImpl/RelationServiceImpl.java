package service.serviceImpl;

import Util.Log;
import Util.RealtionshipEmue;
import dao.PersonDao;
import dao.RelationDao;
import pojo.Person;
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
    private PersonDao persondao;
    public RelationServiceImpl() {
        this.dao=new RelationDao();
        this.persondao=new PersonDao();
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
    public List<Relation> getOutGrandparents(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Relation> getMoreRelationship(Integer id) throws SQLException {
        try{
            List<Relation> result=new ArrayList<>();
            Person p=persondao.findPersonByAnway("id",id+"");
            //获取父id
            Relation re=new Relation();
            re.setPerson_id(id);
            re.setRelationship(RealtionshipEmue.father);
            List<Relation> father_lis=this.findRelation(re);
            int father_id=0;
            if(father_lis!=null&&father_lis.size()>0) {
                father_id = father_lis.get(0).getRelation_id();
                Relation tmp=new Relation();
                tmp.setRelation_name(father_lis.get(0).getRelation_name());
                tmp.setRelation_description("父亲");
                tmp.setRelation_persionId(father_lis.get(0).getRelation_persionId());
                result.add(tmp);
            }
            re.clear();
            //获取母id
            re.setPerson_id(id);
            re.setRelationship(RealtionshipEmue.mother);
            List<Relation> mother_lis=this.findRelation(re);
            int mother_id=0;
            if(mother_lis!=null&&mother_lis.size()>0){
                mother_id=mother_lis.get(0).getRelation_id();
                Relation tmp=new Relation();
                tmp.setRelation_name(mother_lis.get(0).getRelation_name());
                tmp.setRelation_description("母亲");
                tmp.setRelation_persionId(mother_lis.get(0).getRelation_persionId());
                result.add(tmp);
            }
            re.clear();
            //获取配偶id
            re.setPerson_id(id);
            re.setRelationship(RealtionshipEmue.married);
            List<Relation> married_lis=this.findRelation(re);
            int married_id=0;
            if(married_lis!=null&&married_lis.size()>0){
                married_id=married_lis.get(0).getRelation_id();
                Relation tmp=new Relation();
                tmp.setRelation_name(married_lis.get(0).getRelation_name());
                tmp.setRelation_description("配偶");
                tmp.setRelation_persionId(married_lis.get(0).getRelation_persionId());
                result.add(tmp);
            }
            re.clear();

            int relation=0;
            if(p.getSexy().equals("男"))
                relation=RealtionshipEmue.father;
            else
                relation=RealtionshipEmue.mother;
            //获取子女
            re.setRelation_id(id);
            re.setRelationship(relation);
            List<Relation> kids_lis=this.findRelation(re);
            re.clear();
            if(kids_lis!=null&&kids_lis.size()>0){
                for (Relation kid:kids_lis) {
                    Relation tmp=new Relation();
                    tmp.setRelation_name(kid.getPerson_name());
                    tmp.setRelation_persionId(kid.getRelation_persionId());
                    if(kid.getPerson_sexy().equals("男")){
                        tmp.setRelation_description("儿子");
                    }else{
                        tmp.setRelation_description("女儿");
                    }
                    result.add(tmp);
                }
                //获取孙子女
                for (Relation kid:kids_lis) {
                    re.setRelation_id(kid.getPerson_id());
                    if(kid.getPerson_sexy().equals("男"))
                        relation=RealtionshipEmue.father;
                    else
                        relation=RealtionshipEmue.mother;
                    re.setRelationship(relation);
                    List<Relation> grandkids_lis=this.findRelation(re);
                    if(grandkids_lis!=null&&grandkids_lis.size()>0){
                        for (Relation grandskid:grandkids_lis) {
                            Relation tmp=new Relation();
                            tmp.setRelation_name(grandskid.getPerson_name());
                            tmp.setRelation_persionId(grandskid.getRelation_persionId());
                            if(kid.getPerson_sexy().equals("男")){
                                if(grandskid.getPerson_sexy().equals("男")){
                                    tmp.setRelation_description("孙子");
                                }else{
                                    tmp.setRelation_description("孙女");
                                }
                            }
                            else{
                                if(grandskid.getPerson_sexy().equals("男")){
                                    tmp.setRelation_description("外孙");
                                }else{
                                    tmp.setRelation_description("外孙女");
                                }
                            }
                            result.add(tmp);
                        }
                    }
                }
            }

            //获取兄弟姐妹
            re.clear();
            re.setRelation_id(father_id);
            re.setRelationship(RealtionshipEmue.father);
            List<Relation> brothersAndSisters=this.findRelation(re);
            re.clear();
            if(brothersAndSisters!=null&&brothersAndSisters.size()>0){
                for (Relation brothers:brothersAndSisters) {
                    if(!brothers.getPerson_id().equals(id))
                    {
                    Relation tmp=new Relation();
                    tmp.setRelation_name(brothers.getPerson_name());
                    tmp.setRelation_persionId(brothers.getRelation_persionId());
                    if(brothers.getPerson_sexy().equals("男")){
                        if(brothers.getPerson_age()>father_lis.get(0).getPerson_age()){
                            tmp.setRelation_description("兄长");
                        }else{
                            tmp.setRelation_description("弟弟");
                        }
                        result.add(tmp);
                        //获取侄子侄女
                        re.setRelation_id(brothers.getPerson_id());
                        re.setRelationship(RealtionshipEmue.father);
                        List<Relation> brotherskids=this.findRelation(re);
                        if(brotherskids!=null&&brotherskids.size()>0){
                            for (Relation brotherskid:brotherskids) {
                                Relation tmp1=new Relation();
                                tmp1.setRelation_name(brotherskid.getPerson_name());
                                tmp1.setRelation_persionId(brotherskid.getRelation_persionId());
                                if(brotherskid.getPerson_sexy().equals("男")){
                                    tmp1.setRelation_description("侄子");
                                }else {
                                    tmp1.setRelation_description("侄女");
                                }
                                result.add(tmp1);
                            }
                        }
                    }else{
                        if(brothers.getPerson_age()>father_lis.get(0).getPerson_age()){
                            tmp.setRelation_description("姐姐");
                        }else{
                            tmp.setRelation_description("妹妹");
                        }
                        result.add(tmp);
                        //获取外甥外甥女
                        re.setRelation_id(brothers.getPerson_id());
                        re.setRelationship(RealtionshipEmue.mother);
                        List<Relation> brotherskids=this.findRelation(re);
                        if(brotherskids!=null&&brotherskids.size()>0){
                            for (Relation brotherskid:brotherskids) {
                                Relation tmp1=new Relation();
                                tmp1.setRelation_name(brotherskid.getPerson_name());
                                tmp1.setRelation_persionId(brotherskid.getRelation_persionId());
                                if(brotherskid.getPerson_sexy().equals("男")){
                                    tmp1.setRelation_description("外甥");
                                }else {
                                    tmp1.setRelation_description("外甥女");
                                }
                                result.add(tmp1);
                            }
                        }
                    }

                }
                }
            }


            //获取祖父祖母
            re.clear();
            re.setPerson_id(father_id);
            re.setRelationship(RealtionshipEmue.father);
            List<Relation> grandfather_lis=this.findRelation(re);
            int grandfather_id=0;
            if(grandfather_lis!=null&&grandfather_lis.size()>0) {
                grandfather_id = grandfather_lis.get(0).getRelation_id();
                Relation tmp=new Relation();
                tmp.setRelation_name(grandfather_lis.get(0).getRelation_name());
                tmp.setRelation_description("祖父");
                tmp.setRelation_persionId(grandfather_lis.get(0).getRelation_persionId());
                result.add(tmp);
            }
            re.clear();
            re.setPerson_id(father_id);
            re.setRelationship(RealtionshipEmue.mother);
            List<Relation> grandmother_lis=this.findRelation(re);
            int grandmother_id=0;
            if(grandmother_lis!=null&&grandmother_lis.size()>0){
                grandmother_id=grandmother_lis.get(0).getRelation_id();
                Relation tmp=new Relation();
                tmp.setRelation_name(grandmother_lis.get(0).getRelation_name());
                tmp.setRelation_description("祖母");
                tmp.setRelation_persionId(grandmother_lis.get(0).getRelation_persionId());
                result.add(tmp);
            }
            re.clear();
            //获取伯 婶 和 姑 姑父
            re.setRelation_id(grandfather_id);
            re.setRelationship(RealtionshipEmue.father);
            List<Relation> grandfatherkids=this.findRelation(re);
            re.clear();
            if(grandfatherkids!=null&&grandfatherkids.size()>0){
                for (Relation grandfatherkid:grandfatherkids) {
                    if(!grandfatherkid.getPerson_id().equals(father_id))
                    {
                        Relation tmp=new Relation();
                        tmp.setRelation_name(grandfatherkid.getPerson_name());
                        tmp.setRelation_persionId(grandfatherkid.getRelation_persionId());
                        if(grandfatherkid.getPerson_sexy().equals("男")){
                            tmp.setRelation_description("伯伯");
                            //伯母
                            result.add(tmp);
                            re.setRelationship(RealtionshipEmue.father);
                        }else{
                            tmp.setRelation_description("姑姑");
                            //姑父
                            result.add(tmp);
                            re.setRelationship(RealtionshipEmue.mother);
                        }
                        //获取堂哥弟姐妹
                        re.setRelation_id(grandfatherkid.getPerson_id());
                        List<Relation> grandfatherkidkids=this.findRelation(re);
                        if(grandfatherkidkids!=null&&grandfatherkidkids.size()>0){
                            for (Relation grandfatherkidkid:grandfatherkidkids) {
                                Relation tmp1=new Relation();
                                tmp1.setRelation_name(grandfatherkidkid.getPerson_name());
                                tmp1.setRelation_persionId(grandfatherkidkid.getRelation_persionId());
                                if(grandfatherkidkid.getPerson_sexy().equals("男")){
                                    if(grandfatherkidkid.getPerson_age()>father_lis.get(0).getPerson_age()){
                                        tmp1.setRelation_description("堂哥");
                                    }else {
                                        tmp1.setRelation_description("堂弟");
                                    }

                                }else {
                                    if(grandfatherkidkid.getPerson_age()>father_lis.get(0).getPerson_age()){
                                        tmp1.setRelation_description("堂姐");
                                    }else {
                                        tmp1.setRelation_description("堂妹");
                                    }
                                }
                                result.add(tmp1);
                            }
                        }
                    }
                }
            }


            //获取外祖父祖母
            re.clear();
            re.setPerson_id(mother_id);
            re.setRelationship(RealtionshipEmue.father);
            List<Relation> outgrandfather_lis=this.findRelation(re);
            int outgrandfather_id=0;
            if(outgrandfather_lis!=null&&outgrandfather_lis.size()>0) {
                outgrandfather_id = outgrandfather_lis.get(0).getRelation_id();
                Relation tmp=new Relation();
                tmp.setRelation_name(outgrandfather_lis.get(0).getRelation_name());
                tmp.setRelation_description("外祖父");
                tmp.setRelation_persionId(outgrandfather_lis.get(0).getRelation_persionId());
                result.add(tmp);
            }
            re.clear();
            re.setPerson_id(mother_id);
            re.setRelationship(RealtionshipEmue.mother);
            List<Relation> outgrandmother_lis=this.findRelation(re);
            int outgrandmother_id=0;
            if(outgrandmother_lis!=null&&outgrandmother_lis.size()>0){
                outgrandmother_id=outgrandmother_lis.get(0).getRelation_id();
                Relation tmp=new Relation();
                tmp.setRelation_name(outgrandmother_lis.get(0).getRelation_name());
                tmp.setRelation_description("外祖母");
                tmp.setRelation_persionId(outgrandmother_lis.get(0).getRelation_persionId());
                result.add(tmp);
            }
            re.clear();
            //获取舅舅舅妈和姨，姨父
            re.setRelation_id(outgrandfather_id);
            re.setRelationship(RealtionshipEmue.father);
            List<Relation> outgrandfatherkids=this.findRelation(re);
            re.clear();
            if(outgrandfatherkids!=null&&outgrandfatherkids.size()>0){
                for (Relation outgrandfatherkid:outgrandfatherkids) {
                    if(!outgrandfatherkid.getPerson_id().equals(mother_id))
                    {
                        Relation tmp=new Relation();
                        tmp.setRelation_name(outgrandfatherkid.getPerson_name());
                        tmp.setRelation_persionId(outgrandfatherkid.getRelation_persionId());
                        if(outgrandfatherkid.getPerson_sexy().equals("男")){
                            tmp.setRelation_description("舅舅");
                            //舅妈
                            result.add(tmp);
                            re.setRelationship(RealtionshipEmue.father);
                        }else{
                            tmp.setRelation_description("姨");
                            //姨父
                            result.add(tmp);
                            re.setRelationship(RealtionshipEmue.mother);
                        }
                        //获取堂哥弟姐妹
                        re.setRelation_id(outgrandfatherkid.getPerson_id());
                        List<Relation> outgrandfatherkidkids=this.findRelation(re);
                        if(outgrandfatherkidkids!=null&&outgrandfatherkidkids.size()>0){
                            for (Relation outgrandfatherkidkid:outgrandfatherkidkids) {
                                Relation tmp1=new Relation();
                                tmp1.setRelation_name(outgrandfatherkidkid.getPerson_name());
                                tmp1.setRelation_persionId(outgrandfatherkidkid.getRelation_persionId());
                                if(outgrandfatherkidkid.getPerson_sexy().equals("男")){
                                    if(outgrandfatherkidkid.getPerson_age()>father_lis.get(0).getPerson_age()){
                                        tmp1.setRelation_description("表哥");
                                    }else {
                                        tmp1.setRelation_description("表弟");
                                    }

                                }else {
                                    if(outgrandfatherkidkid.getPerson_age()>father_lis.get(0).getPerson_age()){
                                        tmp1.setRelation_description("表姐");
                                    }else {
                                        tmp1.setRelation_description("表妹");
                                    }
                                }
                                result.add(tmp1);
                            }
                        }
                    }
                }
            }
            //获取表哥弟姐妹
            for (Relation sss:result
            ) {
                System.out.println(sss.toString());
            }
            System.out.println(result.size()+"end");
            return result;
        }catch (Exception e){
            Log.d("error","查询出错");
        }

        return null;

    }
private void addToList(List<Relation> list,int id,String relation_description){
    Relation tmp=new Relation();
    tmp.setRelation_name(persondao.findPersonByAnway("id",id+"").getName());
    tmp.setRelation_description(relation_description);
    list.add(tmp);
}
    @Override
    public List<Relation> getGrandparents(Integer id) throws SQLException {
        return null;
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