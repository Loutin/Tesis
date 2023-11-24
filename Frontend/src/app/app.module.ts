import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ServiciosComponent } from './servicios/servicios.component';
import { NavComponent } from './nav/nav.component';
import { FooterComponent } from './footer/footer.component';
import { NosotrosComponent } from './nosotros/nosotros.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { BackPageComponent } from './back-page/back-page.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { CategoriasComponent } from './categorias/categorias.component';
import { ServiciosRoutingModule } from './servicios/servicios-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    ServiciosComponent,
    NavComponent,
    FooterComponent,
    NosotrosComponent,
    LoginComponent,
    RegisterComponent,
    BackPageComponent,
    HomeComponent,
    CategoriasComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ServiciosRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
