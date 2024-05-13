package com.muthoni.homecare_connect.models

class User {

    var name: String=""
    var email:String=""
    var pass:String=""
    var confirmpass: String=""
    var userType: Boolean =true



    constructor(name: String, email:String, pass:String, confirmpass:String,userType:Boolean){
        this.name=name
        this.email=email
        this.pass=pass
        this.confirmpass=confirmpass
        this.userType=userType


    }
    constructor()
}