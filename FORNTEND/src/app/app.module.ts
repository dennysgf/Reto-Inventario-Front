import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { RouterModule, Routes } from '@angular/router';
import { FooterComponent } from './footer/footer.component';
import { EmpleadosComponent } from './empleados/empleados.component';
import {HttpClientModule} from '@angular/common/http';
import { EmpleadosService } from './empleados/empleados.service';
import { FormComponent } from './empleados/form.component';
import { FormsModule } from '@angular/forms';
import { EditComponent } from './empleados/edit.component';
import { NgxPaginationModule } from 'ngx-pagination';

const routes: Routes =[//asignando rutas
  {path: '', redirectTo: '/empleados', pathMatch: 'full'},
  {path: 'empleados', component: EmpleadosComponent},
  {path: 'empleados/form', component: FormComponent},
  {path: 'empleados/edit/:id', component: EditComponent},
]


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    EmpleadosComponent,
    FormComponent,
    EditComponent,

  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),//importamos routes
    HttpClientModule,
    FormsModule,
    NgxPaginationModule
    
  ],
  providers: [EmpleadosService],
  bootstrap: [AppComponent]
})
export class AppModule { }
