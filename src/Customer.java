class Customer extends Person {

    private boolean isDiscountCard;
    private String numberCard;

    public Customer(String lastName, String firstName, String middleName, int age, String numberCard, boolean isDiscountCard) {
        super(lastName, firstName, middleName, age);
        setNumberCard(numberCard);
        setDiscountCard(isDiscountCard);
    }


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