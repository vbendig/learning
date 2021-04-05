import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-one-event',
  templateUrl: './one-event.component.html',
  styleUrls: ['./one-event.component.css']
})
export class OneEventComponent implements OnInit {
  @Input() myEvent: OneEvent;

  constructor() { 
  }

  ngOnInit(): void {
  }

  getBackgroundColor(id: number): string {
    return (id >= 5) ? "blue" : "white";
  }
}

export interface OneEvent{
  id: number;
  time: string;
  action: string;
}
