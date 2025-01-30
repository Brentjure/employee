import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '',
        pathMatch: 'full',
        loadComponent() {
            return import('./employees/employees.component').then((m)=> m.EmployeesComponent)
        },
    },
    {
        path: 'add-employee',
        loadComponent() {
            return import('./add-employee/add-employee.component').then((m)=> m.AddEmployeeComponent)
        }
    }

];
