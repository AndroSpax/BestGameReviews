import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AvisRoutingModule } from './avis-routing.module';
import { AjouterAvisComponent } from './ajouter-avis/ajouter-avis.component';
import { ListeAvisComponent } from './liste-avis/liste-avis.component';

import { MaterialModule } from '../material.module';
import { FlexLayoutModule } from '@angular/flex-layout';

//example of eager loading
// export const avisModuleRoutes: Routes = [{ path:'', component:ListeAvisComponent}];

@NgModule({
  declarations: [
    ListeAvisComponent,
    AjouterAvisComponent,
  ],
  imports: [
    CommonModule,
    AvisRoutingModule,
    MaterialModule,
    FlexLayoutModule
  ]
})
export class AvisModule { }
