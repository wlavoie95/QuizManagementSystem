import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { QuizNavComponent } from './components/quiz-nav/quiz-nav.component';
import { QuestionComponent } from './components/question/question.component';
import { LoginFormComponent } from './components/login-form/login-form.component';
import { ErrorComponent } from './components/error/error.component';
import { QuizFormComponent } from './components/quiz-form/quiz-form.component';
import { QuestionFormComponent } from './components/question-form/question-form.component';
import { LoginContainerComponent } from './components/login-container/login-container.component';
import { LoginService } from './services/login.service';
import { FormsModule } from '@angular/forms';
import { AuthService } from './services/auth.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { QuizContainerComponent } from './components/quiz-container/quiz-container.component';
import { QuizService } from './services/quiz.service';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    QuizNavComponent,
    QuestionComponent,
    LoginFormComponent,
    ErrorComponent,
    QuizFormComponent,
    QuestionFormComponent,
    LoginContainerComponent,
    QuizContainerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    CommonModule
  ],
  providers: [
    LoginService,
    AuthService,
    QuizService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
