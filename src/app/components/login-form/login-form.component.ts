import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { LoginForm } from 'src/app/services/login.service';


@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit {
@Output('userLogin') formSubmitEmitter: EventEmitter<LoginForm> = new EventEmitter<LoginForm>();
 
  username: string;
  password: string;

  constructor() { }

  ngOnInit() {
  }

  attemptLogin() {
    console.log("attempting to log in");
    this.formSubmitEmitter.emit({ username: this.username, password: this.password });
  }
}
