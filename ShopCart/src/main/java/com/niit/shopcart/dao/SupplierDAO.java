package com.niit.shopcart.dao;

import java.util.List;
import com.niit.shopcart.model.Category;
import com.niit.shopcart.model.Supplier;

public interface SupplierDAO {
	public List<Supplier> list();

	public Supplier get(String id);

	public void saveOrUpdate(Supplier supplier);

	public void delete(String id);

}
