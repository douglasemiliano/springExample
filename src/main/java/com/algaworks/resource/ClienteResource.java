package com.algaworks.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
import com.algaworks.model.Cliente;
 
@RestController
public class ClienteResource {
 
	private Map<Integer, Cliente> clientes;
 
	public ClienteResource() {
		clientes = new HashMap<Integer, Cliente>();
 
 
    Cliente c1 = new Cliente(1, "Douglas Emiliano", 60);
    Cliente c2 = new Cliente(2, "Heitor Oliveira", 45);
    Cliente c3 = new Cliente(3, "Alisson Victor", 90);
    Cliente c4 = new Cliente(4, "Willams Pinto", 60);
 
    clientes.put(1,c1);
    clientes.put(2,c2);
    clientes.put(3,c3);
    clientes.put(4,c4);
  }
 
	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	  public ResponseEntity<List<Cliente>> listar() {
	    return new ResponseEntity<List<Cliente>>(new ArrayList<Cliente>(clientes.values()), HttpStatus.OK);
	  }
	
	  @RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET)
	  public ResponseEntity<Cliente> buscar(@PathVariable("id") Integer id) {
	    Cliente cliente = clientes.get(id);
	   
	    if (cliente == null) {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	   
	    return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	  }
	  
	  @RequestMapping(value = "/clientes/{id}", method = RequestMethod.DELETE)
	  public ResponseEntity<?> deletar(@PathVariable("id") int id) {
	    Cliente cliente = clientes.remove(id);
	   
	    if (cliente == null) {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	   
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
		
	  @RequestMapping(value = "/clientes/", method = {RequestMethod.POST})
		public ResponseEntity<Cliente> adicionarCliente(@RequestBody Cliente cliente) {
			return new ResponseEntity<>(clientes.put(5, cliente), HttpStatus.OK);
		}
}