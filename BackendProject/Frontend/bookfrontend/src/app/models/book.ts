// generate a model using -- ng g class <className>

// this is not a component but rather a data model
// for things coming back from/going to our database

export class Book {

    bookId: number = 0;
    title: string = '';
    author: string = '';
    genre: string = '';
    publisher: string = '';
    published: number = 0;
    imageUrl: string = '';

    constructor(bookId: number,
                title: string,
                author: string,
                genre: string,
                publisher: string,
                published: number,
                imageUrl: string) {
    this.bookId = bookId;
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.publisher = publisher;
    this.published = published;
    this.imageUrl = imageUrl;
}


}
