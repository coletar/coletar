package br.org.coletar.domain

import br.org.coletar.domain.User
import grails.test.mixin.TestFor

/**
 * Created with IntelliJ IDEA.
 * User: sauloandrade
 * Date: 12/2/12
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 */
@TestFor(User)
class UserTests {

    void testConstraintMinPasswordSucess() {

        //prepare MOC for testing
        mockForConstraintsTests(User)

        //test will fail because all paramaters are null
        def user = new User(name: "saulo",
                email: "saulo@teste.com",
                password: "12345")
        assert user.validate()
    }

    void testConstraintMaxPasswordSucess() {

        //prepare MOC for testing
        mockForConstraintsTests(User)

        //test will fail because all paramaters are null
        def user = new User(name: "saulo",
                email: "saulo@teste.com",
                password: "123456789012345")
        assert user.validate()
    }


    void testConstraintAttributesNullableFail() {

        //prepare MOC for testing
        mockForConstraintsTests(User,)

        //test will fail because all paramaters are null
        def user = new User()

        assert !user.validate()
        assert user.errors.errorCount == 3
        assert "nullable" == user.errors["name"]
        assert "nullable" == user.errors["email"]
        assert "nullable" == user.errors["password"]

    }

    void testConstraintsAttributesBlankFail() {

        //prepare MOC for testing
        mockForConstraintsTests(User)

        //test will fail because all paramaters are blank
        def user = new User(name: "",
                email: "",
                password: "")

        assert !user.validate()
        assert user.errors.errorCount == 3
        assert "blank" == user.errors["name"]
        assert "blank" == user.errors["email"]
        assert "blank" == user.errors["password"]


        //test will fail because all paramaters are with spaces
        user = new User(name: "    ",
                email: "   ",
                password: "    ")

        assert !user.validate()
        assert user.errors.errorCount == 3
        assert "blank" == user.errors["name"]
        assert "blank" == user.errors["email"]
        assert "blank" == user.errors["password"]


    }

    void testConstraintsAttributeEmailUniqueFail() {

        //create existing user
        def userExisting = new User(name: "saulo",
                email: "saulo@teste.com",
                password: "1323456")

        mockForConstraintsTests(User,[userExisting])

        def user = new User(name: "saulo2",
                email: "saulo@teste.com",
                password: "13234567")

        assert !user.validate()
        assert user.errors.errorCount == 1
        assert "unique" == user.errors["email"]

    }

    void testConstraintsAttributePasswordMinSizeFail() {

        mockForConstraintsTests(User)

        def user = new User(name: "saulo2",
                email: "saulo@teste.com",
                password: "1324")

        assert !user.validate()
        assert user.errors.errorCount == 1
        assert "size" == user.errors["password"]

    }

    void testConstraintsAttributePasswordMaxSizeFail() {

        mockForConstraintsTests(User)

        def user = new User(name: "saulo2",
                email: "saulo@teste.com",
                password: "1324567890123456")

        assert !user.validate()
        assert user.errors.errorCount == 1
        assert "size" == user.errors["password"]

    }


    void testConstraintsAttributeEmailFail() {

        //prepare MOC for testing
        mockForConstraintsTests(User)

        //test will fail because email is invalid
        def user = new User(name: "Saulo",
                email: "saulo",
                password: "123456")

        assert !user.validate()
        assert user.errors.errorCount == 1
        assert "email" == user.errors["email"]

        //test will fail because email is invalid
        user = new User(name: "Saulo",
                email: "@saulo.com",
                password: "123456")
        assert !user.validate()
        assert user.errors.errorCount == 1
        assert "email" == user.errors["email"]

        //test will fail because email is invalid
        user = new User(name: "Saulo",
                email: "saulo@.com",
                password: "123456")
        assert !user.validate()
        assert user.errors.errorCount == 1
        assert "email" == user.errors["email"]

        //test will fail because email is invalid
        user = new User(name: "Saulo",
                email: "saulo@saulo",
                password: "123456")
        assert !user.validate()
        assert user.errors.errorCount == 1
        assert "email" == user.errors["email"]


        //test will fail because email is invalid
        user = new User(name: "Saulo",
                email: "saulo@saulo.",
                password: "123456")
        assert !user.validate()
        assert user.errors.errorCount == 1
        assert "email" == user.errors["email"]

        //test will fail because email is invalid
        user = new User(name: "Saulo",
                email: "saulo@saulo.w",
                password: "123456")
        assert !user.validate()
        assert user.errors.errorCount == 1
        assert "email" == user.errors["email"]

    }





}
