import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from '../material.module';
import { JeuxRoutingModule } from './jeux-routing.module';
import { ListeJeuxComponent } from './liste-jeux/liste-jeux.component';
import { AjouterJeuxComponent } from './ajouter-jeux/ajouter-jeux.component';

@NgModule({
  declarations: [
    ListeJeuxComponent,
    AjouterJeuxComponent
  ],
  imports: [
    CommonModule,
    JeuxRoutingModule,
    MaterialModule
  ]
})
export class JeuxModule { }
