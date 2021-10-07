import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {IWord} from "../iword";
import {DictionaryServiceService} from "../DictionaryService/dictionary-service.service";

@Component({
  selector: 'app-dictionay-page-component',
  templateUrl: './dictionay-page-component.component.html',
  styleUrls: ['./dictionay-page-component.component.css']
})
export class DictionayPageComponentComponent implements OnInit {
  dictionaryList : IWord[];
  searchTest : IWord;
  constructor(private dictionary : DictionaryServiceService, private router : Router) {
    this.dictionaryList = this.dictionary.findAll();
  }

  ngOnInit(): void {
  }

  search (word : string){
    for (let items of this.dictionaryList){
      if (word == items.word){
        return items
      }
    }
  }

  showDetail(item: any) {
    return this.searchTest = this.search(item);
  }

  // movePageCreateStudent() {
  //   this.router.navigateByUrl("/student/create")
  // }
}
