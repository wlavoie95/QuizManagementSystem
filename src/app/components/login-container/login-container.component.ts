import { Component, OnInit } from '@angular/core';
import { LoginForm, LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login-container',
  templateUrl: './login-container.component.html',
  styleUrls: ['./login-container.component.scss']
})
export class LoginContainerComponent implements OnInit {
  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }

  login(form: LoginForm) {
    this.loginService.attemptLogin(form);
  }
}
