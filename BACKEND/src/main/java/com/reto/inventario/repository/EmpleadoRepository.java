package com.reto.inventario.repository;

import com.reto.inventario.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    Optional<Empleado>findByNombres(String nombres);
    boolean existsByNombres(String nombres);

}
