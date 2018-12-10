import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {UiService} from './services/ui/ui.service';
import { ClientsComponent } from './clients/clients.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [UiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
