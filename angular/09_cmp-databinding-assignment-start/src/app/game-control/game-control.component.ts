import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { OddEvenEnum, OddEvenEvent } from '../model/odd.even.event.model';

@Component({
  selector: 'app-game-control',
  templateUrl: './game-control.component.html',
  styleUrls: ['./game-control.component.css']
})
export class GameControlComponent implements OnInit {

  @Output() gameEvent = new EventEmitter<OddEvenEvent>();
  toggleButtonsStartEnd: boolean = false;
  interval: ReturnType<typeof setTimeout>;
  eventId: number = 1;

  constructor() { }

  ngOnInit(): void {
  }

  onGameStart(){
    console.log('Game Started');
    this.startEmitting();
    this.toggleButtons();
  }

  startEmitting(){
    this.interval = setInterval(() => {
      let type = (this.eventId % 2 == 0) ? OddEvenEnum.EVEN : OddEvenEnum.ODD;
      console.log('Emitting Event with id : ' + this.eventId + ' - ' + type);
      this.gameEvent.emit({id: this.eventId, type: type});
      this.eventId += 1;
    }, 1000);
  }

  stopEmitting(){
    clearInterval(this.interval);
  }

  onGameEnd() {
    console.log('Game Ended');
    this.stopEmitting();
    this.toggleButtons();
  }

  private toggleButtons(): void{
    this.toggleButtonsStartEnd = !this.toggleButtonsStartEnd;
  }

}
