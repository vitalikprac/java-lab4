public class Article {
    final private String name;
    final private float price;

    public Article(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
