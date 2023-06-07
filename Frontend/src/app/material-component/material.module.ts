import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { CdkTableModule } from '@angular/cdk/table';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FlexLayoutModule } from '@angular/flex-layout';

import { MaterialRoutes } from './material.routing';
import { MaterialModule } from '../shared/material-module';
import { ConfirmationComponent } from './dialog/view-bill-products/confirmation/confirmation.component';
import { ChangePasswordComponent } from './dialog/view-bill-products/change-password/change-password.component';
import { ManageQuizComponent } from './manage-quiz/manage-quiz.component';
import { QuizComponent } from './dialog/view-bill-products/quiz/quiz.component';
import { ManageProductComponent } from './manage-product/manage-product.component';
import { ProductComponent } from './dialog/view-bill-products/product/product.component';
import { ManageUserComponent } from './manage-user/manage-user.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(MaterialRoutes),
    MaterialModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    CdkTableModule
  ],
  providers: [],
  declarations: [
    ConfirmationComponent,
    ChangePasswordComponent,
    ManageQuizComponent,
    QuizComponent,
    ManageProductComponent,
    ProductComponent,
    ManageUserComponent
  ]
})
export class MaterialComponentsModule {}
