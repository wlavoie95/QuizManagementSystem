import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UserInfo, AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.scss']
})
export class QuestionComponent implements OnInit {

  currentUser$: Observable<UserInfo> = this.authService.getCurrentUser();

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

}
