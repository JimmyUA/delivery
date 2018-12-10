import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UiService} from './services/ui/ui.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Zakupayko';
  showMenu = false;
  darkModeActive: boolean;

  constructor(private http: HttpClient, public ui: UiService) {
  }

  ngOnInit(): void {
    const options = {headers: {'Content-Type': 'application/json'}};
    this.http.post('http://localhost:8090/add',
      '{"id": null, "name": "Timur"}',
      options)
      .subscribe(data => {
      console.log(data);
    });

    this.http.get('http://localhost:8090/all').subscribe(data => {
      console.log(data);
    });

    this.ui.darkModeState.subscribe((value) => {
      this.darkModeActive = value;
    });
  }

  toggleMenu() {
    this.showMenu = !this.showMenu;
  }

  modeToggleSwitch() {
    this.ui.darkModeState.next(!this.darkModeActive);
  }
}
