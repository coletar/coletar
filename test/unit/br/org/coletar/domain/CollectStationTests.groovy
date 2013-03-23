package br.org.coletar.domain



import grails.test.mixin.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(CollectStation)
@Mock([Address,CollectStation])
class CollectStationTests {

    void testConstraintAttributesNullableFail() {

        //prepare MOC for testing
        mockForConstraintsTests(CollectStation)

        //test will fail because all paramaters are null
        def collectStation = new CollectStation()

        assert !collectStation.validate()
        assert collectStation.errors.errorCount == 4
        assert "nullable" == collectStation.errors["name"]
        assert "nullable" == collectStation.errors["email"]
        assert "nullable" == collectStation.errors["phoneNumber"]
        assert "nullable" == collectStation.errors["address"]
    }

    void testConstraintEmailFail() {

        //prepare MOC for testing
        mockForConstraintsTests(CollectStation)

        def collectStation = new CollectStation(address: new Address(),
                                                name: "nome",
                                                phoneNumber: "22222222",
                                                email: "test   ")

        assert !collectStation.validate()
        assert collectStation.errors.errorCount == 1
        assert "email" == collectStation.errors["email"]

        collectStation.email = "test"
        assert !collectStation.validate()
        assert collectStation.errors.errorCount == 1
        assert "email" == collectStation.errors["email"]

        collectStation.email = "test@"
        assert !collectStation.validate()
        assert collectStation.errors.errorCount == 1
        assert "email" == collectStation.errors["email"]

        collectStation.email = "test@test"
        assert !collectStation.validate()
        assert collectStation.errors.errorCount == 1
        assert "email" == collectStation.errors["email"]


        collectStation.email = "test@test."
        assert !collectStation.validate()
        assert collectStation.errors.errorCount == 1
        assert "email" == collectStation.errors["email"]

    }


    void testConstraintAttributesBlankFail() {

        //prepare MOC for testing
        mockForConstraintsTests(CollectStation)

        //test will fail because all paramaters are null
        def collectStation = new CollectStation(name: " ",
                                                phoneNumber: " ",
                                                address: new Address(),
                                                email: "  ")

        assert !collectStation.validate()
        assert collectStation.errors.errorCount == 3
        assert "blank" == collectStation.errors["name"]
        assert "blank" == collectStation.errors["email"]
        assert "blank" == collectStation.errors["phoneNumber"]

    }

    void testConstraintSuccess() {

        //prepare MOC for testing
        mockForConstraintsTests(CollectStation)

        def collectStation = new CollectStation(address: new Address(),
                name: "Eduard Phil",
                phoneNumber: "22222222",
                email: "eduard.phill@gmailes.com")

        assert collectStation.validate()
    }
}
