import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { catchError, Observable, throwError } from 'rxjs';
import { Empleados } from './empleados';
import Swal from 'sweetalert2';

@Injectable()
export class EmpleadosService {
  private urlEndPoint:string = 'http://localhost:8080/api/empleados';
  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'})
  
  
  constructor(private http: HttpClient, private router : Router) { }

  /**Listar todos los empleados */
  getEmpleados():Observable <Empleados[]>{
    return this.http.get<Empleados[]>(this.urlEndPoint);
  }

  /**creando al empleado */
    create(empleado: Empleados):Observable<any>{
      return this.http.post<any>(this.urlEndPoint, empleado,{headers:this.httpHeaders}).pipe(
        catchError(e=>{
          console.error(e.error.mensaje);
          Swal.fire(e.error.mensaje, e.error.error, 'error');
          return throwError(e);
        })
      )
    }

  /**obteniendo el empleado por su id*/
    getEmpleado(id: any): Observable<Empleados>{
      return this.http.get<Empleados>(`${this.urlEndPoint}/${id}`).pipe(
        catchError(e =>{
          this.router.navigate(['/empleados']);
          console.error(e.error.mensaje);
          Swal.fire('Error al editar', e.error.mensaje, 'error');
          return throwError(e);
        })
      );
  }

  /**Actualizar datos del empleado */ 
  update(empleado:Empleados):Observable<any>{
    return this.http.put<any>(`${this.urlEndPoint}/${empleado.id}`, empleado, {headers: this.httpHeaders}).pipe(
      catchError(e =>{
        console.error(e.error.mensaje);
        Swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }
  
  //**eliminar empleado */
  delete(id: number):Observable<Empleados>{
    return this.http.delete<Empleados>(`${this.urlEndPoint}/${id}`,{headers: this.httpHeaders}).pipe(
      catchError(e =>{
        console.error(e.error.mensaje);
        Swal.fire(e.error.mensaje, e.error.error,'error');
        return throwError(e);
      })
    );
  }

}

