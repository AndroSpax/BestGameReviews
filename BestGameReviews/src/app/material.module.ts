import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@Angular/material/button';
import { MatToolbarModule } from '@Angular/material/toolbar'

const modules = [
  MatButtonModule,
  MatToolbarModule,

];

@NgModule({
  declarations:[],
  imports:[
    CommonModule
  ],
  exports: modules,
})
export class MaterialModule { }
