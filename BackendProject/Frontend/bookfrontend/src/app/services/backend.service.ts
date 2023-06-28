// to create a service, use -- ng g service <serviceName>

// a service in Angular is any centralized functionality you need
// here, we're using it for all our backend calls
// BUT, you can also use one to hold centrally-required data

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpResponse } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Book } from '../models/book';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  url: string = environment.backendURL;
  book: string = 'book/';
  great: string = 'featured';


  // this injects the HttpClient functionality wherever we need it
  constructor(private http: HttpClient) { }

  getTheGreat(): Observable<HttpResponse<any>> {
    return this.http.get<any>(this.url + this.book + this.great,
                              { observe: 'response'});
  }
}
