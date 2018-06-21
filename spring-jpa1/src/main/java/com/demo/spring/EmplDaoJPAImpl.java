package com.demo.spring;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Emp;

@Repository
@Transactional
public class EmplDaoJPAImpl implements EmpDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public String save(Emp e) {
		em.persist(e);
		return "Emp Saved";
	}

	@Override
	public String delete(int empId) {
		Emp e = em.find(Emp.class, empId);
		if (e != null) {
			em.remove(e);
			return "Deleted";
		} else {

			return "Emp id not found";
		}
	}

	@Override
	public Emp findById(int id) {
		Emp e = em.find(Emp.class, id);
		return e;
	}

	@Override
	public List<Emp> getAll() {
		Query query = em.createQuery("select e from Emp e");
		List<Emp> emplist = query.getResultList();
		return emplist;
	}

	@Override
	public String saveSome(List<Emp> emps) {
		for (Emp e : emps) {
			em.persist(e);
		}
		return "Success";
	}

}
