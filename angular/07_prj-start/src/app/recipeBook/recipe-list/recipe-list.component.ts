import { Component, OnInit } from '@angular/core';
import { Recipe } from 'src/app/model/recipe.model';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {
  recipes : Recipe[] = [
    new Recipe('Arroz con Leche', 'Arroz con leche delicioso', 'https://spicysouthernkitchen.com/wp-content/uploads/Rice-Pudding-2.jpg'),
    new Recipe('Pan Cacero', 'Pan Cacero para Semana Santa', 'https://img-global.cpcdn.com/recipes/a0f4eea3b0f70b40/1200x630cq70/photo.jpg'),
    new Recipe('Sushi', 'Sushi de Atun' ,'https://www.kikkoman.com/homecook/search/recipe/img/00005163.jpg'),

  ];
  constructor() { }

  ngOnInit(): void {
  }

}
