package ci.innovlabs.PoissonnerieApi.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ci.innovlabs.PoissonnerieCore.ResponseData;
import ci.innovlabs.PoissonnerieCore.model.Client;
import ci.innovlabs.PoissonnerieCore.service.ClientDAO;

@RestController
public class ClientController {
	
	private ClientDAO clientDao = new ClientDAO();
	
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public Object getAllClients() {
		return new ResponseData(clientDao.findAll());
	}
	
	@RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
	public Object getClient(@PathVariable("id") long id) {
		
		ResponseData data;
		
		try {
			//Client client = clientDao.find(id);
			data = new ResponseData(clientDao.find(id));
		} catch (Exception e) {
			data = ResponseData.exceptionMessage(e.getMessage());
		}
		
		return data;
	}
	
	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public Object postClient(@RequestBody Client client) {
		return clientDao.createOrUpdate(client);
	}
}
