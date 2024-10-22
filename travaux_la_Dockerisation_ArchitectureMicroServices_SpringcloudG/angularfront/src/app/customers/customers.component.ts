import { CommonModule, NgFor, NgIf } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customers',
  standalone: true,
  imports: [NgIf,NgFor,HttpClientModule, CommonModule],
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit{

  customers : any;
  constructor(private http: HttpClient) {
  }
  ngOnInit() {
    this.http.get("http://localhost:8888/CLIENTSERVICE/customers")
      .subscribe({
        next : data => {
          this.customers = data;
        },
        error : err => {
          console.log(err);
        }
      })
  }

}

