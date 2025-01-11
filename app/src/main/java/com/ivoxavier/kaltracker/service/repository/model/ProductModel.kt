package com.ivoxavier.kaltracker.service.repository.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ProductModel : Serializable {
    @SerializedName("product")
    var product: Product? = null
}

class Product: Serializable  {
    @SerializedName("product_name")
    var productName: String = ""

    @SerializedName("nutriscore_grade")
    var nutriscoreGrade: String? = null

    @SerializedName("nova_groups")
    var novaGroups: String? = null

    @SerializedName("nutriments")
    var nutriments: Nutriments? = null
}

class Nutriments: Serializable  {
    @SerializedName("energy_value")
    var energyValue: String? = null

    @SerializedName("energy-kcal_value")
    var energyKcalValue: String? = null

    @SerializedName("fat_100g")
    var fat100g: String? = null

    @SerializedName("proteins_100g")
    var proteins100g: String? = null

    @SerializedName("carbohydrates_100g")
    var carbohydrates100g: String? = null
}