import { Component, OnChanges } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnChanges{
  serverElements = [
    {type: 'server', name: 'Test server 1' , content: 'This server Content'},
    {type: 'blueprint', name: 'Test blueprint 1' , content: 'This blueprint Content'}];

    onServerAdded(serverData: { serverName: string, serverContent: string }) {
      this.serverElements.push({
        type: 'server',
        name: serverData.serverName,
        content: serverData.serverContent
      });
    }
  
    onBlueprintAdded(blueprintData: { serverName: string, serverContent: string }) {
      this.serverElements.push({
        type: 'blueprint',
        name: blueprintData.serverName,
        content: blueprintData.serverContent
      });
    }

    ngOnChanges(): void {
      console.log('App ngOnChanges called');
    }

    onChangeFirst(event: Event) {
      this.serverElements[0].name = 'Changed ' + this.serverElements[0].name; 
    }
}
