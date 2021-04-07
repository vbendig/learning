import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-odd',
  templateUrl: './odd.component.html',
  styleUrls: ['./odd.component.css']
})
export class OddComponent implements OnInit {
  @Input() id: number;
  constructor() { }

  ngOnInit(): void {
  }

  isComponentEnabled(): boolean{
    return this.id % 2 != 0;
  }
}
