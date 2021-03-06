
package tn.esprit.spring.control;

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
import tn.esprit.spring.entities.Publicity;
import tn.esprit.spring.service.FileStrorageService;
import tn.esprit.spring.service.IPublicityService;
@RestController
public class PublicityControl {
	
	@Autowired
	IPublicityService PS;
	@Autowired
	FileStrorageService FSS;
	
	//http://localhost:9090/SpringMVC/servlet/show-all-publicities
	@GetMapping("/show-all-publicities")
	@ResponseBody
	public List<Publicity> getAllPubs(){
		List <Publicity> list=PS.showAll();
		return list;
	}
	
	
	//http://localhost:9090/SpringMVC/servlet/get-by-Name-all-publicities-by-name/{PubName}
	@GetMapping("/get-by-Name-all-publicities-by-name/{PubName}")
	@ResponseBody 
	public List<Publicity> RetrieveByName(@PathVariable("PubName")String namePub){
		return PS.GetPublicitiesByName(namePub);
	}
	
	//http://localhost:9090/SpringMVC/servlet/show-all-publicities
	@GetMapping("get-by-id-publicity/{publicityId}")
	@ResponseBody 
	public Publicity RetrieveById(@PathVariable("publicityId")int id){
		return PS.GetPublicityById(id);
	}
	
	//http://localhost:9090/SpringMVC/servlet/add-publicity
	@PostMapping("/add-publicity")
	@ResponseBody
	public Publicity addPublicity(@RequestBody Publicity pub) {
	Publicity publicty = PS.addPublicity(pub);
	return publicty;
	}
	
	//http://localhost:9090/SpringMVC/servlet/remove-publicity/{pubId}
	@DeleteMapping("/remove-publicity/{pubId}")
	@ResponseBody
	public void removePublicity(@PathVariable("pubId") int id) {
	PS.deletePublicity(id);
	}
	
	
	//http://localhost:9090/SpringMVC/servlet/update-publicity
	@PutMapping("/update-publicity")
	@ResponseBody
	public Publicity updatepublicity(@RequestBody Publicity pub) {
	return PS.updatePublicity(pub);
			
	}
	
	//	http://localhost:9090/SpringMVC/servlet/affect-image-to-publicity/{Idpublicity}/{Idimage}
	@PutMapping("/affect-image-to-publicity/{Idpublicity}/{Idimage}")
	public void affectImageToPublicity(@PathVariable(value = "Idpublicity") int Idpublicity,
			@PathVariable(value = "Idimage") int Idimage) {
		 FSS.assignImageToPublicity(Idpublicity, Idimage);
	}
	
}