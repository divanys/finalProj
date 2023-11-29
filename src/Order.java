import java.util.List;

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public double calculateTotalPrice(int discountPercentage) {
        double totalPrice = 0;
        for (Product product : productList) {
            totalPrice += product.calculateDiscount(discountPercentage);
        }
        return totalPrice;
    }

    public String printOrderInfo() {
        String resOrder = "";
        resOrder += "Информация о заказе:\n";
        resOrder += "Клиент: \n" + customer.printInfo();
        resOrder += "Кассир: \n" + cashier.printInfo();
        resOrder += "Перечень продуктов:\n";
        for (Product product : productList) {
            resOrder += product.printInfo();
        }
        resOrder += "Сумма покупки:\n" + calculateTotalPrice(discountPercentage);
        return resOrder;
    }



    @Override
    public void applyDiscount(Product product, int discountPercentage) {

    }

    @Override
    public void getPromotionDetails() {
        System.out.println("Вы можете купить у нас рекламу или провести акцию! (в разработке🤗)");
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }
}
