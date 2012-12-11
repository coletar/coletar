package br.org.coletar.domain

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

/**
 * Created with IntelliJ IDEA.
 * User: saulo
 * Date: 10/12/12
 * Time: 20:29
 * To change this template use File | Settings | File Templates.
 */
@TestFor(Address)
@Mock(Address)
class AddressTest {

    void testIsGeoreferenced(){

        //not georeferenced tests
        def address = new Address()
        assert !address.isGeoreferenced()

        address = new Address(latitude: 67.8287)
        assert !address.isGeoreferenced()

        address = new Address(longitude: -89.7689)
        assert !address.isGeoreferenced()

        //georeferenced test
        address = new Address(latitude: 67.8287,
                              longitude: -89.7689)
        assert address.isGeoreferenced()




    }

    /*street: "Street name",
    houseNumber:"380",
    adjunct:"apt 5401",
    neighborhoodOrDistrict:"Andarai",
    zipCode:"200000",
    longitude:-85.0067*/

}
