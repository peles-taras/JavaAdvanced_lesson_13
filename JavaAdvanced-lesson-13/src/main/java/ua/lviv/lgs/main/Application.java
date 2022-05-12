package ua.lviv.lgs.main;

import java.util.Date;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.ProductService;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.BucketServiceImpl;
import ua.lviv.lgs.service.impl.ProductServiceImpl;
import ua.lviv.lgs.service.impl.UserServiceImpl;

@SuppressWarnings("unused")
public class Application {

	public static void main(String[] args) {

		UserService userService = new UserServiceImpl();
		ProductService productService = new ProductServiceImpl();
		BucketService bucketService = new BucketServiceImpl();

//		userService.create(new User("email", "userName", "userSurname", "Admin"));
//		System.out.println(userService.read(1));
//		userService.update(new User("updatedEmail123", "updatedName321", "updatedSurname222", "updatedRoleAA"), 1);
//		userService.delete(1);
//		userService.readAll();
		
//		productService.create(new Product("testProduct2", "testDescription2", 999.99));
//		System.out.println(productService.read(1));
//		productService.update(new Product("updatedName", "updatedDescription", 1111.0), 1);
//		productService.delete(2);
//		productService.readAll();

//		bucketService.create(new Bucket(1, 1, new Date()));
//		System.out.println(bucketService.read(1));
//		bucketService.delete(1);
//		bucketService.readAll();

	}
}
