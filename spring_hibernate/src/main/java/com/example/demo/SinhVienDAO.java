package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SinhVienDAO implements DAO {
	private EntityManager entityManager;

	@Autowired
	public SinhVienDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public SinhVienDAO() {
	}

	@Override
	public void create(SinhVien sv) {
		this.entityManager.persist(sv);
	}

	@Override
	public SinhVien getByID(int id) {
		return this.entityManager.find(SinhVien.class, id);
	}

	@Override
	public SinhVien update(SinhVien sv) {
		return this.entityManager.merge(sv);
	}

	@Override
	public void delete(SinhVien sv) {
		SinhVien managedSv = entityManager.find(SinhVien.class, sv.getId());
		if (managedSv != null) {
			entityManager.remove(managedSv);
		}
	}

	//

	@Override
	public List<SinhVien> getAll() {
		String jpql = "SELECT s FROM SinhVien s";
		return this.entityManager.createQuery(jpql, SinhVien.class).getResultList();
	}

	@Override
	public List<SinhVien> getByName(String name) {
		String jpql = "SELECT s FROM SinhVien s WHERE s.Ten = :ten";
		TypedQuery<SinhVien> query = this.entityManager.createQuery(jpql, SinhVien.class);
		query.setParameter("ten", name);
		return query.getResultList();
	}

	@Override
	public int updateAllName(String name) {
		String jpql = "UPDATE SinhVien s SET s.Ten = :ten";
		Query query = this.entityManager.createQuery(jpql);
		query.setParameter("ten", name);
		return query.executeUpdate();
	}

	@Override
	public void deleteByName(String s) {
		String jpql = "DELETE FROM SinhVien s WHERE s.Ten = :ten ";
		Query query = this.entityManager.createQuery(jpql);
		query.setParameter("ten", s);
		query.executeUpdate();
	}

}
