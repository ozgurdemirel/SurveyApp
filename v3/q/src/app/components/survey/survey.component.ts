import {Component, OnInit} from '@angular/core';
import {Survey} from "../../domain/Survey";
import {FormBuilder} from "@angular/forms";

@Component({
  moduleId:module.id,
  selector: 'survey',
  templateUrl: 'survey.component.html'
})
export class SurveyComponent implements OnInit{

  private survey:Survey;


  constructor(){}

  ngOnInit(){
    this.survey = new Survey();
  }

  addBox(){
    this.survey.choices.push('');
  }

  trackByIndex(index: number, obj: any): any {
    return index;
  }

  removeFromList(i){
    this.survey.choices.splice(i,1);
  }

  save(){
    console.log('im saving something');
  }

}
