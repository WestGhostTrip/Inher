import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepoProductTest {

    Book book1= new Book(1, "Русский язык", 2000, "Иванов И.И.");
    Book book2= new Book(2, "Литература", 3500, "Сидоров С.С.");
    Smartphone smartphone1 = new Smartphone(5, "Iphone", 80_000, "Apple");

    private RepoProduct repo = new RepoProduct();

    @Test
    public void removeIdTest(){
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);

        Product[] actual = repo.removeId(2);
        Product[]expected = {book1, smartphone1};

        Assertions.assertArrayEquals(actual, expected);
    }

}
