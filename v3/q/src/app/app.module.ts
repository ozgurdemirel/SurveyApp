import {BrowserModule} from '@angular/platform-browser';
import {NgModule , CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {NavbarComponent} from './components/navbar/navbar.component';
import {SurveyComponent} from './components/survey/survey.component';
import {IntroComponent} from './components/intro/intro.component'
import {routing} from './app.routing';
import {InputSwitchModule} from 'primeng/primeng';
import {GrowlModule} from 'primeng/primeng';

@NgModule({
  declarations: [
    AppComponent, NavbarComponent, SurveyComponent,
    IntroComponent
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing,
    InputSwitchModule,
    GrowlModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
