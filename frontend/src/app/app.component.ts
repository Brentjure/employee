import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { EmployeesComponent } from "./employees/employees.component";
import { NavbarComponent } from "./components/navbar/navbar.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,  NavbarComponent],
  template: `
    <app-navbar/>
    <router-outlet/>
  `,
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
 