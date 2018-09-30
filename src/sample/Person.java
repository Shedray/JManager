package sample;

import javafx.beans.property.SimpleStringProperty;
public class Person {
    private final SimpleStringProperty ID = new SimpleStringProperty();                         //身份Id
    private final SimpleStringProperty PersonID = new SimpleStringProperty();                //身份证
    private final SimpleStringProperty GroupID = new SimpleStringProperty();                 //户号
    private final SimpleStringProperty Name = new SimpleStringProperty();                    //名字   4
    private final SimpleStringProperty Sexy = new SimpleStringProperty();                    //性别
    private final SimpleStringProperty Birthday = new SimpleStringProperty();                //生日
    private final SimpleStringProperty Nation = new SimpleStringProperty();                  //民族
    private final SimpleStringProperty HomeGroup = new SimpleStringProperty();               //户口关系 4
    private final SimpleStringProperty Group = new SimpleStringProperty();                   //所在村
    private final SimpleStringProperty Political = new SimpleStringProperty();               //政治关系
    private final SimpleStringProperty PartyTime = new SimpleStringProperty();               //入党时间
    private final SimpleStringProperty TypesOfPoorHouseholds = new SimpleStringProperty();   //贫困类型  4
    private final SimpleStringProperty IsItPermanent = new SimpleStringProperty();           //是否常驻人口
    private final SimpleStringProperty Works = new SimpleStringProperty();                   //工作
    private final SimpleStringProperty NumberOfPlanted = new SimpleStringProperty();         //种植地亩数量
    private final SimpleStringProperty EnjoyThePolicy = new SimpleStringProperty();          //享受政策   4
    private final SimpleStringProperty Assets = new SimpleStringProperty();                  //个人资产
    private final SimpleStringProperty Resume = new SimpleStringProperty();                  //个人资历
    private final SimpleStringProperty SocialRelations = new SimpleStringProperty();         //社会关系
    private final SimpleStringProperty Address = new SimpleStringProperty();                 //地点

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public void setPersonID(String personID) {
        this.PersonID.set(personID);
    }

    public void setGroupID(String groupID) {
        this.GroupID.set(groupID);
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public void setSexy(String sexy) {
        this.Sexy.set(sexy);
    }

    public void setBirthday(String birthday) {
        this.Birthday.set(birthday);
    }

    public void setNation(String nation) {
        this.Nation.set(nation);
    }

    public void setHomeGroup(String homeGroup) {
        this.HomeGroup.set(homeGroup);
    }

    public void setGroup(String group) {
        this.Group.set(group);
    }

    public void setPolitical(String political) {
        this.Political.set(political);
    }

    public void setPartyTime(String partyTime) {
        this.PartyTime.set(partyTime);
    }

    public void setTypesOfPoorHouseholds(String typesOfPoorHouseholds) {
        this.TypesOfPoorHouseholds.set(typesOfPoorHouseholds);
    }

    public void setIsItPermanent(String isItPermanent) {
        this.IsItPermanent.set(isItPermanent);
    }

    public void setWorks(String works) {
        this.Works.set(works);
    }

    public void setNumberOfPlanted(String numberOfPlanted) {
        this.NumberOfPlanted.set(numberOfPlanted);
    }

    public void setEnjoyThePolicy(String enjoyThePolicy) {
        this.EnjoyThePolicy.set(enjoyThePolicy);
    }

    public void setAssets(String assets) {
        this.Assets.set(assets);
    }

    public void setResume(String resume) {
        this.Resume.set(resume);
    }

    public void setSocialRelations(String socialRelations) {
        this.SocialRelations.set(socialRelations);
    }

    public void setAddress(String address) {
        this.Address.set(address);
    }

    public String getID() {
        return ID.get();
    }

    public SimpleStringProperty IDProperty() {
        return ID;
    }

    public String getPersonID() {
        return PersonID.get();
    }

    public SimpleStringProperty personIDProperty() {
        return PersonID;
    }

    public String getGroupID() {
        return GroupID.get();
    }

    public SimpleStringProperty groupIDProperty() {
        return GroupID;
    }

    public String getName() {
        return Name.get();
    }

    public SimpleStringProperty nameProperty() {
        return Name;
    }

    public String getSexy() {
        return Sexy.get();
    }

    public SimpleStringProperty sexyProperty() {
        return Sexy;
    }

    public String getBirthday() {
        return Birthday.get();
    }

    public SimpleStringProperty birthdayProperty() {
        return Birthday;
    }

    public String getNation() {
        return Nation.get();
    }

    public SimpleStringProperty nationProperty() {
        return Nation;
    }

    public String getHomeGroup() {
        return HomeGroup.get();
    }

    public SimpleStringProperty homeGroupProperty() {
        return HomeGroup;
    }

    public String getGroup() {
        return Group.get();
    }

    public SimpleStringProperty groupProperty() {
        return Group;
    }

    public String getPolitical() {
        return Political.get();
    }

    public SimpleStringProperty politicalProperty() {
        return Political;
    }

    public String getPartyTime() {
        return PartyTime.get();
    }

    public SimpleStringProperty partyTimeProperty() {
        return PartyTime;
    }

    public String getTypesOfPoorHouseholds() {
        return TypesOfPoorHouseholds.get();
    }

    public SimpleStringProperty typesOfPoorHouseholdsProperty() {
        return TypesOfPoorHouseholds;
    }

    public String getIsItPermanent() {
        return IsItPermanent.get();
    }

    public SimpleStringProperty isItPermanentProperty() {
        return IsItPermanent;
    }

    public String getWorks() {
        return Works.get();
    }

    public SimpleStringProperty worksProperty() {
        return Works;
    }

    public String getNumberOfPlanted() {
        return NumberOfPlanted.get();
    }

    public SimpleStringProperty numberOfPlantedProperty() {
        return NumberOfPlanted;
    }

    public String getEnjoyThePolicy() {
        return EnjoyThePolicy.get();
    }

    public SimpleStringProperty enjoyThePolicyProperty() {
        return EnjoyThePolicy;
    }

    public String getAssets() {
        return Assets.get();
    }

    public SimpleStringProperty assetsProperty() {
        return Assets;
    }

    public String getResume() {
        return Resume.get();
    }

    public SimpleStringProperty resumeProperty() {
        return Resume;
    }

    public String getSocialRelations() {
        return SocialRelations.get();
    }

    public SimpleStringProperty socialRelationsProperty() {
        return SocialRelations;
    }

    public String getAddress() {
        return Address.get();
    }

    public SimpleStringProperty addressProperty() {
        return Address;
    }
}
