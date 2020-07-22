package sale.service;

import java.util.List;

import sale.model.ProductDTO;

public interface ProductService {
	public void addProduct(ProductDTO productDTO);

	public void updateProduct(ProductDTO productDTO);

	public void delete(int id);

	public ProductDTO getProductById(int id);

	public List<ProductDTO> getAllProduct();
}
