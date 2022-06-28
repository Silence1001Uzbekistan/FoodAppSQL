package uz.silence.foodappsql.CLASS

class Food {

    var id: Int? = null
    var foodName: String? = null
    var mustProduct: String? = null
    var foodSystem: String? = null


    constructor(id: Int?, foodName: String?, mustProduct: String?, foodSystem: String?) {
        this.id = id
        this.foodName = foodName
        this.mustProduct = mustProduct
        this.foodSystem = foodSystem
    }

    constructor(foodName: String?, mustProduct: String?, foodSystem: String?) {
        this.foodName = foodName
        this.mustProduct = mustProduct
        this.foodSystem = foodSystem
    }

    constructor()
}