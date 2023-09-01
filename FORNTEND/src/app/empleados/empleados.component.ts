import { Component } from '@angular/core';
import Swal from 'sweetalert2';
import { Empleados } from './empleados';
import { EmpleadosService } from './empleados.service';
import { NgxPaginationModule } from 'ngx-pagination/public-api';

@Component({
  selector: 'app-empleados',
  templateUrl: './empleados.component.html',
})
export class EmpleadosComponent {
  paginaActual = 1;
  cantidadPorPagina = 10;
    get personasPaginadas() {
      const indiceInicial = (this.paginaActual - 1) * this.cantidadPorPagina;
      const indiceFinal = indiceInicial + this.cantidadPorPagina;
      return this.empleados.slice(indiceInicial, indiceFinal);
    }
    get cantidadPaginas() {
      return Math.ceil(this.empleados.length / this.cantidadPorPagina);
    }
empleados: Empleados [] = [];
constructor(private empleadoService: EmpleadosService){}
ngOnInit() {
      this.empleadoService.getEmpleados().subscribe(
        empleados => this.empleados = empleados
      );
  }
  delete(empleado: Empleados) : void{
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })
    
    swalWithBootstrapButtons.fire({
      title: 'Estas seguro?',
      text: `¿Estas seguro de eliminar al cliente ${empleado.nombres} ${empleado.apellidos}`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Sí, eliminar!',
      cancelButtonText: 'No, cancelar!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.empleadoService.delete(empleado.id).subscribe(
          response =>{
            this.empleados =  this.empleados.filter(emp => emp !== empleado)
            swalWithBootstrapButtons.fire(
              'Empleado eliminado!',
              'Empleado eliminado con éxito',
              'success'
            )
          }
        )

      } 
    })
  }
}
