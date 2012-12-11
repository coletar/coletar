package br.org.coletar.domain

import grails.validation.Validateable

@Validateable
class ItemType {

    String name
    String unitOfMeasurement
    Integer limitValue
    String description

    static constraints = {
        name blank: false
        unitOfMeasurement blank: false
        name unique: 'unitOfMeasurement'
        limitValue min: 1
        description blank: false
    }
}
