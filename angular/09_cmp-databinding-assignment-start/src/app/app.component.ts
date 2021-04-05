import { Component } from '@angular/core';
import { OddEvenEvent, OddEvenEnum } from './model/odd.even.event.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  eventList: OddEvenEvent[] = [];
  public oddEvenEnum: typeof OddEvenEnum = OddEvenEnum;
  addEvenOrOdd(event: OddEvenEvent){
    this.eventList.push(event);
  }

}
