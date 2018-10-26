import { Component } from '@angular/core';
import { FilmeService } from './filme.service';
import { ActivatedRoute } from '@angular/router';
import { EventEmitterService } from './event-emitter.service';
import { Filme } from './model/filme.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Sugestão de Filme';
  public Title: string;
  constructor(
    private emitter: EventEmitterService
    ) { }

  ngOnInit() {
  }

  pesquisar(): void {
    console.log('emitindo evento');
    this.emitter.get('evento.carregarTabela')
                .emit(this.Title);
  }
}
