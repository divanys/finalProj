/*
*  В классе Customer мы, как ни странно, создаём клиента, имеющего следующие поля:
*   1. Фамилия
*   2. Имя
*   3. Отчество
*   4. Возраст
*   5. Номер карты
*   6. Наличие дисконтной карты
*
* */
class Customer extends Person {
    private boolean isDiscountCard;
    private String numberCard;

    public Customer(String lastName, String firstName, String middleName, int age, String numberCard, boolean isDiscountCard) {
        super(lastName, firstName, middleName, age);
        setNumberCard(numberCard);
        setDiscountCard(isDiscountCard);
    }


    // для формирования чека
    @Override
    public String toString() {
        return String.format("""
                Фамилия: %s
                Имя: %s
                Отчество: %s
                Возраст: %d
                Номер карты: %s
                Наличие скидочной карты: %b
                """, getLastName(), getFirstName(), getMiddleName(), getAge(), getNumberCard(), isDiscountCard());
    }

    // для вывода при нажатии кнопки "зарегистрированныеКлиентыButton" в окошке регистрации магазина (можно удалить, но...нет))
    public String printInfo() {
        return String.format("""
                Фамилия: %s
                Имя: %s
                Отчество: %s
                Возраст: %d
                Номер карты: %s
                Наличие скидочной карты: %b
                """, getLastName(), getFirstName(), getMiddleName(), getAge(), getNumberCard(), isDiscountCard());
    }

    // инкапсуляция: есть, чтобы была
    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public boolean isDiscountCard() {
        return isDiscountCard;
    }

    public void setDiscountCard(boolean discountCard) {
        isDiscountCard = discountCard;
    }
}