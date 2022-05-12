package ua.lviv.lgs.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.shared.FactoryManager;

public class BucketDaoImpl implements BucketDao {

	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Bucket create(Bucket bucket) {
		try {
			em.getTransaction().begin();
			em.persist(bucket);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Bucket read(Integer id) {
		return em.find(Bucket.class, id);
	}

	@Override
	public Bucket update(Bucket bucket, Integer id) {
		throw new IllegalStateException("update method for Bucket is disabled");
	}

	@Override
	public void delete(Integer id) {
		try {
			Bucket bucket = read(id);
			em.getTransaction().begin();
			em.remove(bucket);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bucket> readAll() {
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Bucket e");
		} catch (Exception e) {
			System.out.println(e);
		}
		return query.getResultList();
	}

	@Override
	public void deleteString(String id) {
		try {
			Bucket bucket = readString(id);
			em.getTransaction().begin();
			em.remove(bucket);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	private Bucket readString(String id) {
		return em.find(Bucket.class, id);
	}
}
