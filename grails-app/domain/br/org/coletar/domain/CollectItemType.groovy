package br.org.coletar.domain

import grails.validation.Validateable

@Validateable
class CollectItemType {

    static hasMany = [itemTypeLimitsForCollectStation: ItemTypeLimitsForCollectStation]

    String name
    String unitOfMeasurement
    String description

    static constraints = {
        name blank: false
        unitOfMeasurement blank: false
        name unique: 'unitOfMeasurement'
        description blank: false
        itemTypeLimitsForCollectStation nullable: true
    }
}
