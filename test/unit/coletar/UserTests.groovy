package coletar

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import org.junit.runner.RunWith

/**
 * Created with IntelliJ IDEA.
 * User: sauloandrade
 * Date: 12/2/12
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 */
@TestFor(User)
class UserTests {


    void testConstraintAttributesNullableFail() {

        //create an existing user for unique test
        def existingUser = new User(name: "Saulo Andrade",
                                    email: "sauloandrade@gmail.com",
                                    password: "123456")

        //prepare MOC for testing
        mockForConstraintsTests(User, [existingUser])

        //test will fail because all paramaters are null
        def user = new User()
        assert !user.validate()
        assert "nullable" == user.errors["name"]
        assert "nullable" == user.errors["email"]
        assert "nullable" == user.errors["password"]

    }

    void testConstraintsAttributesBlankFail() {

        //create an existing user for unique test
        def existingUser = new User(name: "Saulo Andrade",
                email: "sauloandrade@gmail.com",
                password: "123456")

        //prepare MOC for testing
        mockForConstraintsTests(User, [existingUser])

        //test will fail because all paramaters are blank
        def user = new User(name: "",
                email: "",
                password: "")
        assert !user.validate()
        assert "blank" == user.errors["name"]
        assert "blank" == user.errors["email"]
        assert "blank" == user.errors["password"]

        //test will fail because all paramaters are with spaces
        user = new User(name: "    ",
                email: "   ",
                password: "    ")
        assert !user.validate()
        assert "blank" == user.errors["name"]
        assert "blank" == user.errors["email"]
        assert "blank" == user.errors["password"]


    }


    void testConstraintsAttributeEmailFail() {

        //create an existing user for unique test
        def existingUser = new User(name: "Saulo Andrade",
                email: "sauloandrade@gmail.com",
                password: "123456")

        //prepare MOC for testing
        mockForConstraintsTests(User, [existingUser])

        //test will fail because email is invalid
        def user = new User(name: "Saulo",
                email: "saulo",
                password: "123456")
        assert !user.validate()
        assert "email" == user.errors["email"]
        assert user.errors.size == 1


    }


}
