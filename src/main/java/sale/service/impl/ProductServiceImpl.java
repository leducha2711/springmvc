package sale.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sale.dao.ProductDao;
import sale.entity.Product;
import sale.model.ProductDTO;
import sale.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	public void addProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setProductName(productDTO.getProductName());
		product.setPrice(productDTO.getPrice());
		
		productDao.addProduct(product);
	}

	public void updateProduct(ProductDTO productDTO) {
		
		Product product = productDao.getProductById(productDTO.getId());
		if(product!= null) {
			
			product.setProductName(productDTO.getProductName());
			product.setPrice(productDTO.getPrice());
			
			productDao.updateProduct(product);
		}
		
	}

	public void delete(int id) {
		Product product = productDao.getProductById(id);
		if(product!= null) {
			productDao.delete(id);
		}
	}

	public ProductDTO getProductById(int id) {
		Product product = productDao.getProductById(id);
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setProductName(product.getProductName());
		productDTO.setPrice(product.getPrice());
		
		return productDTO;
	}

	public List<ProductDTO> getAllProduct() {
		
		List<Product> products = productDao.getAllProduct();
		
		List<ProductDTO> productDTOs = new  ArrayList<ProductDTO>();
		for (Product product : products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setProductName(product.getProductName());
			productDTO.setPrice(product.getPrice());
			
			productDTOs.add(productDTO);
		}
		
		return productDTOs;
	}

}
