abstract class Category {
    private String categoryName;
    public Category(String categoryName) {
        setCategotyName(categoryName);
    }
    private void setCategotyName(String categoryName) { this.categoryName = categoryName; }

    public String getCategoryName() { return categoryName; }

}
