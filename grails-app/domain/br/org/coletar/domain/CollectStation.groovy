package br.org.coletar.domain

import grails.validation.Validateable

@Validateable
class CollectStation {

    static hasMany = [collectionStationsItemTypesLimits: ItemTypeLimitsForCollectionStation]

    String name
    String phoneNumber
    String email
    Address address

    static constraints = {
        name blank: false
        phoneNumber nullable: false
        email nullable: false
    }
}
