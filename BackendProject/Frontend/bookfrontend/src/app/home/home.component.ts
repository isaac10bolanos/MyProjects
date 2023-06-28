import { Component, OnInit } from '@angular/core';
import { BackendService } from '../services/backend.service';
import { HttpResponse } from '@angular/common/http';
import { Book } from '../models/book';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  localBooks: Book[] = [];

  constructor(private backendService: BackendService) {}

  ngOnInit(): void {
    this.getTheGreat();
  }

  getTheGreat(): void {
    this.backendService.getTheGreat().subscribe(
      (response: HttpResponse<any>) => {
        const data = response.body;
        if (Array.isArray(data)) {
          this.localBooks = data.map(
            (book: any) =>
              new Book(
                book.bookId,
                book.title,
                book.author,
                book.genre,
                book.publisher,
                book.published,
                book.imageUrl
              )
          );
        }
      },
      (error: any) => {
        console.error(error);
      }
    );
  }
}
