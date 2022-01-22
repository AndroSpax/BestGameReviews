import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// import { avisModuleRoutes } from './avis/avis.module';
// import { ListeAvisComponent } from './avis/liste-avis/liste-avis.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent},
  // { path:'liste-avis', children: avisModuleRoutes},
  { path:'avis', loadChildren: () => import('./avis/avis.module').then((m)=> m.AvisModule)},
  { path: '**', component:PageNotFoundComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
