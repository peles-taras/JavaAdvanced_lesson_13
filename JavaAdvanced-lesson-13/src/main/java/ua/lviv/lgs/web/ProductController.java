package ua.lviv.lgs.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.service.ProductService;
import ua.lviv.lgs.service.impl.ProductServiceImpl;

@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductService ps = ProductServiceImpl.getProductService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String price = request.getParameter("price");

		if (!name.isEmpty() && !description.isEmpty() && !price.isEmpty()) {
			ps.create(new Product(name, description, getValidatedPrice(price)));
		}
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("success");
	}

	private double getValidatedPrice(String price) {
		if (price == null || price.isEmpty()) {
			return 0;
		}
		return Double.parseDouble(price);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String productId = req.getParameter("id");
		Product product = ps.read(Integer.parseInt(productId));
		
		req.setAttribute("product", product);
		req.getRequestDispatcher("singleProduct.jsp").forward(req, resp);

	}

}
