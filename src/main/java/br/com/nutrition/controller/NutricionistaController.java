package br.com.nutrition.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nutrition.datasource.model.Nutricionista;
import br.com.nutrition.repository.NutricionistaRepository;

@RestController
@RequestMapping(value = "/api")
public class NutricionistaController {

	@Autowired
	private NutricionistaRepository nutricionistaRepository;
	
	@GetMapping(path="/nutricionistas")
	public List<Nutricionista> buscarListaNutricionistas(){
		return nutricionistaRepository.findAll();
	}
	
	@GetMapping(path="/nutricionista/id/{}")
	public ResponseEntity<Optional<Nutricionista>> buscarNutricionistaPorId(@PathVariable(name="id", required = true) Long idNutricionista) {
		return ResponseEntity.ok(nutricionistaRepository.findById(idNutricionista));
	}
	
	@PostMapping(path="/nutricionista/save")
	public void salvarNutricionista(Nutricionista nutricionista) {
		nutricionistaRepository.save(nutricionista);
	}
	
	@DeleteMapping(path="/nutricionista/id/{id}")
	public void deletarNutricionista(@PathVariable(name="id", required = true) Long id) {
		nutricionistaRepository.deleteById(id);
	}
	
	
}
