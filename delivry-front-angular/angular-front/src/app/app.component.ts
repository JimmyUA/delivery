import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RequestOptions} from "@angular/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Zakupayko';

  constructor(private http: HttpClient){
  }

  ngOnInit(): void {
    const options = {headers: {'Content-Type': 'application/json'}};
    this.http.post('http://localhost:8090/add',
      '{"id": null, "name": "Timur"}',
      options)
      .subscribe(data => {
      console.log(data);
    });

    this.http.get('http://localhost:8090/all').subscribe(data => {
      console.log(data);
    });
  }
}
