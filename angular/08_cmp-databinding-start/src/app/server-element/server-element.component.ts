import {
  Component,
  Input,
  OnInit,
  ViewEncapsulation,
  OnChanges,
  SimpleChanges,
  DoCheck,
  ViewChild,
  ElementRef,
  AfterViewInit,
  ContentChild,
  AfterContentInit,
} from '@angular/core';

@Component({
  selector: 'app-server-element',
  templateUrl: './server-element.component.html',
  styleUrls: ['./server-element.component.css'],
  encapsulation: ViewEncapsulation.Emulated //Default, no need to add
})
export class ServerElementComponent implements OnInit, OnChanges, DoCheck, AfterViewInit, AfterContentInit {
  @Input('srvElement') element: { type: string, name: string, content: string };
  @Input() name: string;
  @ViewChild('panelHeading', { static: false }) header: ElementRef;
  @ContentChild('contentParagraph', {static: false}) contentParagraph: ElementRef;

  constructor() {
    console.log('Constructor called');
  }
  ngAfterContentInit(): void {
    console.log('After content init');
    console.log('Text Paragraph Content: ' + this.contentParagraph.nativeElement.textContent);
  }
  ngAfterViewInit(): void {
    console.log('After View Init');
    console.log('Header Text: ' + this.header.nativeElement.textContent);
  }

  ngDoCheck(): void {
    console.log('Do Check called');
  }

  ngOnInit(): void {
    console.log('On Init called');
    //Does not work, still not available: console.log('Header Text: ' + this.header.nativeElement.textContent);
    //console.log('Content paragraph still not available' + this.contentParagraph.nativeElement.textContent);
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log('On Changes called');
    console.log(changes);
  }

}
