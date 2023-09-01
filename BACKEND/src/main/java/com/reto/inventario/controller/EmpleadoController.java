package com.reto.inventario.controller;

import com.reto.inventario.dto.Mensaje;
import com.reto.inventario.entity.Empleado;
import com.reto.inventario.service.EmpleadoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Empleado>> list(){
        List<Empleado> list = empleadoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
//FILTROS
    @GetMapping("/detail/{id}")
    public ResponseEntity<Empleado> getById(@PathVariable("id") int id){
        if(!empleadoService.existsById(id))
            return new ResponseEntity(new Mensaje("empleado no existe"), HttpStatus.NOT_FOUND);
        Empleado empleado = empleadoService.getOne(id).get();
        return new ResponseEntity(empleado, HttpStatus.OK);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Empleado empleado){
        if(StringUtils.isBlank(empleado.getCedula()))
            return new ResponseEntity(new Mensaje("La cédula es obligatoria"), HttpStatus.BAD_REQUEST);
        if(empleadoService.existsByNombres(empleado.getNombres()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        empleadoService.save(empleado);
        return new ResponseEntity(new Mensaje("empleado creado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody Empleado empleado){
        if(!empleadoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(empleadoService.existsByNombres(empleado.getNombres()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
            Empleado empleadoActual = empleadoService.getOne(id).get();
            empleadoActual.setCedula(empleado.getCedula());
            empleadoActual.setCedula(empleado.getCedula());
            empleadoActual.setNombres(empleado.getNombres());
            empleadoActual.setApellidos(empleado.getApellidos());
            empleadoActual.setEmail(empleado.getEmail());
            empleadoActual.setFechaNacimiento(empleado.getFechaNacimiento());
            empleadoActual.setDireccion(empleado.getDireccion());
            empleadoActual.setTelefono(empleado.getTelefono());
            empleadoActual.setEstado(empleado.getEstado());
            empleadoActual.setTipoVacuna(empleado.getTipoVacuna());
            empleadoActual.setFechaVacuna(empleado.getFechaVacuna());
            empleadoActual.setNumeroDosis(empleado.getNumeroDosis());
        empleadoService.save(empleado);
        return new ResponseEntity(new Mensaje("Datos del empleado actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!empleadoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        empleadoService.delete(id);
        return new ResponseEntity(new Mensaje("empleado eliminado"), HttpStatus.OK);
    }


}
