import java.util.List;

/*
*  Класс Order необходим для регистрации заказа, который будет включать в себя:
*   1. Клиента
*   2. Кассира
*   3. Перечень покупок (в нашем случае список)
*
*  Далее, имея перечисленные данные выше, мы высчитываем сумму за все покупки в 1 заказе для 1 чека, имея информацию
* от выбранного клиента: есть ли у него дисконтная карта или нет. В идеале нужно сделать отдельный класс для формирования
* чека на основе заказа и присутствии/отсутствии дисконтной карты, но..)
* Поэтому информация об итоговой цене также хранится в этом классе)
*
*/

class Order implements Promotion {
    private Customer customer;
    private Cashier cashier;
    private List<Product> productList;
    private int discountPercentage;

    public Order(Customer customer, Cashier cashier, List<Product> products, int discountPercentage) {
        setCustomer(customer);
        setCashier(cashier);
        setProductList(products);
        setDiscountPercentage(discountPercentage);
    }


    // геттеры и сеттеры с целиковым объектом класса клиента (покупателя, как угодно)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // геттеры и сеттеры с целиковым объектом класса кассира (сотрудника)
    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public Cashier getCashier() {
        return cashier;
    }

    // геттеры и сеттеры с целиковым объектом класса продукт, но используя список
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    // считаем, сколько рубликов отберём у человечка
    public double calculateTotalPrice(int discountPercentage) {
        double totalPrice = 0;
        for (Product product : productList) {
            totalPrice += product.calculateDiscount(discountPercentage);
        }
        return totalPrice;
    }

    // просто всю информацию о заказе приводим в строковый тип, чтобы можно было выводить в окно чека
    public String printOrderInfo() {
        String resOrder = "";
        resOrder += "Информация о заказе:\n";
        resOrder += "\n-----------Клиент--------------\n" + customer.printInfo();
        resOrder += "\n-----------Кассир--------------\n" + cashier.printInfo();
        resOrder += "\n------Перечень продуктов-------\n";
        for (Product product : productList) {
            resOrder += product.printInfo();
            resOrder += "\n---------------------------\n";
        }
        resOrder += "Итоговая сумма покупки: " + calculateTotalPrice(getDiscountPercentage());
        return resOrder;
    }


    @Override
    public void applyDiscount(Product product, int discountPercentage) {
        // пустышка 😁, не бейте
    }

    @Override
    public void getPromotionDetails() {
        System.out.println("Вы можете купить у нас рекламу или провести акцию! (в разработке🤗)");  // до сих пор в разработке 😅
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }


    public int getDiscountPercentage() {
        return discountPercentage;
    }
}
