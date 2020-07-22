package sale.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sale.dao.ProductDao;
import sale.entity.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;

	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}

	public void updateProduct(Product product) {
		sessionFactory.getCurrentSession().merge(product);
	}

	public void delete(int id) {
		sessionFactory.getCurrentSession().delete(getProductById(id));
	}

	public Product getProductById(int id) {
		return sessionFactory.getCurrentSession().get(Product.class, id);

	}

	public List<Product> getAllProduct() {
		 Session session = this.sessionFactory.getCurrentSession();
		    return session.createQuery("FROM product", Product.class).getResultList();
	}

}
