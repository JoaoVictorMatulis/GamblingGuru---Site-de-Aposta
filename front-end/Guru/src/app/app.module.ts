import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatCardModule} from '@angular/material/card';
import { FooterComponent } from './components/footer/footer.component';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { RoletaComponent } from './components/roleta/roleta.component';
import { CadastroComponent } from './components/cadastro/cadastro.component';
import { LoginComponent } from './components/login/login.component';
import { LeaderboardComponent } from './components/leaderboard/leaderboard.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './pages/home/home.component';
import { routing } from './app.routing';
import { HomeClienteComponent } from './pages/home-cliente/home-cliente.component';
import { TabelaLeaderboardComponent } from './pages/tabela-leaderboard/tabela-leaderboard.component';
import { CadastroTelaComponent } from './pages/cadastro-tela/cadastro-tela.component';
import { TelaAdminComponent } from './pages/tela-admin/tela-admin.component';
import { AdminComponent } from './components/admin/admin.component';
import { HeaderLogadoComponent } from './components/header-logado/header-logado.component';
import { TabelaLeaderboardLogadoComponent } from './pages/tabela-leaderboard-logado/tabela-leaderboard-logado.component';
import { HeaderAdminComponent } from './components/header-admin/header-admin.component';
import { HeaderLeaderboardAdminComponent } from './components/header-leaderboard-admin/header-leaderboard-admin.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    RoletaComponent,
    HeaderLogadoComponent,
    CadastroComponent,
    LoginComponent,
    LeaderboardComponent,
    HomeComponent,
    HomeClienteComponent,
    TabelaLeaderboardComponent,
    CadastroTelaComponent,
    TelaAdminComponent,
    AdminComponent,
    TabelaLeaderboardLogadoComponent,
    HeaderAdminComponent,
    HeaderLeaderboardAdminComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    HttpClientModule,
    routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
