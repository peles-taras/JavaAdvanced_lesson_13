package ua.lviv.lgs.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.dto.BucketDto;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.ProductService;
import ua.lviv.lgs.service.impl.BucketServiceImpl;
import ua.lviv.lgs.service.impl.ProductServiceImpl;

@WebServlet("/buckets")
public class BucketsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BucketService bucketService = BucketServiceImpl.getBucketService();
	ProductService productService = ProductServiceImpl.getProductService();
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<Bucket> buckets = bucketService.readAll();
	Map<Integer, Product> idToProduct = productService.readAllMap();
	List<BucketDto> listOfBucketDtos = map(buckets, idToProduct);
	
	String json = new Gson().toJson(listOfBucketDtos);
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write(json);
	}
			
public List<BucketDto> map(List<Bucket> buckets, Map<Integer, Product> idToProduct){
				return	buckets.stream().map(bucket->{
					BucketDto bucketDto = new BucketDto();
					bucketDto.bucketId = bucket.getId();

					bucketDto.purchaseDate =  (Date) bucket.getPurchase_date();
			
					Product product = idToProduct.get(bucket.getProduct().getId());
				    bucketDto.name = product.getName();
				    bucketDto.description = product.getDescription();
				    bucketDto.price = product.getPrice();
				    
				    
					return bucketDto;
				}).collect(Collectors.toList());
				
			} 
}
