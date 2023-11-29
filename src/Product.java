/*
* Класс Product мы используем для регистрации продукта)
* Поля класса:
*   1. Название категории
*   2. Название продукта
*   3. Производитель
*   4. цена (которая в дальнейшем меняется при наличии скидки у клиента)
*   5. масса нетто
*   6. дата производства
*   7. годен до
*
* */
class Product extends Category {
    private String title;
    private String manufacturer;
    private double price;
    private double NetWeight;
    private String dateOfManufacture;
    private String validUntil;

    public Product(String categoryName, String title, String manufacturer, double price, double NetWeight, String dateOfManufacture, String validUntil) {
        super(categoryName);
        setTitle(title);
        setManufacturer(manufacturer);
        setPrice(price);
        setNetWeight(NetWeight);
        setDateOfManufacture(dateOfManufacture);
        setValidUntil(validUntil);
    }

    // мои любимые геттеры и сеттеры, обожаю их
    public double getNetWeight() {
        return NetWeight;
    }

    public void setNetWeight(double NetWeight) {
        this.NetWeight = NetWeight;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public String getTitle() {
        return title;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public String getValidUntil() {
        return validUntil;
    }


    // для формирования чека
    @Override
    public String toString() {
        return String.format("""
            Категория: %s
            Название: %s
            Производитель: %s
            Цена: %s
            Дата изготовления: %s
            Годен до: %s
            Масса нетто %s грамм.
            """, getCategoryName(), getTitle(), getManufacturer(), getPrice(),
                getDateOfManufacture(), getValidUntil(), getNetWeight());
    }

    // для регистрации продукта в окне регистрации магазина целиком
    public String printInfo() {
        return String.format("""
            Категория: %s
            Название: %s
            Производитель: %s
            Цена: %s
            Дата изготовления: %s
            Годен до: %s
            Масса нетто %s грамм.
            """, getCategoryName(), getTitle(), getManufacturer(), getPrice(),
                getDateOfManufacture(), getValidUntil(), getNetWeight());
    }


    // высчитали скидку и сразу применили её
    public double calculateDiscount(int discountPercentage) {
        double discountAmount = (discountPercentage / 100.0) * price;
        return price - discountAmount;
    }
}
