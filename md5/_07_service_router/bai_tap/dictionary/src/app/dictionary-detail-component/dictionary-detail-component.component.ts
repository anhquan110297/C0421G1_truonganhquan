import { Component, OnInit } from '@angular/core';
import {IWord} from "../iword";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {DictionaryServiceService} from "../DictionaryService/dictionary-service.service";

@Component({
  selector: 'app-dictionary-detail-component',
  templateUrl: './dictionary-detail-component.component.html',
  styleUrls: ['./dictionary-detail-component.component.css']
})
export class DictionaryDetailComponentComponent implements OnInit {
  dictionaryDetail : IWord;
  // mean : string;
  constructor(private activatedRoute : ActivatedRoute, private service : DictionaryServiceService) {
    activatedRoute.paramMap.subscribe((paramMap : ParamMap) => {
      const word = paramMap.get("word"); //word phải trùng với từ khóa khai báo bên app-routing
      console.log(word);
      this.dictionaryDetail = service.findByWord(name);
      console.log(this.dictionaryDetail)
    })
  }

  ngOnInit(): void {
  }

}
