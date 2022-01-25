export class Avis {
  private _id:number= 0

  constructor(private _nom: string, private _description: string, private _note: number, private _auteur: string, private _image: string){}

  public get nom() {
    return this._nom;
  }

  public get description(){
    return this._description
  }

  public get note(){
    return this._note
  }

  public get auteur(){
    return this._auteur;
  }

  public get image(){
    return this._image;
  }


}
