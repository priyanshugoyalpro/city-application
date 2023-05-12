import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css'],
})
export class SearchBarComponent {
  @Input() searchKeyword: string = '';
  @Output() search = new EventEmitter();
  @Output() clear = new EventEmitter();

  startSearch(keyword: string) {
    if (keyword) {
      this.search.emit(keyword);
    }
  }

  clearSearch(){
    this.searchKeyword ='';
    debugger
    this.clear.emit();
  }


}