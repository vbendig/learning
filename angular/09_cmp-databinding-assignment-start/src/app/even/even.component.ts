import { Component, Input, OnInit } from '@angular/core';
import { OddEvenEnum, OddEvenEvent } from '../model/odd.even.event.model';

@Component({
  selector: 'app-even',
  templateUrl: './even.component.html',
  styleUrls: ['./even.component.css']
})
export class EvenComponent implements OnInit {
  @Input() event: OddEvenEvent;

  constructor() { }

  ngOnInit(): void {
  }

  isComponentEnabled(): boolean{
    return this.event.id % 2 == 0;
  }

}
