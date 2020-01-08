import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UserInfo, AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-quiz-nav',
  templateUrl: './quiz-nav.component.html',
  styleUrls: ['./quiz-nav.component.scss']
})
export class QuizNavComponent implements OnInit {

  currentUser$: Observable<UserInfo> = this.authService.getCurrentUser();

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

}
