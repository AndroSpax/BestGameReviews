import { Component, OnInit } from '@angular/core';
import { DataService } from '../../services/data.service';
import { Subscription } from 'rxjs';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss']
})
export class InscriptionComponent implements OnInit {


  // initialise le thème du user
  theme: string = "";
  subscription = new Subscription;

  myForm: FormGroup;
  email: AbstractControl;
  tomorrow = new Date();


  // pour la possibilité de voir le mot de passe que l'utilisateur saisie
  hide = true;



  constructor(private data: DataService, fb: FormBuilder) {
    this.myForm = fb.group({
      'email':['', Validators.required],
 });
    this.email= this.myForm.controls['email'];
    this.tomorrow.setDate(this.tomorrow.getDate());
   };

  // onInit récupère le currentThème du data service
  ngOnInit(): void {
    this.subscription = this.data.currentTheme.subscribe(theme => this.theme = theme)
  }

  ngOnDestroy(){
    if (this.subscription != null){
      this.subscription.unsubscribe();
    }
  }

  // pour la validation du formulaire de connexion
  onSubmit(): void {
    const { username, email, password } = this.form;

    this.authService.register(username, email, password).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

}
