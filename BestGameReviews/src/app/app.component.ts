import { Component, ViewChild } from '@angular/core';
import { MatIconRegistry } from '@angular/material/icon';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'BestGameReviews';
  constructor(iconRegistry: MatIconRegistry){

  }
}

