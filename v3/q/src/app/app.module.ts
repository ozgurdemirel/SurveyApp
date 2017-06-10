import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {NavbarComponent} from './components/navbar/navbar.component';
import {SurveyComponent} from './components/survey/survey.component';
import {IntroComponent} from './components/intro/intro.component'
import {routing} from './app.routing';


@NgModule({
  declarations: [
    AppComponent, NavbarComponent, SurveyComponent,
    IntroComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
