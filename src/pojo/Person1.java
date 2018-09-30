package pojo;

public class Person1 {
    private Integer id;

    //private String ﻿﻿personID;
    private String personid;

    private String groupid;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", personid='" + personid + '\'' +
                ", groupid='" + groupid + '\'' +
                ", name='" + name + '\'' +
                ", sexy='" + sexy + '\'' +
                ", birthday='" + birthday + '\'' +
                ", nation='" + nation + '\'' +
                ", homegroup='" + homegroup + '\'' +
                ", groups='" + groups + '\'' +
                ", political='" + political + '\'' +
                ", partytime='" + partytime + '\'' +
                ", typesofpoorhouseholds='" + typesofpoorhouseholds + '\'' +
                ", isitpermanent='" + isitpermanent + '\'' +
                ", works='" + works + '\'' +
                ", numberofplanted='" + numberofplanted + '\'' +
                ", enjoythepolicy='" + enjoythepolicy + '\'' +
                ", assets='" + assets + '\'' +
                ", resume='" + resume + '\'' +
                ", socialrelations='" + socialrelations + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    private String name;

    private String sexy;

    private String birthday;

    private String nation;

    private String homegroup;

    private String groups;

    private String political;

    private String partytime;

    private String typesofpoorhouseholds;

    private String isitpermanent;

    private String works;

    private String numberofplanted;

    private String enjoythepolicy;

    private String assets;

    private String resume;

    private String socialrelations;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid == null ? null : groupid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSexy() {
        return sexy;
    }

    public void setSexy(String sexy) {
        this.sexy = sexy == null ? null : sexy.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getHomegroup() {
        return homegroup;
    }

    public void setHomegroup(String homegroup) {
        this.homegroup = homegroup == null ? null : homegroup.trim();
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political == null ? null : political.trim();
    }

    public String getPartytime() {
        return partytime;
    }

    public void setPartytime(String partytime) {
        this.partytime = partytime == null ? null : partytime.trim();
    }

    public String getTypesofpoorhouseholds() {
        return typesofpoorhouseholds;
    }

    public void setTypesofpoorhouseholds(String typesofpoorhouseholds) {
        this.typesofpoorhouseholds = typesofpoorhouseholds == null ? null : typesofpoorhouseholds.trim();
    }

    public String getIsitpermanent() {
        return isitpermanent;
    }

    public void setIsitpermanent(String isitpermanent) {
        this.isitpermanent = isitpermanent == null ? null : isitpermanent.trim();
    }

    public String getWorks() {
        return works;
    }

    public void setWorks(String works) {
        this.works = works == null ? null : works.trim();
    }

    public String getNumberofplanted() {
        return numberofplanted;
    }

    public void setNumberofplanted(String numberofplanted) {
        this.numberofplanted = numberofplanted == null ? null : numberofplanted.trim();
    }

    public String getEnjoythepolicy() {
        return enjoythepolicy;
    }

    public void setEnjoythepolicy(String enjoythepolicy) {
        this.enjoythepolicy = enjoythepolicy == null ? null : enjoythepolicy.trim();
    }

    public String getAssets() {
        return assets;
    }

    public void setAssets(String assets) {
        this.assets = assets == null ? null : assets.trim();
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume == null ? null : resume.trim();
    }

    public String getSocialrelations() {
        return socialrelations;
    }

    public void setSocialrelations(String socialrelations) {
        this.socialrelations = socialrelations == null ? null : socialrelations.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}