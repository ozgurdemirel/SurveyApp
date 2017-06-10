import { Component } from '@angular/core';

@Component({
  moduleId:module.id,
  selector: 'survey',
  templateUrl: 'survey.component.html'
})
export class SurveyComponent {

  public answers:string[] = [''];

  addBox(){
    this.answers.push('');
  }

  trackByIndex(index: number, obj: any): any {
    return index;
  }

  save(){
    console.log('im saving something');
  }

}
