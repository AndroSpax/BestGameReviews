import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule} from '@Angular/material/button';

const MaterialComponents = [
  MatButtonModule,
];

@NgModule({
  declarations: [],
  exports: MaterialComponents,
  imports: [
    CommonModule
  ]
})
export class MaterialModule { }
