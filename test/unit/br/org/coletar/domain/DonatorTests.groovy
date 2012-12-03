package br.org.coletar.domain

import br.org.coletar.domain.Donator
import br.org.coletar.domain.User
import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(Donator)
@Mock(User)
class DonatorTests {

    void testConstraintUserNullableFail() {

        //create an existing user for unique test
        def existingUser = new User(name: "Saulo Andrade",
                email: "sauloandrade@gmail.com",
                password: "123456")

        def existingDonator = new Donator(user: existingUser)

        //prepare MOC for testing
        mockForConstraintsTests(Donator, [existingDonator])

        def donator = new Donator()
        assert !donator.validate()
        assert "nullable" == donator.errors["user"]
    }

    void testConstraintSucess() {

        //create an existing user for unique test
        def existingUser = new User(name: "Saulo Andrade",
                email: "sauloandrade@gmail.com",
                password: "123456")

        def existingDonator = new Donator(user: existingUser)

        //prepare MOC for testing
        mockForConstraintsTests(Donator, [existingDonator])

        //create an existing user for unique test
        def user = new User(name: "Saulo Andrade",
                email: "sauloandrade@gmail.com",
                password: "123456")

        def donator = new Donator(user: user)
        assert donator.validate()
    }


}
