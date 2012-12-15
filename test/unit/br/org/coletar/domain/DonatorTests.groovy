package br.org.coletar.domain

import br.org.coletar.domain.Donator
import br.org.coletar.domain.User
import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(Donator)
@Mock([User,Address])
class DonatorTests {


    void testHasAddressWithExistentAddress(){

        //create a list with address
        def address1 = new Address(
                street: "Street name",
                houseNumber:"380",
                adjunct:"apt 5401",
                district:"Andarai",
                zipCode:"200000",
                longitude:-85.0067,
                latitude:-65.1478
        )

        def address2 = new Address(
                street: "Street name 2",
                houseNumber:"381",
                adjunct:"apt 5402",
                district:"Andarai",
                zipCode:"200000",
                longitude:-56.9534,
                latitude:-98.5394
        )

        def listAddresses = [address1,address2]

        //put address list in donator
        def donator = new Donator(user: new User(),
                                  addresses: listAddresses )

        //verify if hasAddress is true
        assert donator.hasAddress()

    }

    void testHasAddressWithoutAddress(){

        //put address list in donator
        def donator = new Donator(user: new User())

        //verify if hasAddress is false
        assert !donator.hasAddress()

    }


    void testConstraintUserNullableFail() {

        //prepare MOC for testing
        mockForConstraintsTests(Donator)

        def donator = new Donator()
        assert !donator.validate()
        assert donator.errors.errorCount == 1
        assert "nullable" == donator.errors["user"]
    }

    void testConstraintSuccess() {

        //prepare MOC for testing
        mockForConstraintsTests(Donator)

        def donator = new Donator(user: new User())
        assert donator.validate()
    }


}
