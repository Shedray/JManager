
import dao.PersonDao;
import pojo.Person;

import java.util.List;

public class Main {

    //static String table="tb_user";

    public static void main(String[] args) throws Exception {
        PersonDao personDao = new PersonDao();

       /*Person person = new Person();
        person.setAssets("1");
        person.setBirthday("s");
        int i = personDao.insertUser(person);*/
        /*List<Person> list = personDao.findPersonByTJ(person);
        for (Person person1 : list) {
            System.out.println(person1);
        }*/

        List<Person> person = personDao.findPerson();
        for (Person person1 : person) {
            System.out.println(person1);
        }
    /*person.setAssets("1");
        person.setBirthday("s");
        person.setEnjoythepolicy("33");
        person.setGroup("s");
        person.setGroupid("ss");
        person.setHomegroup("ss");
        person.setIsitpermanent("s");
        person.setNation("s");
        person.setNumberofplanted("ss");
        person.setPartytime("sss");
        person.setPolitical("sss");
        person.setResume("sss");
        person.setSexy("s");
        person.setSocialrelations("ss");
        person.setTypesofpoorhouseholds("sss");
        person.setWorks("ss");
        person.setAddress("石家庄");*/
      /* person.setPersonid("130133199704281211");
        int i = personDao.insertUser(person);
        System.out.println(i);*/
    }
}
