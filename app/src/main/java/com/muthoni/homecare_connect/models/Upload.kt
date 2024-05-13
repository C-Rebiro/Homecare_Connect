package com.muthoni.homecare_connect.models

class Upload {
    var name: String = ""
    var charge: String = ""
    var imageUrl: String = ""
    var id: String = ""

    constructor(name: String, charge: String, imageUrl: String, id: String) {

        this.name = name
        this.charge = charge
        this.imageUrl = imageUrl
        this.id = id

    }
    constructor()
}