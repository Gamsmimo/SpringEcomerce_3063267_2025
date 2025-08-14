package com.sena.ejercicio1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.ejercicio1.model.DetalleOrden;

@Repository
public interface IDetalleOrden extends JpaRepository<DetalleOrden, Integer> {

}
