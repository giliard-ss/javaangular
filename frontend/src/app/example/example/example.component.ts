import { ExampleService } from '../services/example.service';
import { ExampleSource } from '../model/examplesource';
import { Component } from '@angular/core';
import { catchError, delay, first, Observable, of, tap } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

@Component({
  selector: 'app-principal',
  templateUrl: './example.component.html',
  styleUrls: ['./example.component.scss']
})

export class ExampleComponent {
  displayedColumns = ['id', 'name']
  dataSource$:Observable<ExampleSource[]>;


  constructor(
    private exampleService : ExampleService,
    public dialog: MatDialog) {
    this.dataSource$ = this.exampleService.list().pipe(
      catchError(e=>{
        this.onError('Erro ao carregar lista!');
        return of([]);
      }),
      first(), //só interessa a primeira resposta vinda do backend. Isso fecha a conexao
      delay(1000),
      tap(data=>console.log(data))
    );
  }

  onError(errorMessage:string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMessage,
    });
  }
}
