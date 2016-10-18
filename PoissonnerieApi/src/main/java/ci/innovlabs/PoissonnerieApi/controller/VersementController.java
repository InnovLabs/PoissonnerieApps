package ci.innovlabs.PoissonnerieApi.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ci.innovlabs.PoissonnerieCore.ResponseData;
import ci.innovlabs.PoissonnerieCore.model.Versement;
import ci.innovlabs.PoissonnerieCore.service.VersementDAO;

@RestController
public class VersementController {
	
	private VersementDAO versementDAO = new VersementDAO();
	
	@RequestMapping(value = "/versements", method = RequestMethod.GET)
	public Object getAllClients() {
		return new ResponseData(versementDAO.findAll());
	}
	
	@RequestMapping(value = "/versements/{id}", method = RequestMethod.GET)
	public Object getClient(@PathVariable("id") long id) {
		ResponseData data;
		
		try {
			data = new ResponseData(versementDAO.find(id));
			
		} catch (Exception e) {
			data = ResponseData.exceptionMessage(e.getMessage());
		}
		
		return data;
	}
	
	@RequestMapping(value = "/versements", method = RequestMethod.POST)
	public Object postClient(@RequestBody Versement versement) {
		return versementDAO.createOrUpdate(versement);
	}
}
