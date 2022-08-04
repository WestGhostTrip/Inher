import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerProductTest {
    Book book1= new Book(1, "Русский язык", 2000, "Иванов И.И.");
    Book book2= new Book(2, "Литература", 3500, "Сидоров С.С.");
    Book book3= new Book(3, "Аллегории", 3000, "Петров П.П.");
    Book book4= new Book(4, "Алгебра", 1600, "Прохоров А.В.");
    Smartphone smartphone1 = new Smartphone(5, "Рандаунд ", 80_000, "Huawei");
    Smartphone smartphone2 = new Smartphone(6, "ГАлакси", 95_000, "Samsung");


    private RepoProduct repo = new RepoProduct();
    private ManagerProduct manager = new ManagerProduct(repo);


    @Test
    public void addTest(){
        manager.add(book1);
        manager.add(smartphone1);

        Product[] actual = repo.getAll();
        Product[]expected = {book1, smartphone1};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void find1ProductTest(){
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);

        Product[] actual =  manager.searchBy("у");
        Product[]expected = {book2, smartphone1};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void find2ProductTest(){
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone2);

        Product[] actual =  manager.searchBy("Ал");
        Product[]expected = {book3,book4,smartphone2};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void find3ProductTest(){
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone2);

        Product[] actual =  manager.searchBy("Матр");
        Product[]expected = {};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void find4ProductTest(){
        manager.add(book1);
        manager.add(book3);
        manager.add(smartphone1);

        Product[] actual =  manager.searchBy("язык");
        Product[]expected = {book1};

        Assertions.assertArrayEquals(actual, expected);
    }
}
