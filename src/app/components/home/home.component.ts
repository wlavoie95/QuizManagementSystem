import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UserInfo, AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  currentUser$: Observable<UserInfo> = this.authService.getCurrentUser();

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

}
