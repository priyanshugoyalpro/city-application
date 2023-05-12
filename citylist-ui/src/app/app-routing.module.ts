import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { CityComponent } from './module/city/city.component';



const routes: Routes = [
  {
    path: 'cities',
    loadChildren: () => import('./module/city/city.module').then(m=> m.CityModule)
  },
  {
  path: 'admin',
  component: AdminComponent 
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
