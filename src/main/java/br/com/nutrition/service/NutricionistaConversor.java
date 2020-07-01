package br.com.nutrition.service;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import br.com.nutrition.datasource.model.Nutricionista;
import br.com.nutrition.exception.NutricionistaResourceException;
import br.com.nutrition.resource.model.NutricionistaResource;

@Component
public class NutricionistaConversor {

	public Nutricionista conversor(NutricionistaResource nutricionistaResource) throws NutricionistaResourceException {
		
		try {
			Nutricionista nutricionista = new Nutricionista();
			
			Long idPaciente = checkIdPaciente(nutricionistaResource.getIdPaciente());
			LocalDate idade = checkIdade(nutricionistaResource.getIdade());
			nutricionista.setIdPaciente(idPaciente);
			nutricionista.setIdade(idade);
			nutricionista.setCodigoRegistro(nutricionistaResource.getCodigo_registro());
			nutricionista.setNome(nutricionistaResource.getNome());
			return nutricionista;
		} catch (Exception e) {
			throw new NutricionistaResourceException("Falha ao converter o resource para entidade, resource: " + nutricionistaResource);
		}
	}
	
	private Long checkIdPaciente(String idPaciente) {
		return Long.parseLong(idPaciente);
	}
	
	private LocalDate checkIdade(String idade) {
		return LocalDate.parse(idade);
	}
}
