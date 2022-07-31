public class ManagerProduct {

    private RepoProduct repo = new RepoProduct();

    public ManagerProduct(RepoProduct repo) {
        this.repo = repo;
    }

    public ManagerProduct() {

    }

    public void add(Product product) {
        Product[] tmp = new Product[repo.getAll().length + 1];

        for (int i = 0; i < repo.getAll().length; i++) {
            tmp[i] = repo.products[i];
        }
        tmp[tmp.length - 1] = product;
        repo.products = tmp;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.getAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
