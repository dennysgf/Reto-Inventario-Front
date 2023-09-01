package com.reto.inventario.service;

import com.reto.inventario.entity.Empleado;
import com.reto.inventario.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;
    public List<Empleado> list(){
        return empleadoRepository.findAll();
    }
    public Optional<Empleado>getOne(int id){
        return empleadoRepository.findById(id);
    }
    public void save (Empleado empleado){
        empleadoRepository.save(empleado);
    }
    public void delete(int id){
        empleadoRepository.deleteById(id);
    }
    public boolean existsByNombres(String nombres){
        return empleadoRepository.existsByNombres(nombres);
    }
    public boolean existsById(int id){
        return empleadoRepository.existsById(id);
    }



}
