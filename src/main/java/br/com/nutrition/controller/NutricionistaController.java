package br.com.nutrition.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nutrition.datasource.model.Nutricionista;
import br.com.nutrition.repository.NutricionistaRepository;
import br.com.nutrition.resource.model.NutricionistaResource;
import br.com.nutrition.service.BuscarNutricionistasServiceImpl;
import br.com.nutrition.service.CadastroNutricionistaServiceImpl;

@RestController
@RequestMapping(value = "/api")
public class NutricionistaController {

	@Autowired
	private NutricionistaRepository nutricionistaRepository;
	
	@Autowired
	private BuscarNutricionistasServiceImpl serviceBusca;
	
	@Autowired
	private CadastroNutricionistaServiceImpl serviceCadastro;
	
	@GetMapping(path="/nutricionistas")
	public List<Nutricionista> buscarListaNutricionistas(){
		return serviceBusca.buscarTodosNutricionistas();
	}
	
	@GetMapping(path="/nutricionista/id/{}")
	public ResponseEntity<Optional<Nutricionista>> buscarNutricionistaPorId(@PathVariable(name="id", required = true) Long idNutricionista) {
		return ResponseEntity.ok(nutricionistaRepository.findById(idNutricionista));
	}
	
	@PostMapping(path="/nutricionista/save")
	public void salvarNutricionista(@RequestBody NutricionistaResource nutricionista) {
		serviceCadastro.cadastro(nutricionista);
	}
	
	@DeleteMapping(path="/nutricionista/id/{id}")
	public void deletarNutricionista(@PathVariable(name="id", required = true) Long id) {
		nutricionistaRepository.deleteById(id);
	}
	
	
}
