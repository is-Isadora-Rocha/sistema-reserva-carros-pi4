package br.com.projetoIntegrador.reservaCarros.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoIntegrador.reservaCarros.model.UsuarioModel;

public interface IUsuarioRepository extends JpaRepository<UsuarioModel, UUID>{
	UsuarioModel findByLogin(String login);
}
