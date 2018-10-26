import { Component, OnInit, EventEmitter } from '@angular/core';
import { FilmeService } from '../filme.service';
import { ActivatedRoute, Router } from '@angular/router';

import { Filme } from '../model/filme.model';
import { EventEmitterService } from '../event-emitter.service';

@Component({
  selector: 'app-listar-filme',
  templateUrl: './listar-filme.component.html',
  styleUrls: ['./listar-filme.component.css']
})
export class ListarFilmeComponent implements OnInit {

  
  filme : Filme;
  filmes : Array<Filme>;
  //isPesquisado: boolean;
  //preenchida somente quando uma pesquisa for efetuada
  tituloPesquisado: string;
  
  constructor(
    private service: FilmeService,
    private emitter : EventEmitterService
    ) { 
     
    }

  ngOnInit() {
    console.log('init');
    this.filme = new Filme();
    this.filmes = new Array();
    this.carregarTabela();
    this.emitter.get('evento.carregarTabela')
                .subscribe(Titulo => this.carregarTabela(Titulo));
  }

  carregarTabela(Title?: string): void {
    //this.isPesquisado = true;
    console.log('recebendo evento');
    console.log(Title);
    this.tituloPesquisado = Title;
    this.service.getFilme(Title).subscribe(filme => this.filmes = filme)
  }

  buscarMais(){
    console.log(this.tituloPesquisado)
    this.service.getMais(this.tituloPesquisado).subscribe(filme => this.filmes = filme)
  }

 
}
