package controllers;
import Util.RealtionshipEmue;
import dao.PersonDao;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pojo.Person;
import pojo.Relation;
import service.RelationService;
import service.serviceImpl.RelationServiceImpl;
import viewutil.Dialog;
import viewutil.Tableview;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class AddController implements Initializable {
    //注册控件;
    private  Person People=new Person();
    public  String CLICK;

    @FXML private ChoiceBox Add_Sex;
    @FXML private ChoiceBox Add_Political;
    @FXML private ChoiceBox Add_Perman;
    @FXML private TextField Add_Name;
    @FXML private TextField Add_Nation;
    @FXML private TextField Add_personID;
    @FXML private TextField Add_Birthday;
    @FXML private TextField Add_GroupID;
    @FXML private TextField Add_HomeGroup;
    @FXML private TextField Add_PartyTime;
    @FXML private TextField Add_TypesOfPoorHouseholds;
    @FXML private TextField Add_Works;
    @FXML private TextField Add_NumberOfPlanted;
    @FXML private TextField Add_Address;
    @FXML private TextField Add_Group;
    @FXML private TextArea Add_EnjoyThePolicy;
    @FXML private TextArea Add_Assets;
    @FXML private Button Add_People;
    /*
    * Relation框注册
    * */
    @FXML private TableView Add_Relation;
    @FXML private TextField Rela_Name;
    @FXML private ChoiceBox Rela_Rela;

    RelationService relationService=new RelationServiceImpl();
    @FXML public void initialize(URL url, ResourceBundle rb) {
        ChoiceBoxInit();
        TextFieldInit();
        TableviewInit();
        if(People.getID()==null)
            Add_People.setText("新增");
        else
            Add_People.setText("更新");
    }
    public void Refresh(Person people,String click){
        this.People = people;
        this.CLICK = click;
        ChoiceBoxInit();
        TextFieldInit();
        TableviewInit();
        if(People.getID()==null)
            Add_People.setText("新增");
        else
            Add_People.setText("更新");
    }
    /*
     *@这部分是Raletion——TableView的部分在这里初始化绑定显示的亲属数据
     *@亲属数据的ID可以通过全局People.getID()得到
     */
    Tableview rele = new Tableview();
    @FXML public void TableviewInit(){


        try {
    //            System.out.println(Integer.parseInt(CLICK));
            List<Relation> relations=relationService.getDefaultParentsAndMarried(Integer.parseInt(CLICK));

            String[] Columns={"relation_name","relation_persionId","relation_description"};
            rele.setColumns(Columns);
            rele.setID(Add_Relation);
            rele.setData(relations);
            rele.show();
        }catch (Exception e){
            System.out.print(e);
        }


    }
    @FXML public void ChoiceBoxInit(){
        Add_Sex.setItems(FXCollections.observableArrayList(
                "男", "女","未知"));
        Add_Political.setItems(FXCollections.observableArrayList(
                "群众", "团员","预备党员","党员","其他"));
        Add_Perman.setItems(FXCollections.observableArrayList(
                "否","是","其他"));
        Rela_Rela.setItems(FXCollections.observableArrayList(
                "父亲","母亲","配偶"));
        Add_Sex.setValue(People.getSexy());
        if(People.getSexy()==null)
            Add_Sex.setValue("未知");
        else
            Add_Sex.setValue(People.getSexy());
        if(People.getPolitical()==null)
            Add_Political.setValue("其他");
        else
            Add_Political.setValue(People.getPolitical());
        if(People.getIsItPermanent()==null)
            Add_Perman.setValue("其他");
        else
            Add_Perman.setValue(People.getIsItPermanent());
    }
    @FXML private void TextFieldInit(){
        Add_Name.setText(People.getName());
        Add_Nation.setText(People.getNation());
        Add_personID.setText(People.getPersonID());
        Add_Birthday.setText(People.getBirthday());
        Add_GroupID.setText(People.getGroupID());
        Add_HomeGroup.setText(People.getHomeGroup());
        Add_PartyTime.setText(People.getPartyTime());
        Add_TypesOfPoorHouseholds.setText(People.getTypesOfPoorHouseholds());
        Add_Works.setText(People.getWorks());
        Add_NumberOfPlanted.setText(People.getNumberOfPlanted());
        Add_Address.setText(People.getAddress());
        Add_EnjoyThePolicy.setText(People.getEnjoyThePolicy());
        Add_Assets.setText(People.getAssets());
        Add_Group.setText(People.getGroups());
    }
    /**
    *添加村民关系
    查询村民是否存在，存在再查询添加关系是否已经存在，再查询关系是否正确，不存在则添加关系*/
    @FXML private void Rela_Add(ActionEvent event){
        viewutil.Dialog dialog=new Dialog();
        if(CLICK==null||CLICK.equals("")){
            dialog.ErrDialog("","提示","请先选择村民");
            return;
        }
        String relation=(String)Rela_Rela.getValue();
        int relation_id=0;
        if(relation==null){
            dialog.ErrDialog("","提示","请选择亲属关系");
            return;
        }else if(relation.equals("父亲")){
            relation_id= RealtionshipEmue.father;
        }else  if(relation.equals("母亲")){
            relation_id= RealtionshipEmue.mother;
        }else  if(relation.equals("配偶")){
            relation_id= RealtionshipEmue.married;
        }
        String name=Rela_Name.getText();
        boolean isMatch =  Pattern.matches("[\u4e00-\u9fa5]+", name);//校验汉字
        if(!isMatch){
            dialog.ErrDialog("","提示","输入正确的名字");
            return;
        }
        PersonDao pd=new PersonDao();
        //这里查询可能会出错，有村民重名的时候sql会报错
        Person p=pd.findPersonByAnway("Name",name);
        if (p!=null){
            //查询即将添加的关系是否已经存在
            Relation re1 = new Relation();
            re1.setPerson_id(Integer.parseInt(CLICK));
            re1.setRelationship(relation_id);
            try{
                List<Relation> lis = relationService.findRelation(re1);
                if(lis!=null&&lis.size()>0){
                    switch  (relation_id) {
                    case RealtionshipEmue.married:
                        dialog.ErrDialog("", "提示", "已经有配偶了");
                        break;
                    case RealtionshipEmue.mother:
                        dialog.ErrDialog("", "提示", "已经有母亲了");
                        break;
                    case RealtionshipEmue.father:
                        dialog.ErrDialog("", "提示", "已经有父亲了");
                        break;
                    }
                    return;
                }
            }catch (SQLException E){
                E.printStackTrace();
                dialog.ErrDialog("", "提示", "查询出错");
                return;
            }
            if(!(relation_id==RealtionshipEmue.married)) {
                //查询被添加的人是否已经是父亲或者母亲
                Relation re2 = new Relation();
                re2.setRelation_id(Integer.parseInt(p.getID()));
                try {
                    List<Relation> lis = relationService.findRelation(re2);
                    for (Relation res:lis
                         ) {
                        if(res.getRelationship()==RealtionshipEmue.father||res.getRelationship()==RealtionshipEmue.mother){
                            dialog.ErrDialog("", "提示", "添加人与其他人已存在关系");
                            return;
                        }
                    }
                } catch (SQLException E) {
                    E.printStackTrace();
                    dialog.ErrDialog("", "提示", "查询出错");
                    return;
                }
            }else {
                //检查被添加的人是否已经结婚
                Relation re=new Relation();
                re.setRelation_id(Integer.parseInt(p.getID()));
                re.setRelationship(RealtionshipEmue.married);
                try{
                    List<Relation> relations=relationService.findRelation(re);
                    if(relations!=null&&relations.size()>0){
                        dialog.ErrDialog("","提示","此人已经有配偶了");
                        return;
                    }
                    //排除将自己父母作为配偶添加的情况
                    Relation check=new Relation();
                    check.setPerson_id(Integer.parseInt(CLICK));
                    check.setRelation_id(Integer.parseInt(p.getID()));
                    List<Relation> defrelations=relationService.findRelation(check);
                    if(defrelations!=null&&defrelations.size()>0){
                        dialog.ErrDialog("","提示","不能这样添加哦");
                        return;
                    }
                }catch (SQLException E){
                    dialog.ErrDialog("","提示","查询出错");
                    E.printStackTrace();
                    return;
                }

            }

            try{
                Relation ree=new Relation();
                ree.setPerson_id(Integer.parseInt(CLICK));
                ree.setRelation_id(Integer.parseInt(p.getID()));
                ree.setRelationship(relation_id);
                relationService.insertRelation(ree);
                if (relation_id==RealtionshipEmue.married) {//配偶双方的关系都会添加
                    Relation exchange = new Relation();
                    exchange.setPerson_id(Integer.parseInt(p.getID()));
                    exchange.setRelation_id(Integer.parseInt(CLICK));
                    exchange.setRelationship(relation_id);
                    relationService.insertRelation(exchange);
                }
                dialog.ErrDialog("","提示","添加成功");
                TableviewInit();
            }catch (Exception e){
                dialog.ErrDialog("","提示","查询出错");
                e.printStackTrace();
            }

        }else{
            dialog.ErrDialog("","提示","村民不存在，请检查输入的用户名");
        }
        //新加关系
    }
    @FXML private void Rela_Search(ActionEvent event){
        System.out.println("查找关系");
        //查找关系
    }
    @FXML public  void InsertPeople(ActionEvent event){
        People.setName(Add_Name.getText());
        People.setNation(Add_Nation.getText());
        People.setPersonID(Add_personID.getText());
        People.setBirthday(Add_Birthday.getText());
        People.setGroupID(Add_GroupID.getText());
        People.setHomeGroup(Add_HomeGroup.getText());
        People.setPartyTime(Add_PartyTime.getText());
        People.setTypesOfPoorHouseholds(Add_TypesOfPoorHouseholds.getText());
        People.setWorks(Add_Works.getText());
        People.setNumberOfPlanted(Add_NumberOfPlanted.getText());
        People.setAddress(Add_Address.getText());
        People.setEnjoyThePolicy(Add_EnjoyThePolicy.getText());
        People.setGroups(Add_Group.getText());
        People.setAssets(Add_Assets.getText());
        People.setSexy(Add_Sex.getValue().toString());
        People.setPolitical(Add_Political.getValue().toString());
        People.setIsItPermanent(Add_Perman.getValue().toString());

        try {
            if (People.getID()==null)
                new PersonDao().insertUser(People);
            else
                new PersonDao().updatetUser(People);//更新数据
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML public  void Exit(ActionEvent event){
        Stage Now =(Stage) Add_PartyTime.getScene().getWindow();
        Now.close();
    }
}