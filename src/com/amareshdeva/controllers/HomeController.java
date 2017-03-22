package com.amareshdeva.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.FormSubmitEvent.MethodType;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.amareshdeva.bean.BrandBean;
import com.amareshdeva.bean.ProductBean;
import com.amareshdeva.bean.UserRegistration;
import com.amareshdeva.dao.HomeDao;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
public class HomeController {
@Autowired
private HomeDao dao;



@RequestMapping(value="/index",method=RequestMethod.GET)
public ModelAndView welcome()
{
return new ModelAndView("index");	
}
			/*Registration process*/
@RequestMapping(value="/userregister",method=RequestMethod.GET)
public ModelAndView register()
{
	return new ModelAndView("userregister", "register", new UserRegistration());
	
}

@RequestMapping(value="/saveuser",method=RequestMethod.POST)
public ModelAndView saveUser(@ModelAttribute("command") UserRegistration userRegistration)
{
	
	dao.saveUser(userRegistration);
	return new ModelAndView("registrationsuccess");
}

/*user Login Controller*/


@RequestMapping(value="/userLogin",method=RequestMethod.GET)
public ModelAndView toLogin(Model model) {
		return new ModelAndView("userlogin", "userBean", new UserRegistration());
}

@RequestMapping(value="/login",method=RequestMethod.POST)
public ModelAndView doLogin(@ModelAttribute @Valid UserRegistration userBean,BindingResult result,HttpServletRequest request,HttpServletResponse response) {
	System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%:"+userBean.getEmail());
	HttpSession session = request.getSession();
	UserRegistration userinfo = new UserRegistration();
	userinfo = dao.getUserInfo(userBean);
	System.out.println("&&&&&&&&&&&&&&&&&&&&&&&:"+userinfo);
	if(userinfo!=null){
		System.out.println("user--"+userinfo.getEmail()+"---"+userinfo.getPassword() );
		if(userinfo.getPassword().equals(userBean.getPassword())){
			session.setAttribute("userDtl", userinfo);
			BrandBean brand = new BrandBean();
			System.out.println("yes---------");
			
			return new ModelAndView("welcome","brand",brand);
		}else{
			System.out.println("no--------------");
			UserRegistration user = new UserRegistration();
			user.setError("Login Failed");
		//	return new ModelAndView("redirect:/userLogin.html");
			return new ModelAndView("userlogin", "userBean",user);
		}
	}else{
		System.out.println("%%%%%%%%%%%%%%%%%55");
		return new ModelAndView("userlogin","error","Email is Invalid");
		
	}
}

/*admin login controller*/
@RequestMapping(value="/adminLogoin",method=RequestMethod.GET)
public ModelAndView admin()
{
	return new ModelAndView("adminLogin","admin",new UserRegistration());
	
}
@RequestMapping(value="/adminLoginContorller",method =RequestMethod.POST)
public ModelAndView adminController(@ModelAttribute @Valid UserRegistration admin,BindingResult result,HttpServletRequest request,HttpServletResponse response)
{
	HttpSession session = request.getSession();
	
	if(admin.getName().equals("admin")&&admin.getPassword().equals("admin"))
	{
		
		return new ModelAndView("adminHome","admin1",admin);
	}
	else
		
	{
		UserRegistration admin1 = new UserRegistration();
		admin1.setError("Admin login failed");
		//String aa = "Adming Login Failed";
		return new ModelAndView("adminLogin", "admin", admin1);
	}
	
}
/*Add products*/
@RequestMapping(value="/addproducts",method=RequestMethod.GET)
public ModelAndView addProducts()
{
	return new ModelAndView("addprouct", "addprod", new BrandBean());
}

@RequestMapping(value="/addBrandController",method = RequestMethod.POST)
public ModelAndView addBrand(@ModelAttribute("command")BrandBean brandBean,BindingResult result)
{
	dao.addBrand(brandBean);
	return new ModelAndView("viewBrand");
	
}

/*view upload Brand*/
@RequestMapping(value="/viewBrand",method=RequestMethod.GET)
public ModelAndView viewBrands()
{
	List<BrandBean> list = dao.getListBrands();
	//System.out.println(list.size());
	return new ModelAndView("viewBrand", "brandname", list);
	
}

/*update brand*/
@RequestMapping(value="/editbrand/{id}",method = RequestMethod.GET)
public ModelAndView editBrand(@PathVariable int id)
{
	System.out.println("%%%%%%%%%%%%%%%%%%%%%%:"+id);
	BrandBean brand = dao.getBrandById(id);
	return new ModelAndView("editBrand", "command", brand);
	
}

/*upload products*/

@RequestMapping(value="/addProd",method=RequestMethod.GET)
public ModelAndView addProd()
{
	List<String> list = dao.getBrandList();
	
	ProductBean prod = new ProductBean();
	prod.setProdList(list);
	return new ModelAndView("uploadaddprod", "addprod", prod);
}

@RequestMapping(value="/addProdController",method = RequestMethod.POST)
public ModelAndView addProd(@ModelAttribute("command")ProductBean brandBean,BindingResult result)
{
	//dao.addProduct(brandBean);
	return new ModelAndView("viewBrand");
	
}
@RequestMapping(value="/seacrhVal",method=RequestMethod.POST)
public ModelAndView getSearchVal(@ModelAttribute("command")ProductBean brandBean,BindingResult result){
	System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBB:"+brandBean.getBrandname());
	List<ProductBean> prodList = new ArrayList<ProductBean>();
	prodList = dao.getProdList(brandBean);
	System.out.println("AAAAAAAAAAAAAAAAAAAAA:"+prodList.size());
	return new ModelAndView("searchResult", "productList", prodList);
	
}

@RequestMapping(value="/addProductController",method=RequestMethod.POST)
public ModelAndView uploadProducts(@ModelAttribute("command")ProductBean productBean,BindingResult result)
{
	dao.uploadProducts(productBean);
	return new ModelAndView("produploadsuccess");
	
}


@RequestMapping(value = "helloReport1", method = RequestMethod.GET)
@ResponseBody
public void getRpt1(HttpServletResponse response) throws JRException, IOException {
  InputStream jasperStream = this.getClass().getResourceAsStream("/jasperreports/HelloWorld1.jasper");
  Map<String,Object> params = new HashMap<>();
  JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
  JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

  response.setContentType("application/x-pdf");
  response.setHeader("Content-disposition", "inline; filename=helloWorldReport.pdf");

  final OutputStream outStream = response.getOutputStream();
  JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
}

}