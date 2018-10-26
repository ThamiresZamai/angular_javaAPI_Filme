import { Component, OnInit } from '@angular/core';
import { FilmeService } from '../filme.service';
import { ActivatedRoute } from '@angular/router';
import { Filme } from '../model/filme.model';

@Component({
  selector: 'app-detalhe',
  templateUrl: './detalhe.component.html',
  styleUrls: ['./detalhe.component.css']
})
export class DetalheComponent implements OnInit {

  filme : Filme;
  imdbID: string;
  constructor(
    private service : FilmeService,
    private router : ActivatedRoute
    ) { }

  ngOnInit() {
    this.filme = new Filme();
    this.imdbID = this.router.snapshot.paramMap.get('imdbID');
    this.getDetalhe(this.imdbID);
  }

  getDetalhe(imdbID : string){
    this.service.getDetalhe(imdbID).subscribe(detalhe => this.filme = detalhe)
  }
}
