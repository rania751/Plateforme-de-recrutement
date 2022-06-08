import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { AppRoutingModule } from "./app-routing.module";
import {RouterModule, Routes} from '@angular/router';
import { AppComponent } from "./app.component";
import { PostulantsComponent } from "./postulants/postulants.component";
import { RecruteursComponent } from "./recruteurs/recruteurs.component";
import { RecruteurService } from "./recruteurs/recruteurs.service";
import { OffresComponent } from './offres/offres.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { LocalStorageService } from "./localStorageService";
import { AdminComponent } from './admin/admin.component';
import { OffrespComponent } from './offresp/offresp.component';


const appRoutes: Routes = [
  {
  path : 'admin' ,
  component: AdminComponent},

  {
    path : 'recruteur' ,
    component: OffresComponent},

    {
      path : 'postulant' ,
      component: OffrespComponent},

  {path: 'admin/postulants',
  component: PostulantsComponent},
  {
    path: 'admin/recruteurs',
    component: RecruteursComponent},

    {
      path: 'login',
      component: LoginComponent},
  
  //{ path: '**', component: PagenotfoundComponent }
  ];

@NgModule({
  declarations: [
    AppComponent,
    RecruteursComponent,
    PostulantsComponent,
    OffresComponent,
  
    LoginComponent,
    ForbiddenComponent,
    AdminComponent,
    OffrespComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes,{ enableTracing: true }),
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [LocalStorageService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
