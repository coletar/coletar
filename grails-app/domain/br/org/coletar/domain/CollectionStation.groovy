package br.org.coletar.domain

class CollectionStation {

    static hasMany = [collectionStationsItemTypesLimits: CollectionStationItemTypeLimits]

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
