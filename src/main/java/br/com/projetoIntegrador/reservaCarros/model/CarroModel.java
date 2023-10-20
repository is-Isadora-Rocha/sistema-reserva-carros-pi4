package br.com.projetoIntegrador.reservaCarros.model;

import java.util.Date;
import java.util.UUID;

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

	public void setDescricao(String descricao) throws Exception {
		if(descricao.length() > 256) {
			throw new Exception("O campo de descrição deve conter no máximo 50 caracteres");
		}
		this.descricao = descricao;
	}
	

}
