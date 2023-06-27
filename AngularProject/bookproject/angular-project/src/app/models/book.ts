export class Book {

    bookId: number = 0;
    title: string = '';
    author: string = '';
    genre: string = '';
    publisher: string = '';
    bookCount: number = 0;

    constructor(bookId: number,
                title: string,
                author: string,
                genre: string,
                publisher: string,
                bookCount: number) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.bookCount = bookCount;
        }
}
