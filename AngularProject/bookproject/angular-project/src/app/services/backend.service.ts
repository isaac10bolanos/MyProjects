import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../models/book';

import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  url: string = environment.backendURL;

  constructor(private http: HttpClient) { }


  getAllBooks(): Observable<HttpResponse<any>> {
    return this.http.get<any>(this.url + 'book',
                              { observe: 'response' });
    // takes two params: the URL of the endpoint
    //                   what portion of the response we want to observe
  }

    // adding an artist
    addNewBook(book: Book): Observable<HttpResponse<any>> {
      // three args = URL, body, options
      return this.http.post<any>(this.url + 'book', book, { observe: 'response' });
    }
}
