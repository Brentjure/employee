import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, inject } from '@angular/core';

@Component({
  selector: 'app-employees',
  imports: [HttpClientModule],
  templateUrl: './employees.component.html',
  styleUrl: './employees.component.css'
})
export class EmployeesComponent {
  employeeList:any[]= [];

  http = inject(HttpClient);

  ngOnInit(): void {
    this.getAllEmployees();
  }

  getAllEmployees(){

    try {
      this.http.get('http://localhost:8080/api/v1/get-all-employees').subscribe((res:any)=>{
        console.log(res)
        this.employeeList = res;
        })
      
    } catch (error) {
      console.log(error)    
    }
    
  }

}
