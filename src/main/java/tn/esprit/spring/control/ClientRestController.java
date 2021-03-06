package tn.esprit.spring.control;

import java.util.Date;
import java.util.List;

import java.util.Optional;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonBackReference;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.SexeType;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.IClientRepository;

import tn.esprit.spring.service.IClientService;


@RestController
public class ClientRestController {
	
	@Autowired 
	IClientService cS;
	
	
	
	@Autowired
	IClientRepository cR;

			// http://localhost:9090/SpringMVC/servlet/retrieve-all-clients
			@PreAuthorize("hasRole('ADMIN') ")
			@GetMapping("/retrieve-all-clients")
			@ResponseBody
			public List<Client> getclient() {
			List<Client> list = cS.retrieveAllClients();
			return list;
			}
			
			// http://localhost:9090/SpringMVC/servlet/retrieve-client-by-id/{user-id}
			@GetMapping("/retrieve-client-by-id/{user-id}")
			@ResponseBody
			public Client retrieveClient(@PathVariable("user-id") int userId) {
			return cS.retrieveClientById(userId);
			}
			
			// http://localhost:9090/SpringMVC/servlet/retrieve-client-by-rank/{client-rank}
			@GetMapping("/retrieve-client-by-rank/{client-rank}")
			@ResponseBody
			public List<Client> retrieveClientByRank(@PathVariable("client-rank") int rankClient) {
			return cS.retrieveClientByRankClient(rankClient);
			}
	
			// http://localhost:9090/SpringMVC/servlet/retrieve-client-by-point/{client-point}
			@GetMapping("/retrieve-client-by-point/{client-point}")
			@ResponseBody
			public List<Client> retrieveClientByPoint(@PathVariable("client-point") int pointNumberClient) {
			return cS.retrieveClientByPoint(pointNumberClient);
			}
			
			// http://localhost:9090/SpringMVC/servlet/retrieve-client-by-firstname/{client-firstname}
			@GetMapping("/retrieve-client-by-firstname/{client-firstname}")
			@ResponseBody
			public Client retrieveClientByFirstName(@PathVariable("client-firstname") String firstNameUser) {
			return cS.retrieveClientByFirstName(firstNameUser);
			}
			
			// http://localhost:9090/SpringMVC/servlet/retrieve-client-by-state/{client-state}
			@GetMapping("/retrieve-client-by-state/{client-state}")
			@ResponseBody
			public List<Client> retrieveClientByState(@PathVariable("client-state") boolean stateUser) {
			return cS.retrieveClientByState(stateUser);
			}
			
			// http://localhost:9090/SpringMVC/servlet/retrieve-client-by-adress/{client-adress}
			@GetMapping("/retrieve-client-by-adress/{client-adress}")
			@ResponseBody
			public List<Client> retrieveClientByAdress(@PathVariable("client-adress") String adressUser) {
			return cS.retrieveClientByAdress(adressUser);
			}
			
			// http://localhost:9090/SpringMVC/servlet/retrieve-client-by-date/{client-date}
			@GetMapping("/retrieve-client-by-date/{client-date}")
			@ResponseBody
			public List<Client> retrieveClientByDate(@PathVariable("client-date") Date birthDateUser) {
			return cS.retrieveClientByDate(birthDateUser);
			}
			
			// http://localhost:9090/SpringMVC/servlet/retrieve-client-by-sexe/{client-sexe}
			@GetMapping("/retrieve-client-by-sexe/{client-sexe}")
			@ResponseBody
			public List<Client> retrieveClientBySexe(@PathVariable("client-sexe") SexeType sexeUser) {
			return cS.retrieveClientBySexe(sexeUser);
			}
			
			
			// http://localhost:9090/SpringMVC/servlet/count-client
			@GetMapping("/count-client")
			@ResponseBody
			public long retrieveClientByCount() {
			return cS.retrieveClientByCount();
			}
			
			// http://localhost:9090/SpringMVC/servlet/add-client
			@PostMapping("/add-client")
			@ResponseBody
			public Client addClient(@RequestBody Client client) {
			Client cl = cS.addClient(client);
			
			return cl;
			}

			// http://localhost:9090/SpringMVC/servlet/delete-client/{user-id}
			@DeleteMapping("/delete-client/{user-id}")
			@ResponseBody
			public void deleteClient(@PathVariable("user-id") int userId) {
			cS.deleteClient(userId);
			}
			
			// http://localhost:9090/SpringMVC/servlet/update-client
			@PutMapping("/update-client")
			@ResponseBody
			public Client updateClient(@RequestBody Client client) {
			return cS.updateClient(client);
			}
			
			//http://localhost:9090/SpringMVC/servlet/get-all-name-client
			@GetMapping("/get-all-name-client")
			@ResponseBody
			public List<String> getAllClientNames(){
				return cR.getAllClientNames();
			}
			
			//http://localhost:9090/SpringMVC/servlet/get-max-rank
			@GetMapping("/get-max-rank")
			@ResponseBody
			public List<String> getMaxRank(){
				return cR.getMaxRank();
			}
			
			//http://localhost:9090/SpringMVC/servlet/get-phone-grouby-adress
			@GetMapping("/get-phone-grouby-adress")
			@ResponseBody
			public List<String> getphonegoupbyadress(){
				return cR.getphonegoupbyadress();
			}
			
			//http://localhost:9090/SpringMVC/servlet/get-min-age
			@GetMapping("/get-min-age")
			@ResponseBody
			public Date getminage(){
				return cR.getminage();
			}
			
			@PreAuthorize("hasAuthority('Admin') or hasAuthority('Client') or hasAuthority('DepartmentManager') or hasAuthority('DeliveryPerson')")
			@DeleteMapping("/deleteUserById/{userId}")
			public void deleteUserById(@PathVariable("userId") Integer userId) throws Exception {
				cS.deleteUserById(userId);
			}

			@PreAuthorize("hasAuthority('Admin') or hasAuthority('Client') or hasAuthority('DepartmentManager') or hasAuthority('DeliveryPerson')")
			@PutMapping("/activateUser")
			public Client activateUser(@RequestBody Client user) throws Exception {
				return cS.activateUser(user);
			}

			@PreAuthorize("hasAuthority('Admin') or hasAuthority('Client') or hasAuthority('DepartmentManager') or hasAuthority('DeliveryPerson')")
			@PutMapping("/desactivateUser")
			public Client desactivateUser(@RequestBody Client user) throws Exception {
				return cS.desactivateUser(user);
			}

			@PreAuthorize("hasAuthority('Admin') or hasAuthority('Client') or hasAuthority('DepartmentManager') or hasAuthority('DeliveryPerson')")
			@GetMapping("/findUserBylogin/{username}")
			public Client findUserByfirstNameUser(@PathVariable("username") String username) throws Exception {
				return (Client) cS.findUserByfirstNameUser(username);
			}

			@PreAuthorize("hasAuthority('Admin') or hasAuthority('Client') or hasAuthority('DepartmentManager') or hasAuthority('DeliveryPerson')")
			@GetMapping("/findUserRole/{IdUser}")
			public String findUserRole(@PathVariable("IdUser") int IdUser) throws Exception {
				return cS.getUserRoleDescription(IdUser);
			}

			@PreAuthorize("hasAuthority('Admin') or hasAuthority('Client') or hasAuthority('DepartmentManager') or hasAuthority('DeliveryPerson')")
			@GetMapping("/findActivatedUser/")
			public List<String> findUserActivated() throws Exception {
				return cS.findUsersActivated();
			}

			@PreAuthorize("hasAuthority('Admin') or hasAuthority('Client') or hasAuthority('DepartmentManager') or hasAuthority('DeliveryPerson')")
			@GetMapping("/findDisabledUser/")
			public List<String> findUserDisabled() throws Exception {
				return cS.getUsersFromDisabled();
			}

}
