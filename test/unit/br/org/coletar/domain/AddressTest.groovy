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

    void testConstraintSuccess(){

        //prepare MOC for testing
        mockForConstraintsTests(Address)

        //complete properties must validate
        def address = new Address(
                street: "Street name",
                houseNumber:"380",
                adjunct:"apt 5401",
                district:"Andarai",
                zipCode:"200000",
                longitude:-85.0067,
                latitude:-65.1478
        )
        assert address.validate()


        //without adjunct properties must validate
        address = new Address(
                street: "Street name",
                houseNumber:"380",
                district:"Andarai",
                zipCode:"200000",
                longitude:-85.0067,
                latitude:-65.1478
        )
        assert address.validate()


        //without adjunct and longitude
        // properties must validate
        address = new Address(
                street: "Street name",
                houseNumber:"380",
                district:"Andarai",
                zipCode:"200000",
                latitude:-65.1478
        )
        assert address.validate()


        //without adjunct,longitude and latitude
        //properties must validate
        address = new Address(
                street: "Street name",
                houseNumber:"380",
                district:"Andarai",
                zipCode:"200000",
        )
        assert address.validate()

    }




}
