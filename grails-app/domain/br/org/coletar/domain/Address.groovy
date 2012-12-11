package br.org.coletar.domain

import grails.validation.Validateable

/**
 * Created with IntelliJ IDEA.
 * User: saulo
 * Date: 10/12/12
 * Time: 19:44
 * To change this template use File | Settings | File Templates.
 */
@Validateable
class Address {

    String street
    String houseNumber
    String adjunct
    String neighborhoodOrDistrict
    String zipCode
    Double latitude
    Double longitude

    static constraints = {
        street blank: false
        houseNumber blank: false
        adjunct nullable: true
        neighborhoodOrDistrict blank: false
        zipCode blank: false
        latitude nullable: true
        longitude nullable: true
    }

    def isGeoreferenced(){
        return (this.latitude != null && this.longitude != null)
    }

}
