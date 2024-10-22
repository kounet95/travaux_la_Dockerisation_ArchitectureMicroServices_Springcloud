import { CommonModule, NgFor, NgIf } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customers',
  standalone: true,
  imports: [NgIf,NgFor,HttpClientModule, CommonModule],
  templateUrl: './accounts.component.html',
  styleUrl: './accounts.component.css'
})
export class AccountsComponent implements OnInit{

  accounts : any;
  constructor(private http: HttpClient) {
  }
  ngOnInit() {
    this.http.get("http://localhost:8888/COMPTESERVICE/accounts")
      .subscribe({
        next : data => {
          this.accounts = data;
        },
        error : err => {
          console.log(err);
        }
      })
  }

}


