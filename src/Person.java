abstract class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private int age;

    public Person(String lastName, String firstName, String middleName, int age) {setLastName(lastName); setFirstName(firstName); setMiddleName(middleName); setAge(age);}
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

