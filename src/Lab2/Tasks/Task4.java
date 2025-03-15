package Lab2.Tasks;


class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

public class Task4 {

    public static void main(String[] args) {
        Person person = new Person("Иван", 30, "Мужской");

        printPerson(person);

        person.setAge(35);
        person.setName("Петр");

        printPerson(person);
    }

    private static void printPerson(Person person){
        System.out.println("Имя " + person.getName());
        System.out.println("Возраст " + person.getAge());
        System.out.println("Пол " + person.getGender());
    }
}