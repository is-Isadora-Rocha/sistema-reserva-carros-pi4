package br.com.projetoIntegrador.reservaCarros.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data //getters e setters
@Entity(name = "tb_carro")
public class CarroModel {
	
	@Id
	@GeneratedValue(generator = "UUID")
	private UUID id;
	
	private String marca;
	private String modelo;
	private Date ano_Fabricacao;
	private Date ano_modelo;
	private String valor;
	private String descricao;
	
	private UUID idUsuario;
	

}
