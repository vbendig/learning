import { Component, OnInit } from '@angular/core';
import { OneEvent } from '../one-event/one-event.component';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {
  displayParagraph: boolean = false;
  eventArray = [];
  eventId: number = 0;
  newEvent: OneEvent;

  constructor() { }

  ngOnInit(): void {
  }

  onClick() {
    let currDate: Date = new Date();
    this.displayParagraph = !this.displayParagraph;
    this.eventId += 1;
    let action = (this.displayParagraph)? 'on' : 'off' ;
    this.newEvent = {
                      id: this.eventId,
                      time: currDate.toLocaleString(),
                      action: action
                    };
    this.eventArray.push(this.newEvent);
  }
}
