import { typeWithParameters } from '@angular/compiler/src/render3/util';
import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { QuizService } from 'src/app/services/quiz.service';
import { GlobalConstants } from 'src/app/shared/global-constants';
import { SnackbarService } from 'src/app/snackbar.service';
import { QuizComponent } from '../dialog/view-bill-products/quiz/quiz.component';

@Component({
  selector: 'app-manage-quiz',
  templateUrl: './manage-quiz.component.html',
  styleUrls: ['./manage-quiz.component.scss']
})
export class ManageQuizComponent implements OnInit {

  displayedColumns: string[] = ['quiz'];
  displayedColumns2: string[] = ['Announcement' ];

  dataSource:any;
  dataSource2:any;

  responseMessage:any;

  constructor(private QuizService:QuizService,
    private dialog:MatDialog,
    private SnackbarService:SnackbarService,
    private router:Router) { }

  ngOnInit(): void {
    this.tableData();
  }
  tableData() {
    this.QuizService.getQuizzes().subscribe((response:any)=>{
      this.dataSource = new MatTableDataSource(response);
    },(error:any)=>{
      console.log(error.error?.message);
      if(error.error?.message){
        this.responseMessage = error.error?.message; 
      }else{
        this.responseMessage = GlobalConstants.genericError;
      }
      this.SnackbarService.openSnackBar(this.responseMessage, GlobalConstants.error);
    })

    this.QuizService.getAllAnnouncement().subscribe((response:any)=>{
      this.dataSource2 = new MatTableDataSource(response);
    },(error:any)=>{
      console.log(error.error?.message);
      if(error.error?.message){
        this.responseMessage = error.error?.message; 
      }else{
        this.responseMessage = GlobalConstants.genericError;
      }
      this.SnackbarService.openSnackBar(this.responseMessage, GlobalConstants.error);
    })
  }

  applyFilter(event:Event){
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
