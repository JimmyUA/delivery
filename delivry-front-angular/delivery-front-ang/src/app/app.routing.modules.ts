import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TestComponent} from './test/test.component';
import {TestchildComponent} from './testchild/testchild.component';

const routes: Routes = [
  { path: 'test', component: TestComponent, children: [
    { path: 'child', component: TestchildComponent}
  ]}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
