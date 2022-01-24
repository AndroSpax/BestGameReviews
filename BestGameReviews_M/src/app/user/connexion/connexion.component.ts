import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/data.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent implements OnInit {

  theme: string = "darkMode";
  subscription = new Subscription;

  constructor(private data: DataService) { }

  ngOnInit(): void {
    this.subscription = this.data.currentTheme.subscribe(theme => this.theme = theme)
  }

  ngOnDestroy(){
    if (this.subscription != null){
      this.subscription.unsubscribe();
    }

  }

}
