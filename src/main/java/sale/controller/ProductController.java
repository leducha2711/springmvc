package sale.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sale.model.ProductDTO;
import sale.model.UserDTO;
import sale.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value= "/danh-sach-san-pham", method = RequestMethod.GET)
	public String listProducts(HttpServletRequest request) {
		
		List<ProductDTO> productDTOs = productService.getAllProduct();
		request.setAttribute("productDTOs", productDTOs);
		return "listProducts";
	}
	@RequestMapping(value= "/xoa-san-pham/{productID}", method = RequestMethod.GET)
	public String deleteProducts(HttpServletRequest request, @PathVariable(name="productID") int productID) {
		productService.delete(productID);
		return "redirect:/danh-sach-san-pham";
	}
	@RequestMapping(value= "/chi-tiet-san-pham/{productID}", method = RequestMethod.GET)
	public String viewProduct(HttpServletRequest request, @PathVariable(name="productID") int productID) {
		request.setAttribute("product",  productService.getProductById(productID));
		return "viewProduct";
	}
	
	
	@RequestMapping(value= "/them-san-pham", method = RequestMethod.GET)
	public String addProduct(HttpServletRequest request) {
		request.setAttribute("product", new ProductDTO());
		return "addProduct";
	}
	
	@RequestMapping(value= "/them-san-pham", method = RequestMethod.POST)
	public String addProduct(HttpServletRequest request,@ModelAttribute(name="product") ProductDTO  productDTO) {
		productService.addProduct(productDTO);
		return "redirect:/danh-sach-san-pham";
	}
	
	@RequestMapping(value= "/sua-san-pham/{productID}", method = RequestMethod.GET)
	public String editProduct(HttpServletRequest request, @PathVariable(name="productID") int productID) {
		request.setAttribute("product",  productService.getProductById(productID));
		return "editProduct";
	}
	@RequestMapping(value= "/sua-san-pham", method = RequestMethod.POST)
	public String editProduct(HttpServletRequest request,@ModelAttribute(name="product") ProductDTO productDTO) {
		productService.updateProduct(productDTO);
		return "redirect:/danh-sach-san-pham";
	}
}
