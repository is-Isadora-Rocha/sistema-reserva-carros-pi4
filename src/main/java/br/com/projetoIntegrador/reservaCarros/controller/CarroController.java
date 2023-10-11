package br.com.projetoIntegrador.reservaCarros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoIntegrador.reservaCarros.model.CarroModel;
import br.com.projetoIntegrador.reservaCarros.repositories.ICarroRepository;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	private ICarroRepository carroRepository;
	
	public CarroModel salvarCarro(@RequestBody CarroModel carroModel) {
		var carro = this.carroRepository.save(carroModel);
		return carro;
	}
}
