package br.com.projetoIntegrador.reservaCarros.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data //getters e setters
@Entity(name = "tb_usuario")
public class UsuarioModel {
	
	@Id
	@GeneratedValue(generator = "UUID")
	private UUID id;
	
	@Column(unique = true) //atributo único
	private String login;
	private String senha;
	private String nome;
	private Number ativo;
	private Date dt_nascimento;

	private UUID idUser;
	
	@CreationTimestamp
	private LocalDateTime dt_cadastro;
	
}
