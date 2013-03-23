package br.org.coletar.domain

import grails.validation.Validateable

@Validateable
class CollectStation {

    static hasMany = [itemTypeLimitsForCollectStation: ItemTypeLimitsForCollectStation]

    String name
    String phoneNumber
    String email
    Address address

    static constraints = {
        name blank: false
        phoneNumber blank: false
        email email: true, blank: false
        address nullable: false
    }
}
