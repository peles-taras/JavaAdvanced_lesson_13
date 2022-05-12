package ua.lviv.lgs.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ua.lviv.lgs.dao.ProductDao;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.shared.FactoryManager;

public class ProductDaoImpl implements ProductDao {

	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Product create(Product product) {
		try {
			em.getTransaction().begin();
			em.persist(product);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		return product;
	}

	@Override
	public Product read(Integer id) {
		return em.find(Product.class, id);
	}

	@Override
	public Product update(Product product, Integer id) {
		try {
			// TODO
		} catch (Exception e) {
			System.out.println(e);
		}
		return product;
	}

	@Override
	public void delete(Integer id) {
		try {
			Product product = read(id);
			em.getTransaction().begin();
			em.remove(product);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> readAll() {
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Product e");
		} catch (Exception e) {
			System.out.println(e);
		}
		return query.getResultList();
	}

}
