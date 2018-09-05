import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs/index';
import {Client} from '../client';
import { MessageService } from '../message.service';
import {catchError, tap} from 'rxjs/internal/operators';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  private clientsUrl = 'http://localhost:8060/clients';

  constructor(private http: HttpClient,
              private messageService: MessageService) {
  }

  private log(message: string) {
    this.messageService.add(`TestService: ${message}`);
  }

  getClientById(id: number): Observable<Client> {
    const url = `${this.clientsUrl}/${id}`;
    this.log('url: ' + url);
    const client = this.http.get<Client>(url);
    this.log('fetched observable: ' + client);
    return client;
  }
}
