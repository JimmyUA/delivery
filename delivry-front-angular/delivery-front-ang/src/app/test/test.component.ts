import {Component, Input, OnInit} from '@angular/core';


import {TestService} from './test.service';
import {Client} from '../client';
import {Observable} from 'rxjs/index';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  @Input() client: Client;

  constructor(private testService: TestService) {
  }


  ngOnInit() {
    this.getHero();
  }
  getHero(): void {
    const id = 1;
    this.testService.getClientById(id)
      .subscribe(client => this.client = client);
  }
}
