import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { HomeClienteComponent } from './pages/home-cliente/home-cliente.component';
import { CadastroTelaComponent } from './pages/cadastro-tela/cadastro-tela.component';
import { TelaAdminComponent } from './pages/tela-admin/tela-admin.component';
import { TabelaLeaderboardComponent } from './pages/tabela-leaderboard/tabela-leaderboard.component';
import { HeaderLogadoComponent } from './components/header-logado/header-logado.component';
import { TabelaLeaderboardLogadoComponent } from './pages/tabela-leaderboard-logado/tabela-leaderboard-logado.component';


const APP_ROUTES: Routes = [
    {path: '', component: HomeComponent},
    {path: 'leaderboard', component: TabelaLeaderboardComponent},
    {path: 'leaderboardLogado/:email', component: TabelaLeaderboardLogadoComponent},
    {path: 'cadastro', component: CadastroTelaComponent},
    {path: 'roleta', component: HomeClienteComponent},
    {path: 'admin/:email', component: TelaAdminComponent},
    {path: 'logado/:email', component: HomeClienteComponent},
    {path: 'headerLogado/:email', component: HeaderLogadoComponent}
]

 export const routing: ModuleWithProviders<Object> = RouterModule.forRoot(APP_ROUTES);