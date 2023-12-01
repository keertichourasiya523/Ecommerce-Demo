package com.springboot.SMS.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.SMS.model.Product;
import com.springboot.SMS.service.CategoryService;
import com.springboot.SMS.service.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
//	
//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//	@Autowired
//	RoleRepository roleRepository;
//	
//	@Autowired
//	UserRepository userRepository;
//	
//	
//	@GetMapping({"/","/home"})
//	public String home(Model model)
//	{
//		model.addAttribute("cartCount", Globaldata.cart.size());
//		return "index";
//	}
	
	
	@GetMapping("/shop")
	public String shop(Model model)
	{
		model.addAttribute("categories", categoryService.getAllCategory());
		model.addAttribute("products", productService.getAllProduct());
		//model.addAttribute("cartCount", Globaldata.cart.size());
		return "shop";
	}
	
	@GetMapping("shop/category/{id}")
	public String shopByCategory(Model model, @PathVariable int id)
	{
		model.addAttribute("categories", categoryService.getAllCategory());
		model.addAttribute("products", productService.getAllProductByCategoryId(id));
		//model.addAttribute("cartCount", Globaldata.cart.size());
		return "shop";
	}
	
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(Model model,@PathVariable long id)
	{
		//model.addAttribute("products", productService.getProductById(id).get());
		Optional<Product> product = productService.getProductById(id);
		model.addAttribute("product", product.get());
		//model.addAttribute("cartCount", Globaldata.cart.size());
		return "viewProduct";
	}
//	
//	
	
	
	
//	
//	@PostMapping("/register")
//	public String registerPost(@ModelAttribute("user") User user, HttpServletRequest request)throws ServletException
//	{
//		String password = user.getPassword();
//		user.setPassword(bCryptPasswordEncoder.encode(password));
//		List<Role> roles = new ArrayList<>();
//		roles.add(roleRepository.findById(2).get());
//		user.setRoles(roles);
//		userRepository.save(user);
//		request.login(user.getEmail(), password);
//		return "redirect:/";
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
