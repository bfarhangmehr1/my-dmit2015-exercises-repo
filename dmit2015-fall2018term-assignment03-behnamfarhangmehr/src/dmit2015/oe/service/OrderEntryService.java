package dmit2015.oe.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.time.DateUtils;

import dmit2015.oe.entity.Category;
import dmit2015.oe.entity.Customer;
import dmit2015.oe.entity.Order;
import dmit2015.oe.entity.ProductDescription;

import dmit2015.oe.entity.ProductInformation;
import dmit2015.oe.report.CategorySales;
import dmit2015.oe.report.ProductSales;

@Stateless
public class OrderEntryService {

	@Inject
	private EntityManager entityManager;
	
	public Order findOneOrder(long orderId) {
		// TODO: Complete the code for this method
		Order querySingleResult = null;
		try {
			querySingleResult = entityManager.createQuery(
				"SELECT o FROM Order o JOIN FETCH o.orderItems WHERE o.orderId = :orderIdValue",Order.class)
				.setParameter("orderIdValue", orderId)
				.getSingleResult();
		} catch(NoResultException e) {
			querySingleResult = null;
		}
		return querySingleResult;
	}
	
	public List<Order> findAllOrderByDateRange(Date startDate, Date endDate) {
		// TODO: Complete the code for this method
		List<Order> allOrderDateRange = null;
		try {			
			 allOrderDateRange = entityManager.createQuery(
						"SELECT o FROM Order o WHERE o.orderDate BETWEEN  :startDate AND :endDate")
						.setParameter("startDate", startDate,TemporalType.DATE)
						.setParameter("endDate",DateUtils.addDays(endDate, 1), TemporalType.DATE)
						.getResultList();
						
		} catch(NoResultException e) {
			allOrderDateRange = null;
		} 
		
		return allOrderDateRange;
	}
		
	public List<Order> findAllOrderByCustomerId(Long customerId) {
		// TODO: Complete the code for this method
	  List	<Order> allOrderByCustomer = null;
		
		try {			
			allOrderByCustomer = entityManager.createQuery(
						"SELECT o FROM Order o WHERE o.customer.customerId = :customerIdValue")
					  .setParameter("customerIdValue", customerId)
					    .getResultList();
						
		} catch(NoResultException e) {
			allOrderByCustomer = null;
		} 
		
		return allOrderByCustomer;
	}	
	
	public Customer findOneCustomer(long customerId) {
		Customer querySingleResult = null;
		try {
			querySingleResult = entityManager.createQuery(
				"SELECT c FROM Customer c  WHERE c.customerId = :customerIdValue",Customer.class)
				.setParameter("customerIdValue", customerId)
				.getSingleResult();
		} catch(NoResultException e) {
			querySingleResult = null;
		}
		return querySingleResult;		
	}
	
	public Customer findOneCustomerByUniqueValue(String queryValue) { 
		// TODO: Complete the code for this method
		
		Customer querySingleResult = null;		
		try {			
			querySingleResult = (Customer) entityManager.createNativeQuery(
					"SELECT * FROM CUSTOMERS c,TABLE(c.PHONE_NUMBERS)p where TO_CHAR(c.customer_id ) = :customerValue OR c.cust_email  = :customerValue OR p.COLUMN_VALUE =:customerValue ",Customer.class)
					.setParameter("customerValue", queryValue )
					.getSingleResult();						
		} catch(NoResultException e) {
			querySingleResult = null;
		} 
		
		return querySingleResult;
	}
	
	
	
	public List<ProductInformation> findAllProductInformationByPattern(String pattern) {
		List<ProductInformation> allOrderbyProduct = null;
		try {			
			allOrderbyProduct = entityManager.createQuery(
						"SELECT p FROM ProductInformation p WHERE LOWER(p.productName) LIKE LOWER(CONCAT('%',:querypattern,'%')) OR  LOWER(p.productDescription) LIKE LOWER(CONCAT('%',:querypattern,'%'))")
						.setParameter("querypattern",pattern)						
						.getResultList();						
		} catch(NoResultException e) {
			allOrderbyProduct = null;
		} 
		
		return allOrderbyProduct;
	}
	
	public ProductDescription findOneProductDescription(Long productId, String languageId) {
		ProductDescription querySingleResult = null;
		try {
			querySingleResult = entityManager.createQuery(
				"SELECT pk FROM ProductDescription pk  WHERE pk.id.productId = :productIdValue AND pk.id.languageId = :languageIdValue ",ProductDescription.class)
				.setParameter("productIdValue", productId)
				.setParameter("languageIdValue", languageId)
				.getSingleResult();
		} catch(NoResultException e) {
			querySingleResult = null;
		}
		return querySingleResult;	
		
		
	}
	
	public ProductInformation findOneProductInformation(long productId) {
		ProductInformation querySingleResult = null;
		try {
			querySingleResult = entityManager.createQuery(
				"SELECT p FROM ProductInformation p  WHERE p.productId = :productIdValue",ProductInformation.class)
				.setParameter("productIdValue", productId)
				.getSingleResult();
		} catch(NoResultException e) {
			querySingleResult = null;
		}
		return querySingleResult;		
	}
	
	
	public Category findOneCategory(long categoryId) {
		
		
		Category querySingleResult = null;		
		try {			
			querySingleResult = entityManager.createQuery(
					"SELECT c FROM Category c  WHERE c.categoryId = :categoryIdValue",Category.class)
					.setParameter("categoryIdValue", categoryId )
					.getSingleResult();						
		} catch(NoResultException e) {
			querySingleResult = null;
		} 
		
		return querySingleResult;
	}

	public List<Integer> findYearsWithOrders() {	
		
		return entityManager.createQuery(
				"SELECT YEAR(o.orderDate) "
				+ "FROM Order o "
				+ "WHERE YEAR(o.orderDate) IS NOT NULL "
				+ "GROUP BY YEAR(o.orderDate) "
				+ "ORDER BY YEAR(o.orderDate) "
				, Integer.class)
				.getResultList();		
	}
	
	public List<Category> findOnlineCatalogCategories() {
	return	entityManager.createQuery("SELECT DISTINCT p FROM Category c, IN (c.parentCategory)p", Category.class).getResultList();
		}
	
	
	public List<CategorySales> findCategorSalesForOnlineCatalog() {		
		
		return entityManager.createQuery(
				"SELECT new dmit2015.oe.report.CategorySales(c.parentCategory.categoryName, SUM(od.unitPrice * od.quantity)) "
				+ " FROM OrderItem od, IN (od.productInformation) p, IN (p.category) c, IN (od.order) o "
				+ " WHERE c.parentCategory.categoryId <> 90"
				+ " GROUP BY c.parentCategory.categoryName",
				CategorySales.class)
				.getResultList();
	}
	
	public List<CategorySales> findCategorSalesForOnlineCatalogYear(Integer year) {
		if( year ==null) {
			return entityManager.createQuery(
					"SELECT new dmit2015.oe.report.CategorySales(c.parentCategory.categoryName, SUM(od.unitPrice * od.quantity)) "
					+ " FROM OrderItem od, IN (od.productInformation) p, IN (p.category) c, IN (od.order) o "
					+ " WHERE c.parentCategory.categoryId <> 90"
					+ " GROUP BY c.parentCategory.categoryName",
					CategorySales.class)					
					.getResultList();
		}
		
		return entityManager.createQuery(
				"SELECT new dmit2015.oe.report.CategorySales(c.parentCategory.categoryName, SUM(od.unitPrice * od.quantity)) "
				+ " FROM OrderItem od, IN (od.productInformation) p, IN (p.category) c, IN (od.order) o "
				+ " WHERE c.parentCategory.categoryId <> 90  AND YEAR(o.orderDate) = :yearValue"
				+ " GROUP BY c.parentCategory.categoryName",
				CategorySales.class)
				.setParameter("yearValue", year)
				.getResultList();
	
	}
	
	public List<CategorySales> findCategorSalesForParentCategoryId(Long parentCategoryId) {	
		
    
	  	  		return entityManager.createQuery(
				"SELECT new dmit2015.oe.report.CategorySales(c.categoryName, SUM(od.unitPrice * od.quantity)) "
				+ " FROM OrderItem od, IN (od.productInformation) p, IN (p.category) c , IN (c.parentCategory) pc , IN ( pc.parentCategory) pcg, IN (od.order) o "
				+ " WHERE pc.categoryId = :parentCategoryValue OR pcg.categoryId = :parentCategoryValue "
				+ " GROUP BY c.categoryName , c.categoryId",
				 CategorySales.class)
				.setParameter("parentCategoryValue", parentCategoryId)
				.getResultList();
        
  
	}
	
	public List<CategorySales> findCategorSalesForParentCategoryIdAndYear(Long parentCategoryId, Integer year) {
		return entityManager.createQuery(
				"SELECT new dmit2015.oe.report.CategorySales(c.categoryName, SUM(od.unitPrice * od.quantity)) "
				+ " FROM OrderItem od, IN (od.productInformation) p, IN (p.category) c , IN (c.parentCategory) pc , IN ( pc.parentCategory) pcg, IN (od.order) o "
				+ " WHERE (pc.categoryId = :parentCategoryValue OR pcg.categoryId = :parentCategoryValue ) AND YEAR(o.orderDate) = :yearValue "
				+ " GROUP BY c.categoryName, c.categoryId",
				 CategorySales.class)
				.setParameter("parentCategoryValue", parentCategoryId)
				.setParameter("yearValue", year)
				.getResultList();
	}
		
	public List<ProductSales> findProductSales(int maxResult) {			
		
		return entityManager.createQuery(
				"SELECT new dmit2015.oe.report.ProductSales( p.productName, SUM(od.unitPrice * od.quantity),c.categoryName,SUM(od.quantity),p.productId)"
				+ " FROM OrderItem od, IN (od.productInformation) p, IN (p.category) c, IN (od.order) o "				 
				+ " GROUP BY p.productId, p.productName, c.categoryName",
				ProductSales.class)					
				.setMaxResults(maxResult)
				.getResultList();

				
	}
	
	public List<ProductSales> findProductSalesForYear(Integer year, int maxResult) {	
		if( year == null) {
			return entityManager.createQuery(
					"SELECT new dmit2015.oe.report.ProductSales( p.productName, SUM(od.unitPrice * od.quantity),c.categoryName,SUM(od.quantity),p.productId)"
					+ " FROM OrderItem od, IN (od.productInformation) p, IN (p.category) c, IN (od.order) o "					
					+ " GROUP BY p.productId,  p.productName, c.categoryName",
					ProductSales.class)					
					.setMaxResults(maxResult)
					.getResultList();
		}
		
		return entityManager.createQuery(
				"SELECT new dmit2015.oe.report.ProductSales( p.productName, SUM(od.unitPrice * od.quantity),c.categoryName,SUM(od.quantity),p.productId)"
				+ " FROM OrderItem od, IN (od.productInformation) p, IN (p.category) c, IN (od.order) o "
				+ " WHERE YEAR(o.orderDate) = :yearValue "
				+ " GROUP BY p.productId,  p.productName, c.categoryName",
				ProductSales.class)				
				.setParameter("yearValue", year)
				.setMaxResults(maxResult)
				.getResultList();
	}
	
}
