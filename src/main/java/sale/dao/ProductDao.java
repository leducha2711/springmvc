package sale.dao;

import java.util.List;

import sale.entity.Product;

public interface ProductDao {
	public void addProduct(Product product);

	public void updateProduct(Product product);

	public void delete(int id);

	public Product getProductById(int id);

	public List<Product> getAllProduct();
}
