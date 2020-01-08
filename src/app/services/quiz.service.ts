import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
// import { catchError } from 'rxjs/operators';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable()
export class QuizService {
quizUrl = 'api/quiz';

  getQuizzes(): Observable<QuizForm> {
    return null; //Not Yet Implemented
  }

  constructor(private http: HttpClient) { }

  attemptCreateQuiz(form: QuizForm): Observable<QuizForm> {
    console.log('attempting to send QuizForm data to server');
    return this.http.post<QuizForm>(this.quizUrl, form, httpOptions)
      // .pipe(
      //   catchError(val => of(`I caught: ${val}`);
      // )
    // .subscribe(
    //   data => {
    //     
    //     this.setCurrentQuiz(data);
    //   },
    //   err => {
    //     console.error(err.error);
    //   }
    // )
  }
}

export interface QuizForm {
  subject: string;
  description: string;
}