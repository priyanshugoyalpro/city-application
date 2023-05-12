import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './components/admin/admin.component';
import { CityModule } from './module/city/city.module';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    CityModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
