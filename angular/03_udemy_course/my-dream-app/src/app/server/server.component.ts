import { ThrowStmt } from '@angular/compiler';
import { Component } from '@angular/core';
import { ServerStatus } from './server.status.enum';
import { randomEnum } from './server.status.enum';

@Component({
  selector: 'app-server',
  templateUrl: './server.component.html',
  styleUrls: ['./server.component.css']
})

export class ServerComponent {
  serverId: number = Math.floor(Math.random() * 100 + 1);
  serverStatus: ServerStatus = randomEnum(ServerStatus);

  getServerStatus(): ServerStatus {
    return this.serverStatus;
  }
}
