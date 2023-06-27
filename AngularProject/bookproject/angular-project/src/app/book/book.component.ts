import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Book } from '../models/book';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent {

  constructor(private router: Router) {}


    @Input() book: Book = new Book(0, '', '', '', '', 0);
  

}
