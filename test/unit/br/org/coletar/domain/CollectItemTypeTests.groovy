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

        //success test without collectionStationsItemTypesLimits collection
        def collectCollectItemType = new CollectItemType(
                name: "Oleo",
                unitOfMeasurement: "Litro",
                description: "Pode ser medido em litros"
        )

        assert collectCollectItemType.validate()

        ////success test with collectionStationsItemTypesLimits collection
        //TODO: missing add success tests with collectionStationsItemTypesLimits

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

        def collectCollectItemType = new CollectItemType()

        assert !collectCollectItemType.validate()
        assert collectCollectItemType.errors.errorCount == 3
        assert "nullable" == collectCollectItemType.errors["name"]
        assert "nullable" == collectCollectItemType.errors["unitOfMeasurement"]
        assert "nullable" == collectCollectItemType.errors["description"]

    }

    void testConstraintBlankFail() {

        //prepare MOC for testing
        mockForConstraintsTests(CollectItemType)

        def collectCollectItemType = new CollectItemType(
                name: "    ",
                unitOfMeasurement: " ",
                description: " "
        )

        assert !collectCollectItemType.validate()
        assert collectCollectItemType.errors.errorCount == 3
        assert "blank" == collectCollectItemType.errors["name"]
        assert "blank" == collectCollectItemType.errors["unitOfMeasurement"]
        assert "blank" == collectCollectItemType.errors["description"]

    }

}
