package br.org.coletar.domain

import grails.validation.Validateable

@Validateable
class PreScheduling {

    Date date
    Donator donator
    ItemType itemType
    Integer amount
    String phoneNumber
    Address address

    static constraints = {
    }
}
