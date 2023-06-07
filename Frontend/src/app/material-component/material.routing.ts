import { Routes } from '@angular/router';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { RouteGuardService } from '../services/route-guard.service';
import { ManageQuizComponent } from './manage-quiz/manage-quiz.component';
import { ManageProductComponent } from './manage-product/manage-product.component';
import { ManageUserComponent } from './manage-user/manage-user.component';


export const MaterialRoutes: Routes = [
    
    {
        path:'category',
        component:ManageQuizComponent,
        canActivate:[RouteGuardService],
        data:{
            expectedRole: ['admin' , 'user']
        }
    },

    {
        path:'product',
        component:ManageProductComponent,
        canActivate:[RouteGuardService],
        data:{
            expectedRole: ['admin']
        }
    },

    {
        path:'user',
        component:ManageUserComponent,
        canActivate:[RouteGuardService],
        data:{
            expectedRole: ['admin']
        }
    },
];
