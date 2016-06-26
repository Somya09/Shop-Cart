package com.niit.shopcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopcart.model.*;
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	private SessionFactory sessionFactory;


	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public List<com.niit.shopcart.model.Category> list() {
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) sessionFactory.getCurrentSession()
		.createCriteria(Category.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

return listCategory;
		
	}
	@Transactional
	public com.niit.shopcart.model.Category get(String id) {
		String hql = "from Category where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		
		return null;
	}
	
@Transactional
	public void saveOrUpdate(com.niit.shopcart.model.Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		
	}
@Transactional
	public void delete(String id) {
	com.niit.shopcart.model.Category CategoryToDelete=new com.niit.shopcart.model.Category();
	CategoryToDelete.setId(id);
	sessionFactory.getCurrentSession().delete(CategoryToDelete);
		
	}

		
}