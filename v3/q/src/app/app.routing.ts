import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {IntroComponent} from "./components/intro/intro.component";
import {SurveyComponent} from "./components/survey/survey.component";



const appRoutes: Routes = [
  {
    path:'',
    component:IntroComponent
  },
  {
    path:'createSurvey',
    component:SurveyComponent
  }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
