package com.reto.inventario.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String cedula;

    private String nombres;


    private String apellidos;


    private String email;

    /**Datos que el empleado deberá añadir adicionalmente */
    @Column(name="fecha_nacimiento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;


    @Column(nullable = true)
    private String direccion;

    @Column(nullable = true)
    private Integer telefono;

    @Column(nullable = true)
    private String estado;

    @Column(name="tipo_vacuna", nullable = true)
    private String tipoVacuna;
    @Column(name="fecha_vacuna")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaVacuna;


    @Column(name="numero_dosis", nullable = true)
    private Integer numeroDosis;


    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    //** LLamada de métodos getters y setters */


    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Integer getTelefono() {
        return telefono;
    }
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getTipoVacuna() {
        return tipoVacuna;
    }
    public void setTipoVacuna(String tipoVacuna) {
        this.tipoVacuna = tipoVacuna;
    }
    public Date getFechaVacuna() {
        return fechaVacuna;
    }
    public void setFechaVacuna(Date fechaVacuna) {
        this.fechaVacuna = fechaVacuna;
    }
    public Integer getNumeroDosis() {
        return numeroDosis;
    }
    public void setNumeroDosis(Integer numeroDosis) {
        this.numeroDosis = numeroDosis;
    }
    private static final long serialVersionUID = 1L;
}
