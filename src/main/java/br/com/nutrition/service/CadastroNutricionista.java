package br.com.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.nutrition.datasource.model.Nutricionista;
import br.com.nutrition.repository.NutricionistaRepository;

public class CadastroNutricionista {
	
	@Autowired
	private NutricionistaRepository nutricionistaRepository;
	
	public void cadastrar(Nutricionista nutricionista) {
		nutricionistaRepository.saveAndFlush(nutricionista);
	}

}
