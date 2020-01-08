import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { QuizForm } from 'src/app/services/quiz.service';

@Component({
  selector: 'app-quiz-form',
  templateUrl: './quiz-form.component.html',
  styleUrls: ['./quiz-form.component.scss']
})
export class QuizFormComponent implements OnInit {
  @Output('newQuiz') formSubmitEmitter: EventEmitter<QuizForm> = new EventEmitter<QuizForm>();

  subject: string;
  description: string;

  constructor() { }

  ngOnInit() {
  }

  createQuiz() {
    console.log("reached quiz form");
    console.log(this.subject);
    console.log(this.description);

   this.formSubmitEmitter.emit({ subject: this.subject, description: this.description });
  }
}
