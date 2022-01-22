import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { JeuxRoutingModule } from './jeux-routing.module';
import { ListeJeuxComponent } from './liste-jeux/liste-jeux.component';


@NgModule({
  declarations: [
    ListeJeuxComponent
  ],
  imports: [
    CommonModule,
    JeuxRoutingModule
  ]
})
export class JeuxModule { }
