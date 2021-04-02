import { Component } from "@angular/core";

@Component({
    selector: 'alert',
    templateUrl: './alert.component.html',
    styleUrls: ['./alert.component.css'],
})
export class AlertComponent{
    alertMessage: string;

    constructor() { 
        this.alertMessage = 'An alert has been risen';
    }

}