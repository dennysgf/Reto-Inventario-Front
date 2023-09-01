import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Empleados } from './empleados';
import { EmpleadosService } from './empleados.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
})
export class EditComponent {
  public empleado : Empleados = new Empleados();
  public titulo: String = "Actualización de datos";

  constructor(private empleadoService : EmpleadosService,
    private router : Router,
    private activatedRoute: ActivatedRoute){
  }
  ngOnInit(){
    this.cargarEmpleado()
  }
  cargarEmpleado():void{
    this.activatedRoute.params.subscribe(params =>{
      let id = params['id']
      if(id){
        this.empleadoService.getEmpleado(id).subscribe((empleado)=>this.empleado = empleado)
      }
    })
  }
  update():void{
    this.empleadoService.update(this.empleado).subscribe(json=>{
      this.router.navigate(['/empleados'])
      Swal.fire('Actualizado',`empleado ${json.empleado.nombres} sus datos se han actualizado`, 'success')
    })
  }

}
