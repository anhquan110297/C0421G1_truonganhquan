import { Injectable } from '@angular/core';
import {IWord} from "../iword";

@Injectable({
  providedIn: 'root'
})
export class DictionaryServiceService {
  dictionary : IWord [] = [{word : "table", mean : "cái bàn"},
    {word : "pen", mean : "cây bút"},
    {word : "note book", mean : "quyển vở"},
    {word : "telephone", mean : "điện thoại"},
    {word : "laptop", mean : "máy tính laptop"},
    {word : "jacket", mean : "áo khoác"},];
  constructor() {
  }


  findByWord(word: String){
    for (let items of this.dictionary) {
      if (items.word == word) {
        return items;
      }
    }
    return null;
  }

  findAll(){
    return this.dictionary;
  }
}
