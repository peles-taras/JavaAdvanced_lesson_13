package ua.lviv.lgs.web;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.ProductService;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.BucketServiceImpl;
import ua.lviv.lgs.service.impl.ProductServiceImpl;
import ua.lviv.lgs.service.impl.UserServiceImpl;

@WebServlet("/bucket")
public class BucketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BucketService bs = BucketServiceImpl.getBucketService();
	private ProductService ps = ProductServiceImpl.getProductService();
	private UserService us = UserServiceImpl.getUserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
			
		String product_id = request.getParameter("product_id");
		Integer user_id = (Integer) session.getAttribute("user_id");
		@SuppressWarnings("unused")
		String role = (String) session.getAttribute("role");
		User user = us.read(user_id);
		Product product = ps.read(Integer.parseInt(product_id));
		Bucket bucket = new Bucket();	
		
		Random rand = new Random();
		 int upperbound = 9999;
		 int int_random = rand.nextInt(upperbound);
		 
		
		 bucket.setId(Integer.toString(int_random)); 
		 bucket.setProduct(product);
		 bucket.setUser(user);
		 
		 Date date = new Date();
		  
		 bucket.setPurchase_date(date);  
		 bs.create(bucket);
		 		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("success");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		 String bucketId = req.getParameter("bucketId");
		 bs.deleteString(bucketId.toString());
		 
		 resp.setContentType("text"); 
		 resp.setCharacterEncoding("UTF-8");
		 resp.getWriter().write("success");

	}
	
}
