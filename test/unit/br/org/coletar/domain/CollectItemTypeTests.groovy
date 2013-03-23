package br.org.coletar.domain

import grails.test.mixin.TestFor

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(CollectItemType)
class CollectItemTypeTests {

    void testConstraintSuccess() {

        //prepare MOC for testing
        mockForConstraintsTests(CollectItemType)

        //success test without itemTypeLimitsForCollectStation collection
        def collectItemType = new CollectItemType(
                name: "Oleo",
                unitOfMeasurement: "Litro",
                description: "Pode ser medido em litros"
        )

        assert collectItemType.validate()

        //success test with itemTypeLimitsForCollectStation collection
        //TODO: missing add success tests with itemTypeLimitsForCollectStation

    }

    void testConstraintsAttributesNameUnitOfMeasurementUniqueSuccess() {

        //create existent CollectCollectItemType
        def existentCollectItemType = new CollectItemType(
                name: "Material reciclavel",
                unitOfMeasurement: "Kg",
                description: "Pode ser medido em Kilos"
        )


        mockForConstraintsTests(CollectItemType,[existentCollectItemType])

        def newCollectItemType = new CollectItemType(
                name: "Material reciclavel",
                unitOfMeasurement: "M3",
                description: "Pode ser medido em Metros cubicos"
        )

        assert newCollectItemType.validate()

    }

    void testConstraintsAttributesNameUnitOfMeasurementelUniqueFail() {

        //create existent CollectCollectItemType
        def existentCollectItemType = new CollectItemType(
                name: "Oleo",
                unitOfMeasurement: "Litro",
                description: "Pode ser medido em litros"
        )


        mockForConstraintsTests(CollectItemType,[existentCollectItemType])

        def newCollectItemType = new CollectItemType(
                name: "Oleo",
                unitOfMeasurement: "Litro",
                description: "Pode ser medido em litros tambem"
        )

        assert !newCollectItemType.validate()
        assert newCollectItemType.errors.errorCount == 1
        assert "unique" == newCollectItemType.errors["name"]

    }

    void testConstraintNullableFail() {

        //prepare MOC for testing
        mockForConstraintsTests(CollectItemType)

        def collectItemType = new CollectItemType()

        assert !collectItemType.validate()
        assert collectItemType.errors.errorCount == 3
        assert "nullable" == collectItemType.errors["name"]
        assert "nullable" == collectItemType.errors["unitOfMeasurement"]
        assert "nullable" == collectItemType.errors["description"]

    }

    void testConstraintBlankFail() {

        //prepare MOC for testing
        mockForConstraintsTests(CollectItemType)

        def collectItemType = new CollectItemType(
                name: "    ",
                unitOfMeasurement: " ",
                description: " "
        )

        assert !collectItemType.validate()
        assert collectItemType.errors.errorCount == 3
        assert "blank" == collectItemType.errors["name"]
        assert "blank" == collectItemType.errors["unitOfMeasurement"]
        assert "blank" == collectItemType.errors["description"]

    }

}
