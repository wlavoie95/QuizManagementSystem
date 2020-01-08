import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginContainerComponent } from './components/login-container/login-container.component';
import { ErrorComponent } from './components/error/error.component';
import { QuizNavComponent } from './components/quiz-nav/quiz-nav.component';
import { QuizFormComponent } from './components/quiz-form/quiz-form.component';
import { QuizContainerComponent } from './components/quiz-container/quiz-container.component';


const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginContainerComponent
  },
  {
    path: 'quiz',
    component: QuizContainerComponent
  },
  {
    path: 'quiz/create',
    component: QuizFormComponent
  },
  {
    path: '**',
    component: ErrorComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
