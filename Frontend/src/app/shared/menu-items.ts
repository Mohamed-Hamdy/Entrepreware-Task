import { Injectable } from "@angular/core";


export interface Menu{
    state:string;
    name:string;
    type:string;
    icon:string;
    role:string;
}

const MENUITEMS = [
    {state:'category' , name:'Dashboard', type:'link', icon:'dashboard', role:''},
    //{state:'category' , name:'Manage Quizzes', type:'link', icon:'category', role:'admin'},
    {state:'Schedule' , name:'Schedule', type:'link', icon:'schedule', role:''},
    {state:'Courses' , name:'Courses', type:'link', icon:'inventory_2', role:''},
    {state:'Gradebook' , name:'Gradebook', type:'link', icon:'grade', role:''},
    {state:'Performance' , name:'Performance', type:'link', icon:'backup_table', role:''},
    {state:'Announcement' , name:'Announcement', type:'link', icon:'people', role:''},
    //{state:'user' , name:'Manage User', type:'link', icon:'people', role:'admin'},

]
@Injectable()
export class MenuItems{
    getMenuitem():Menu[]{
        return MENUITEMS;
    }
}