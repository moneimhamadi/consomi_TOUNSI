
 package tn.esprit.spring.control;
import tn.esprit.spring.service.FileStrorageService;
import tn.esprit.spring.service.IProductService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Product;


@RestController
public class ProductControl {
	@Autowired
	FileStrorageService FSS;
	@Autowired
	IProductService productService;
	@Autowired IProductService IPS;
  
  
  @Autowired
	ProductRepository pr;
	
	//http://localhost:9090/SpringMVC/servlet/show-all-products
	@GetMapping("/show-all-products")
	@ResponseBody
	public List<Product> getAllProducts(){
		List <Product> list=productService.showAll();
		return list;
	}
	
	//http://localhost:9090/SpringMVC/servlet/GetByOneName/{productName}
	@GetMapping("/GetByOneName/{productName}")
	@ResponseBody 
	public Product RetrieveByName(@PathVariable("productName")String nameProd){
		return productService.GetByName(nameProd);
	}
	
	
	//http://localhost:9090/SpringMVC/servlet/GetById/{productId}
	@GetMapping("GetById/{productId}")
	@ResponseBody 
	public Product RetrieveById(@PathVariable("productId")int id){
		return productService.GetById(id);
	}
	
	
	//http://localhost:9090/SpringMVC/setrvlet/ShowAllByName/{productName}
	@GetMapping("ShowAllByName/{productName}")
	@ResponseBody 
	public List<Product> RetrieveAllByName(@PathVariable("productName")String name){
		return productService.GetAllByName(name);
	}
	

	
	
	//http://localhost:9090/SpringMVC/servlet/add-product
	@PostMapping("/add-product")
	@ResponseBody
	public Product addProduct(@RequestBody Product p) {
	Product prod = productService.addProduct(p);
	return prod;
	}
	
	
	
	//http://localhost:9090/SpringMVC/servlet/remove-product/{productId}
	@DeleteMapping("/remove-product/{productId}")
	@ResponseBody
	public void removeProduct(@PathVariable("productId") int id) {
	productService.deleteProduct(id);
	}
	
	
	//http://localhost:9090/SpringMVC/servlet/update-Product
	@PutMapping("/update-Product")
	@ResponseBody
	public Product updateProduct(@RequestBody Product p) {
	return productService.updateProduct(p);
			
	}
	
	//http://localhost:9090/SpringMVC/servlet/affect-image-to-product/{Idp}/{Idimage}
			@PutMapping("/affect-image-to-product/{Idp}/{Idimage}")
			public void affecterProduitARayon(@PathVariable(value = "Idp") int Idp,
					@PathVariable(value = "Idimage") int Idimage) {
				 IPS.assignImageToProduct(Idp, Idimage);
				
			}
  
  //http://localhost:9090/SpringMVC/servlet/gain-product
	@GetMapping("/gain-product")
	@ResponseBody
	public List<String> getgainproduct() {
	return pr.getgainproduct();
			
	}
	
	//http://localhost:9090/SpringMVC/servlet/total-gain-product
		@GetMapping("/total-gain-product")
		@ResponseBody
		public float gettotalgainproduct() {
		return pr.gettotalgainproduct();
		}
		
		//http://localhost:9090/SpringMVC/servlet/total-achat
		@GetMapping("/total-achat")
		@ResponseBody
		public float getallcostproduct() {
		return pr.getallcostproduct();
		}
		
		//http://localhost:9090/SpringMVC/servlet/total-vente
		@GetMapping("/total-vente")
		@ResponseBody
		public float getallbuyproduct() {
		return pr.getallbuyproduct();
		}

	
}
