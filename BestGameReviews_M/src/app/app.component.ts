import { Component, HostBinding, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'BestGameReviews';

  lightTheme: boolean = false;
  changeTheme(){
    console.log('je veux changer de thème')
    this.lightTheme = !this.lightTheme;
  }

  // @HostBinding('class') className = '';

  // toggleControl = new FormControl(false);
  toggleControl(){
    this.lightTheme = !this.lightTheme;
  }

  // ngOnInit(): void {
  //   this.toggleControl.valueChanges.subscribe((darkMode) => {
  //     const darkClassName = 'darkMode';
  //     this.className = darkMode ? darkClassName : '';

  //   });
  // }

}
