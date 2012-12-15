package br.org.coletar.domain

import br.org.coletar.domain.Donator
import br.org.coletar.domain.User
import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(Donator)
@Mock(User)
class DonatorTests {

    //TODO: create test for hasAddress method

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

        //create an existing user for unique test
        def user = new User(name: "Saulo Andrade",
                            email: "saulo@gmail.com",
                            password: "123456")

        def donator = new Donator(user: user)
        assert donator.validate()
    }


}
