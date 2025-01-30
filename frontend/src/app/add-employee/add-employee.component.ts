import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-employee',
  imports: [FormsModule, HttpClientModule],
  templateUrl: './add-employee.component.html',
  styleUrl: './add-employee.component.css'
})
export class AddEmployeeComponent {
  employeeObj: any = {
    "first_name":"", 
    "last_name":"", 
    "email":"", 
    "gender":"", 
    "position": ""
       
}

  http = inject(HttpClient);

  onSubmitEmployee(){
    console.log(JSON.stringify(this.employeeObj))

    const headers = { 'Content-Type': 'application/json' };    debugger;
    try{
      this.http.post('http://localhost:8080/api/v1/post-employee-details',
        JSON.stringify(this.employeeObj),
        { headers }
      ).subscribe((res:any)=>{
        console.log(res)
        debugger;
        alert(res.message)
      })

    } catch(error){
      console.log(error);
      alert(error)

    }
    
  }



}
