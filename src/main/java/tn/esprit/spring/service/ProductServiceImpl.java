
package tn.esprit.spring.service;



import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.FileRepository;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.entities.FileDB;
import tn.esprit.spring.entities.Product;



@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired 
	FileRepository filerepository;
	
	
	
	
	private static final Logger L = LogManager.getLogger(IProductService.class);
	
	@Override
	public List<Product> showAll() {
		List<Product> products =(List<Product>) productRepository.findAll();
		for (Product product : products){
			L.info("Product +++ :" + product);
		}
		return products;

	}

	@Override  
	public Product addProduct(Product p) {
		productRepository.save(p);
		return p;
	}

	@Override //done
	public void deleteProduct(int id) {
		if (productRepository.existsById(id))
		{
		productRepository.deleteById(id);
		}
		else System.out.println("Product with id:"+id+" Not exist");
	}

 

	@Override
	public Product GetById(int id) {
		return productRepository.findById(id).orElse(null); 	
	}

	@Override
	public Product GetByName(String nameProduct) {
		return productRepository.findByTitleProduct(nameProduct);
		 
	}

	@Override
	public List<Product> GetAllByName(String nameProduct) {
		List<Product> products =(List<Product>) productRepository.findAllByTitleProduct(nameProduct);
		for (Product product : products){
			L.info("Product +++ :" + product);
		}
		return products;
		
		
	}




	@Override
	public Product updateProduct(Product p) {
		
		Product existingProduct=productRepository.findById(p.getIdProduct()).orElse(null);
		
		productRepository.findById(p.getIdProduct());
	
		existingProduct.setTitleProduct(p.getTitleProduct());
		existingProduct.setDescriptionProduct(p.getDescriptionProduct());
		existingProduct.setQuantityProduct(p.getQuantityProduct());
		existingProduct.setPriceProduct(p.getPriceProduct());
		existingProduct.setBarcodeProduct(p.getBarcodeProduct());
		existingProduct.setWeightProduct(p.getWeightProduct());
		existingProduct.setBuyingPriceProduct(p.getBuyingPriceProduct());
		existingProduct.setMaxQuantityProduct(p.getMaxQuantityProduct());
	
		return 	productRepository.save(existingProduct);
	
	}


	

	@Override
	public void assignImageToProduct(int idProduct, int idImage) {
		Product product=productRepository.findById(idProduct).get();
		FileDB image=filerepository.findById(idImage).get();
		image.setProduct(product);
		filerepository.save(image);	
		
	}


	
	
	
	
	
	
	}











































//@Override
//public void readBarCode(String path) {
//
//	try {
//		 
//
//		BufferedImage bf = ImageIO.read(new FileInputStream(path));
//		
//		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
//				new BufferedImageLuminanceSource(bf)));
//		
//		Result result = new MultiFormatReader().decode(bitmap);
//		
//		System.out.println(result.getText());
//		
//	} catch(Exception e) {
//		System.out.println("Error while reading barcode " + e.getMessage());
//	}
//	}
//@Query("select c from Contract where c.reference:=c and c.dateDebut=d and c.typeContract=t")
//



