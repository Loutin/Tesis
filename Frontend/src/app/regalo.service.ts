import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegaloService {

  constructor() { }

  baseUrl = "http://localhost:3000"

  async getRegalosPorCategoria(category: string) {
    const res = await fetch(`${this.baseUrl}/products/type/${category}`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    });

    if (res.status !== 200) {
      console.log("Error al obtener los regalos");
      return [];
    }

    return await res.json();
  }
}
