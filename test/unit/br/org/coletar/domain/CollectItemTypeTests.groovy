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

        def collectCollectItemType = new CollectItemType(
                name: "Oleo",
                unitOfMeasurement: "Litro",
                limitValue: 1,
                description: "Pode ser medido em litros"
        )

        assert collectCollectItemType.validate()

    }

    void testConstraintsAttributesNameUnitOfMeasurementelUniqueSuccess() {

        //create existing CollectCollectItemType
        def existingCollectItemType = new CollectItemType(
                name: "Material reciclavel",
                unitOfMeasurement: "Kg",
                limitValue: 1,
                description: "Pode ser medido em Kilos"
        )


        mockForConstraintsTests(CollectItemType,[existingCollectItemType])

        def newCollectItemType = new CollectItemType(
                name: "Material reciclavel",
                unitOfMeasurement: "m3",
                limitValue: 1,
                description: "Pode ser medido em Metros cubicos"
        )

        assert newCollectItemType.validate()

    }

    void testConstraintsAttributesNameUnitOfMeasurementelUniqueFail() {

        //create existing CollectCollectItemType
        def existingCollectItemType = new CollectItemType(
                name: "Oleo",
                unitOfMeasurement: "Litro",
                limitValue: 1,
                description: "Pode ser medido em litros"
        )


        mockForConstraintsTests(CollectItemType,[existingCollectItemType])

        def newCollectItemType = new CollectItemType(
                name: "Oleo",
                unitOfMeasurement: "Litro",
                limitValue: 2,
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
        assert collectCollectItemType.errors.errorCount == 4
        assert "nullable" == collectCollectItemType.errors["name"]
        assert "nullable" == collectCollectItemType.errors["unitOfMeasurement"]
        assert "nullable" == collectCollectItemType.errors["limitValue"]
        assert "nullable" == collectCollectItemType.errors["description"]

    }

    void testConstraintBlankFail() {

        //prepare MOC for testing
        mockForConstraintsTests(CollectItemType)

        def collectCollectItemType = new CollectItemType(
                name: "    ",
                unitOfMeasurement: " ",
                limitValue: 1,
                description: " "
        )

        assert !collectCollectItemType.validate()
        assert collectCollectItemType.errors.errorCount == 3
        assert "blank" == collectCollectItemType.errors["name"]
        assert "blank" == collectCollectItemType.errors["unitOfMeasurement"]
        assert "blank" == collectCollectItemType.errors["description"]

    }


    void testConstraintLimitValue(){

        //prepare MOC for testing
        mockForConstraintsTests(CollectItemType)

        def collectCollectItemType = new CollectItemType(
                name: "Oleo",
                unitOfMeasurement: "Litro",
                limitValue: 0,
                description: "Pode ser medido em litros"
        )

        assert !collectCollectItemType.validate()
        assert collectCollectItemType.errors.errorCount == 1
        assert "min" == collectCollectItemType.errors["limitValue"]

        collectCollectItemType = new CollectItemType(
                name: "Oleo",
                unitOfMeasurement: "Litro",
                limitValue: -1,
                description: "Pode ser medido em litros"
        )

        assert !collectCollectItemType.validate()
        assert collectCollectItemType.errors.errorCount == 1
        assert "min" == collectCollectItemType.errors["limitValue"]

    }




}
