import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  clients$: Object;

  constructor(private data: DataService) { }

  ngOnInit() {
    this.data.getClients().subscribe(
      data => this.clients$ = data
    );
  }

}
