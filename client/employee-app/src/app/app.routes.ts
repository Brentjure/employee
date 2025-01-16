import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeFormComponent } from './employee-form/employee-form.component';
//import { EmployeeListComponent } from './employee-list/employee-list.component';

const routes: Routes = [
  { path: 'add-employee', component: EmployeeFormComponent },
  { path: 'employees', component: EmployeeListComponent },
  { path: '', redirectTo: '/employees', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
