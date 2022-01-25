import { Component, OnInit } from '@angular/core';
import { DataService } from '../../services/data.service';
import { Subscription } from 'rxjs';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent implements OnInit {

  // initialise le thème du user
  theme: string = "";
  subscription = new Subscription;

  myForm: FormGroup;
  email: AbstractControl;


  // pour la possibilité de voir le mot de passe que l'utilisateur saisie
  hide = true;

  constructor(private data: DataService, fb: FormBuilder) {
    this.myForm = fb.group({
      'email':['', Validators.required]
    });
    this.email= this.myForm.controls['email'];

   };

  // onInit récupère le currentThème du data service
  ngOnInit(): void {
    // this.subscription = this.data.currentTheme.subscribe(theme => this.theme = theme);
  }

  ngOnDestroy(){
    if (this.subscription != null){
      this.subscription.unsubscribe();
    }
  }

  // pour la validation du formulaire de connexion
  onSubmit(value:string): void {
    console.log('you submitted value:', value);
  }

}
