import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductManagerTest {

    @Test

    public void addTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager pm = new ProductManager(repo);

        Book book1 = new Book(156, "книга1", 100, "автор1");
        Smartphone smart1 = new Smartphone(133, "телефон1", 999999, "Китай");

        pm.add(smart1);
        pm.add(book1);

        Product[] actual = pm.findAll();
        Product[] expected = {smart1, book1};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void removeByIdTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager pm = new ProductManager(repo);

        Book book1 = new Book(156, "книга1", 100, "автор1");
        Book book2 = new Book(564, "книга2", 1040, "автор2");
        Smartphone smart1 = new Smartphone(456, "телефон1", 10000, "Китай");
        Smartphone smart2 = new Smartphone(133, "телефон2", 999999, "Китай");

        pm.add(smart1);
        pm.add(smart2);
        pm.add(book1);
        pm.add(book2);

        pm.removeById(564);

        Product[] actual = pm.findAll();
        Product[] expected = {smart1, smart2, book1};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void searchBySomeProductTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager pm = new ProductManager(repo);

        Book book1 = new Book(156, "книга1", 100, "автор1");
        Book book2 = new Book(564, "книга2", 1040, "автор2");
        Smartphone smart1 = new Smartphone(456, "телефон1", 10000, "Китай");
        Smartphone smart2 = new Smartphone(133, "телефон2", 999999, "Китай");

        pm.add(smart1);
        pm.add(smart2);
        pm.add(book1);
        pm.add(book2);


        Product[] actual = pm.searchBy("телефон");
        Product[] expected = {smart1, smart2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void searchByOneProductTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager pm = new ProductManager(repo);

        Book book1 = new Book(156, "книга1", 100, "автор1");
        Smartphone smart1 = new Smartphone(456, "телефон1", 10000, "Китай");
        Smartphone smart2 = new Smartphone(133, "телефон2", 999999, "Китай");

        pm.add(smart1);
        pm.add(smart2);
        pm.add(book1);


        Product[] actual = pm.searchBy("книга");
        Product[] expected = {book1};

        Assertions.assertArrayEquals(expected, actual);

    }


}