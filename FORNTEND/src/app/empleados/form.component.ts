import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Empleados } from './empleados';
import { EmpleadosService } from './empleados.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
})
export class FormComponent {
  
  public empleado : Empleados = new Empleados();
  public titulo: String = "formulario empleado";

  constructor(private empleadoService : EmpleadosService,
    private router : Router,
    private activatedRoute: ActivatedRoute){
    }
    ngOnInit() {
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
    public create():void{
      this.empleadoService.create(this.empleado).
      subscribe(json=>{
        this.router.navigate(['/empleados'])
        Swal.fire('Nuevo emplado', `Empleado ${json.empleado.nombres} creado con éxito`, 'success')
      })
    }
    update():void{
      this.empleadoService.update(this.empleado).subscribe(json=>{
        this.router.navigate(['/empleados'])
        Swal.fire('Actualizado',`Los datos ${json.empleado.nombres} se han actualizado`, 'success')
      })
    }
    validarInput(input : string):boolean{
      const regex = /^[a-zA-Z0-9]*$/;
      return regex.test(input);
    }
    
}
