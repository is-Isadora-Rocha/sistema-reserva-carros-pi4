package br.com.projetoIntegrador.reservaCarros.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoIntegrador.reservaCarros.model.UsuarioModel;
import br.com.projetoIntegrador.reservaCarros.repositories.IUsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired //ciclo de vida gerado pelo spring
	private IUsuarioRepository usuarioRepository;
	
	@PostMapping("/salvar")
	public ResponseEntity salvarUsuario(@RequestBody UsuarioModel usuarioModel, HttpServletRequest request) {

		var idUser = request.getAttribute("idUser");
		usuarioModel.setIdUser((UUID) idUser);

		var usuario = this.usuarioRepository.findByLogin(usuarioModel.getLogin());
		if(usuario != null) {
			//mensagem de erro e status code
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.body("Usuário já existe!");
		}
		
		var usuarioCriado = this.usuarioRepository.save(usuarioModel);
		return ResponseEntity.status(HttpStatus.CREATED)
		.body(usuarioCriado);

	}

}
