import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-page-size',
  templateUrl: './page-size.component.html',
  styleUrls: ['./page-size.component.css']
})
export class PageSizeComponent implements OnInit {

  @Input() sizeOptions!:number[];
  @Input() pageNum!: number;
  @Input() pageSize!: number;
  @Output() pageSizeChange = new EventEmitter();
  @Output() public refreshEmitter = new EventEmitter();

  constructor() {}

  ngOnInit() {}

  changePageSize(size: string) {
    this.pageSize = parseInt(size);
    this.pageSizeChange.emit(size);
  }

  refresh() {
    this.refreshEmitter.emit();
  }

}