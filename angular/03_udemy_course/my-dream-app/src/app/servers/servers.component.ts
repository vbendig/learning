import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {
  allowNewServer: boolean = false;
  serverCreatedStatus = 'No server has been created';
  serverName: string = '';
  serverCreated: boolean = false;
  servers = ['TestServer', 'TestServer 2'];

  constructor() { 
    setTimeout(() => {
      this.allowNewServer = true;
    }, 2000) 
  }

  ngOnInit(): void {
  }

  onServerCreate(){
    this.serverCreatedStatus = 'A new server has been created.  Name is: ' + this.serverName;
    this.serverCreated = true;
    this.servers.push(this.serverName);
  }

  onUpdateServerName(event: Event) {
    this.serverName = (<HTMLInputElement>event.target).value;
    this.allowNewServer = !(this.serverName === '');
  }
}
