import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { InscriptionComponent } from './inscription/inscription.component';
import { ConnexionComponent } from './connexion/connexion.component';

import { MaterialModule } from '../material.module';
import { FlexLayoutModule } from '@angular/flex-layout';

@NgModule({
  declarations: [
    InscriptionComponent,
    ConnexionComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    MaterialModule,
    FlexLayoutModule

  ]
})
export class UserModule { }
