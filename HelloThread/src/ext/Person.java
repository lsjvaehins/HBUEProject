package ext;

/**
 * Created by lanouhn on 17/7/18.
 */
public class Person {
//    private是权限修饰符，表示私有的，也就是在Person类外面，无法直接通过Person的对象.country来获得
//    并且因为是私有的，子类也无法使用
//    private String country;

//    protected是受保护的权限修饰符，与Person在同一个包下的类可以使用，Person的子类可以使用
    protected String country;


    public Person(String country) {

        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
