package ritmo.com.mentee.encapsulation;

public class Person {
    private String name;
    private int age;
    private String email;

    public Person(String newName,int newAge, String newEmail){
        name = newName;
        age = newAge;
        email = newEmail;
    }

    public Person(Person newPerson){
        name = newPerson.name;
        age = newPerson.age;
        email = newPerson.email;
    }

    public Person(){}

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    public String getEmail(){
        return email;
    }

    public void setName(String newName){
        if (newName == null || newName.isEmpty() ) throw new IllegalArgumentException();

        name = newName;
    }

    public void setAge(int age) {
        if (age < 0 || age > 150) throw  new IllegalArgumentException();
        this.age = age;  }

    public void setEmail(String email) {
        if (!email.contains("@")) throw  new IllegalArgumentException();
        this.email = email;
    }

}
