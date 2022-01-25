import { Component, Input, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { BehaviorSubject, Subscription } from 'rxjs';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {

  theme: string = "";
  subscription = new Subscription;

  constructor(private data: DataService) { }
  //constructor(){};

  ngOnInit(): void {
    // this.subscription = this.data.currentTheme.subscribe(theme => this.theme = theme)
    // this._theme = this.data.theme
  }

  ngOnDestroy(){
    if (this.subscription != null){
      this.subscription.unsubscribe();
    }
  }

}
