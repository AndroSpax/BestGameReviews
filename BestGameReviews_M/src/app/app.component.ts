import { Component, OnInit, Output } from '@angular/core';
import { FormControl } from '@angular/forms';
import { DataService } from './data.service';
import { Subscription } from 'rxjs';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'BestGameReviews';



  otherTheme: string = "darkMode";
  subscription = new Subscription;

  constructor(private data: DataService){};

  ngOnInit(){
    this.subscription = this.data.currentTheme.subscribe(theme => this.otherTheme = theme);
  }

  ngOnDestroy(){
    if (this.subscription != null){
      this.subscription.unsubscribe();
    }
  }

  changeTheme(){
    if (this.otherTheme == "darkMode")
      this.otherTheme = "lightMode";
    else this.otherTheme = "darkMode";
    this.data.changeTheme(this.otherTheme);
  }

  // @HostBinding('class') className = '';

  //toggleControl = new FormControl(false);
  // toggleControl(){
  //   this.otherTheme = !this.otherTheme;
  // }

  // ngOnInit(): void {
  //   this.toggleControl.valueChanges.subscribe((darkMode) => {
  //     const darkClassName = 'darkMode';
  //     this.className = darkMode ? darkClassName : '';

  //   });
  // }

}
