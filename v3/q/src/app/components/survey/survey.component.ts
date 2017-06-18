import {Component, OnInit} from "@angular/core";
import {Survey} from "../../domain/Survey";
import {Message} from 'primeng/primeng';


@Component({
  moduleId: module.id,
  selector: 'survey',
  templateUrl: 'survey.component.html'
})
export class SurveyComponent implements OnInit {

  survey: Survey;
  msgs: Message[] = [];

  constructor() {
  }

  ngOnInit() {
    this.survey = new Survey();
  }

  addBox() {
    this.survey.choices.push('');
  }

  trackByIndex(index: number, obj: any): any {
    return index;
  }

  removeFromList(i) {
    this.survey.choices.splice(i, 1);
  }

  save() {
    console.log('im saving something');
    this.msgs = [];
    this.msgs.push({severity:'info', summary:'Info Message', detail:'Successfully saved...'});
  }

}
