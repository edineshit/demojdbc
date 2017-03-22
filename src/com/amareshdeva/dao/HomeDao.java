package com.amareshdeva.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.dom4j.util.ProxyDocumentFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.amareshdeva.bean.BrandBean;
import com.amareshdeva.bean.ProductBean;
import com.amareshdeva.bean.UserRegistration;

@Repository
public class HomeDao {
private JdbcTemplate template;

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}
/*user Registration*/
public int saveUser(UserRegistration registration)
{
	//System.out.println(registration.getEmail());
	String sql = "insert into register(name,address,mobile,email,gender,city,state,country,pincode,password) values('"+registration.getName()+"','"+registration.getAddress()+"','"+registration.getMobile()+"','"+registration.getEmail()+"','"+registration.getGender()+"','"+registration.getCity()+"','"+registration.getState()+"','"+registration.getCountry()+"','"+registration.getPincode()+"','"+registration.getPassword()+"')";
	return template.update(sql);	
}
/*User Login */


@SuppressWarnings("deprecation")
public boolean authenticateUser(UserRegistration userBean){
	boolean userExists = false;
	int rowcount = template.queryForInt("select count(*) from register " +
			" where email = ? and password = ?",
			userBean.getEmail(),userBean.getPassword());
	if(rowcount==1){
		userExists = true;
	}
	return userExists;
}

public UserRegistration getUserInfo(UserRegistration userRegistration){
	
	return template.queryForObject("select * from register where email='"+userRegistration.getEmail()+"'",new BeanPropertyRowMapper<>(UserRegistration.class));
}

/*Add Brand*/
public int addBrand(BrandBean bname)
{
	String sql = "insert into brand(brandname,discription,status) values('"+bname.getBrandname()+"','"+bname.getDiscription()+"','"+bname.getStatus()+"')";
	return template.update(sql);
	
}
/*view upload brand*/
public List<BrandBean> getListBrands()
{
	 return template.query("select * from brand",new RowMapper<BrandBean>(){  
		
		@Override
		public BrandBean mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			BrandBean brand = new BrandBean();
			brand.setId(rs.getInt(1));
			brand.setBrandname(rs.getString(2));
			brand.setDiscription(rs.getString(3));
			return brand;
		}
	
});
}

/*Get Brand by name*/
public BrandBean getBrandById(int id)
{
	String sql = "select * from brand where id=?";
	return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<BrandBean>(BrandBean.class));
	
}
/*Get brand list*/
public List<String> getBrandList()
{
	String aa = "yes";
	 return template.query("select brandname from brand where status='"+aa+"'",new RowMapper<String>(){  
		
		@Override
		public String mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			//ProductBean brand1 = new ProductBean();
			//brand1.setBrandId(rs.getInt(1));
		//	brand1.setBrandname(rs.getString(1));
			return rs.getString(1);
		}
	
});
}
	
public int uploadProducts(ProductBean prod)
{
	String sql = "insert into uploadproducts(brandname,productname,discription,price,warrenty,status) values('"+prod.getBrandname()+"','"+prod.getProductname()+"','"+prod.getDiscription()+"','"+prod.getPrice()+"','"+prod.getProduct_warranty()+"','"+prod.getStatus()+"')";
	return template.update(sql);	
}

/*user search products*/
public List<ProductBean> getProdList(ProductBean productBean)
{
		 return template.query("select * from uploadproducts where productname like'"+productBean.getBrandname()+"' or brandname like'"+productBean.getBrandname()+"' or discription like'"+productBean.getBrandname()+"'  ",new RowMapper<ProductBean>(){  
		
		@Override
		public ProductBean mapRow(ResultSet rs, int row) throws SQLException {
			// TODO Auto-generated method stub
			ProductBean brand = new ProductBean();
			brand.setId(rs.getInt(1));
			brand.setBrandname(rs.getString(2));
			brand.setProductname(rs.getString(3));
			brand.setDiscription(rs.getString(4));
			brand.setPrice(rs.getInt(5));
			brand.setProduct_warranty(rs.getInt(6));
			return brand;
		}
	
});
}



}
