import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { ExampleRoutingModule } from './example-routing.module';
import { ExampleComponent } from './example/example.component';

@NgModule({
  declarations: [
    ExampleComponent
  ],
  imports: [
    CommonModule,
    ExampleRoutingModule,
    AppMaterialModule,
    SharedModule
  ]
})
export class ExampleModule { }
