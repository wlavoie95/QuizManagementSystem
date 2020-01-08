import { Component, OnInit } from '@angular/core';
import { QuizForm, QuizService } from 'src/app/services/quiz.service';

@Component({
  selector: 'app-quiz-container',
  templateUrl: './quiz-container.component.html',
  styleUrls: ['./quiz-container.component.scss']
})
export class QuizContainerComponent implements OnInit {

  constructor(private quizService: QuizService) { }

  ngOnInit() {
  }

  tryCreateQuiz(form: QuizForm){
    console.log("Reached quiz container")
    this.quizService.attemptCreateQuiz(form);
  }

}
