import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Avis } from '../entity/avis';

@Injectable({
  providedIn: 'root'
})
export class HttpserviceService {

  constructor(private client:HttpClient) {}

   getAvis():Observable<Avis[]>{
    return this.client.get<Avis[]>('http://localhost:3000/avis');
  }
}
