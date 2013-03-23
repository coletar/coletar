package br.org.coletar.domain

import grails.test.mixin.Mock
import grails.validation.Validateable

@Validateable
class Donator {

    static hasMany = [addresses: Address]


    User user
    Address defaultAddress

    //TODO: Business Rule - If exists some address must exist a defaultAddress
    //TODO: Business Rule - when save first address, save as defaultAddress too
    //TODO: Business Rule - when remove all address, remove defaultAddress too
    //TODO: Business Rule - when remove all address, remove defaultAddress too
    //TODO: Business Rule - when remove default address from addressList, update with first address available
    //TODO: Business Rule - always validate if default address exists inside addresses collection (verify if its possible with inList constraint)
    //TODO: Business Rule - put AddressList in readOnly mode and create methods to add/update/remove address with all previous rules
    //TODO: Create tests for all this rules

    static constraints = {
        user nullable: false
        addresses nullable: true
        defaultAddress nullable: true
    }

    def hasAddress(){
        return (addresses != null && addresses.size() > 0)?true:false
    }

}
