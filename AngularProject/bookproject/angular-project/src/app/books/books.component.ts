import { Component } from '@angular/core';
import { BackendService } from '../services/backend.service';
import { Book } from '../models/book';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent {

  localBooks: any = [];

  chosenBookId: number = 0;
  formTitle: string = '';
  formAuthor: string = '';
  formGenre: string = '';
  formPublisher: string = '';
  formBookCount: string = '';

  canDelete: boolean = false;


  constructor(private backendService: BackendService) {

    this.getAllBooks();
    
    
  }

  getAllBooks(): void {
    this.localBooks = [];
    this.backendService.getAllBooks().subscribe(data => {
      // to see what we're getting back
      // data.body contains the array of items we're looking for
      console.log(data.body);

      // enhanced for loop to access each item
      // for each iteration, we create a new Album with those props
      // we also need to create artist objects
      for (let book of data.body) {
        this.localBooks.push(new Book(book.bookIdId,
                                        book.title,
                                        book.author,
                                        book.genre,
                                        book.publisher,
                                        book.bookCount));
      }

      // to see what we're actually storing in our local array
      console.log(this.localBooks);

    });
  }

  addNewBook(): void {
    this.backendService.addNewBook(new Book(0, this.formTitle, this.formAuthor, this.formGenre, this.formPublisher, Number(this.formBookCount)))
    .subscribe(() => this.getAllBooks());
    this.formTitle = '';
    this.formAuthor = '';
    this.formGenre = '';
    this.formPublisher = '';
    this.formBookCount = '';
  }

}
