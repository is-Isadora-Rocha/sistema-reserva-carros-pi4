package br.com.projetoIntegrador.reservaCarros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoIntegrador.reservaCarros.model.UsuarioModel;
import br.com.projetoIntegrador.reservaCarros.repositories.IUsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired //ciclo de vida gerado pelo spring
	private IUsuarioRepository usuarioRepository;
	
	@PostMapping("/salvar")
	public ResponseEntity salvarUsuario(@RequestBody UsuarioModel usuarioModel) {
		var usuario = this.usuarioRepository.findByLogin(usuarioModel.getLogin());
		if(usuario != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe!");
		}
		
		var usuarioCriado = this.usuarioRepository.save(usuarioModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
	}

}
