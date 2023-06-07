import { Component, Inject, EventEmitter ,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { DashboardContentService } from 'src/app/services/dashboardcontent.service';
import { SnackbarService } from 'src/app/snackbar.service';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { GlobalConstants } from 'src/app/shared/global-constants';

@Component({
  selector: 'app-dashboardcontent',
  templateUrl: './dashboardcontent.component.html',
  styleUrls: ['./dashboardcontent.component.scss']
})
export class DashboardContentComponent implements OnInit {

  onAddCategory = new EventEmitter();
  onEditCatefory = new EventEmitter();
  categoryForm:any = FormGroup;
  dialogAction:any = "Add";
  action:any = "Add";

responseMessage:any;

  constructor(@Inject(MAT_DIALOG_DATA) public dialogData:any,
  private formBulider:FormBuilder,
  protected DashboardContentService:DashboardContentService,
  public dialogRef: MatDialogRef<DashboardContentComponent>,
  private snackbarService:SnackbarService
  ) { }

  ngOnInit(): void {
    this.categoryForm = this.formBulider.group({
      name:[null,[Validators.required]]
    });
    if(this.dialogData.action === 'Edit'){
      this.dialogAction = "Edit";
      this.action = "Update";
      this.categoryForm.patchValue(this.dialogData.data);
    }
  }

  handleSubmit(){
    if(this.dialogAction === "Edit"){
      this.edit();
    }else{
      this.add();
    }
  }
  add() {
    var formData = this.categoryForm.value;
    var data = {
      name: formData.name
    }
    this.DashboardContentService.add(data).subscribe((response:any)=>{
      this.dialogRef.close();
      this.onAddCategory.emit();
      this.responseMessage = response.message;
      alert("Successfully Add DashboardContent");
      this.snackbarService.openSnackBar(this.responseMessage , "success");
    },(error)=>{
      this.dialogRef.close();
      console.error(error);
      if(error.error?.message){
        this.responseMessage = error.error?.message;
      }else{
        this.responseMessage = GlobalConstants.genericError;
      }
      alert(this.responseMessage +" " +GlobalConstants.error);
      this.snackbarService.openSnackBar(this.responseMessage , GlobalConstants.error);
    });
  }
  edit() {
    var formData = this.categoryForm.value;
    var data = {
      id: this.dialogData.data.id,
      name: formData.name
    }
    this.DashboardContentService.update(data).subscribe((response:any)=>{
      this.dialogRef.close();
      this.onEditCatefory.emit();
      this.responseMessage = response.message;
      alert("Successfully Update DashboardContent");
      this.snackbarService.openSnackBar(this.responseMessage , "success");
    },(error)=>{
      this.dialogRef.close();
      console.error(error);
      if(error.error?.message){
        this.responseMessage = error.error?.message;
      }else{
        this.responseMessage = GlobalConstants.genericError;
      }
      alert(this.responseMessage +" " +GlobalConstants.error);
      this.snackbarService.openSnackBar(this.responseMessage , GlobalConstants.error);
    });  
  }
}
