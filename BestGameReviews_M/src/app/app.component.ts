import { Component } from '@angular/core';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'BestGameReviews';

  otherTheme: boolean = false;
  changeTheme(){
    console.log('je veux changer de thème')
    this.otherTheme = !this.otherTheme;


  }



}
