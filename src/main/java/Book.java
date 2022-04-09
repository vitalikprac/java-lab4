public class Book {
    final private String name;
    final private String authorFullName;
    final private String publication;
    final private int publicationYear;
    final private float price;

    public Book(String name, String authorFullName, String publication, int publicationYear, float price) {
        this.name = name;
        this.authorFullName = authorFullName;
        this.publication = publication;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public String getPublication() {
        return publication;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", authorFullName='" + authorFullName + '\'' +
                ", publication='" + publication + '\'' +
                ", publicationYear=" + publicationYear +
                ", price=" + price +
                '}';
    }
}
