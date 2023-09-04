package com.reto.inventario.repository;

import com.reto.inventario.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    //querys
    Optional<Empleado>findByNombres(String nombres);
    boolean existsByNombres(String nombres);

    List<Empleado> findByTipoVacuna(String tipoVacuna);

    List<Empleado> findByEstado(String estado);

}
