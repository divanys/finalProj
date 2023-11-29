class Cashier extends Person {

    private int numberKass;

    public Cashier(String lastName, String firstName, String middleName, int age, int numberKass) {
        super(lastName, firstName, middleName, age);
        setNumberKass(numberKass);
    }

    public String printInfo() {
        return String.format("""
            Фамилия: %s
            Имя: %s
            Отчество: %s
            Возраст: %d
            Номер кассы: %d
            """, getLastName(), getFirstName(), getMiddleName(), getAge(), getNumberKass());
    }

    public int getNumberKass() {
        return numberKass;
    }

    public void setNumberKass(int numberKass) {
        this.numberKass = numberKass;
    }
}