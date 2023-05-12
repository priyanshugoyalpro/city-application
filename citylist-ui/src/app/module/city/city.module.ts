import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {  CityListComponent } from './city-list/city-list.component';
import { CityComponent } from './city.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { PageNumberComponent } from 'src/app/components/core/page-number/page-number.component';
import { PageSizeComponent } from 'src/app/components/core/page-size/page-size.component';
import { SearchBarComponent } from 'src/app/components/core/search-bar/search-bar.component';

const routes : Routes = [
  {
    path:'',
    component: CityComponent
  }
]


@NgModule({
  declarations: [CityComponent, CityListComponent, SearchBarComponent, PageSizeComponent, PageNumberComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes),
  ]
})
export class CityModule { }
