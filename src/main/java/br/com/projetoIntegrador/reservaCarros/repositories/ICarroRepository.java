package br.com.projetoIntegrador.reservaCarros.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoIntegrador.reservaCarros.model.CarroModel;

public interface ICarroRepository extends JpaRepository<CarroModel, UUID>{

}
