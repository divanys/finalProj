/*
 *  В классе Cashier мы, как ни странно, создаём теперь кассира, имеющего следующие поля:
 *   1. Фамилия
 *   2. Имя
 *   3. Отчество
 *   4. Возраст
 *   5. Номер кассы
 *
 * */
class Cashier extends Person {

    private int numberKass;

    public Cashier(String lastName, String firstName, String middleName, int age, int numberKass) {
        super(lastName, firstName, middleName, age);
        setNumberKass(numberKass);
    }

    // для формирования чека
    @Override
    public String toString() {
        return String.format("""
            Фамилия: %s
            Имя: %s
            Отчество: %s
            Возраст: %d
            Номер кассы: %d
            """, getLastName(), getFirstName(), getMiddleName(), getAge(), getNumberKass());
    }


    // для вывода при нажатии кнопки "зарегистрированныеКассирыButton" в окошке регистрации магазина (можно удалить, но...нет))
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