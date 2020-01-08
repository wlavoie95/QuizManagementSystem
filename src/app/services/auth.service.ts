import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable()
export class AuthService {

  private currentUser$: BehaviorSubject<UserInfo> = new BehaviorSubject<UserInfo>(undefined);

  setCurrentUser(userInfo: UserInfo): void {
    this.currentUser$.next(userInfo);
  }

  getCurrentUser(): Observable<UserInfo> {
    return this.currentUser$.asObservable();
  }

  logout() {
    this.currentUser$.next(undefined);
  }

}

export interface UserInfo {
  userId: number;
  username: string;
  authority: string;
}